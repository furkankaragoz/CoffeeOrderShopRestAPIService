package com.coffeeorder.shop.service;


import com.coffeeorder.shop.dto.CoffeeOrderDTO;
import com.coffeeorder.shop.entity.Coffee;
import com.coffeeorder.shop.entity.CoffeeRawMaterial;
import com.coffeeorder.shop.entity.CoffeeRecipe;
import com.coffeeorder.shop.repository.CoffeeRawMaterialRepository;
import com.coffeeorder.shop.repository.CoffeeRecipeRepository;
import com.coffeeorder.shop.repository.CoffeeRepository;
import com.coffeeorder.shop.result.DataResult;
import com.coffeeorder.shop.result.ErrorResult;
import com.coffeeorder.shop.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CoffeeOrderService {

    @Autowired
    private CoffeeRepository coffeeRepository;

    @Autowired
    private CoffeeRecipeRepository coffeeRecipeRepository;

    @Autowired
    private CoffeeRawMaterialRepository coffeeRawMaterialRepository;


    public List<Coffee> getAllCoffee() {
        return coffeeRepository.findAll();
    }

    public Coffee getCoffeeByName(String name) {
        Coffee coffee = coffeeRepository.findByCoffeeName(name);
        return coffee;
    }

    public List<CoffeeRecipe> getAllCoffeeRecipes(Long id) {
        List<CoffeeRecipe> coffeeRecipeList = coffeeRecipeRepository.findByCoffee_Id(id);
        return coffeeRecipeList;
    }

    public Result createCoffeeOrder (String name) {
        List<CoffeeOrderDTO> coffeeOrderDTOList = new ArrayList<CoffeeOrderDTO>();
        Coffee coffee = getCoffeeByName(name);
        if(coffee != null) {
            List<CoffeeRecipe>  coffeeRecipeList= getAllCoffeeRecipes(coffee.getId());
            for(CoffeeRecipe coffeeRecipe : coffeeRecipeList) {
                Optional<CoffeeRawMaterial> coffeeRawMaterial=
                        coffeeRawMaterialRepository.findById(coffeeRecipe.getCoffeeRawMaterial().getId());
                if(coffeeRawMaterial.isPresent()) {
                    if(coffeeRawMaterial.get().getTotalRawMaterialCount() > coffeeRecipe.getCoffeeRawMaterialAmount()) {
                        CoffeeOrderDTO coffeeOrderDTO = new CoffeeOrderDTO();
                        coffeeOrderDTO.setCoffeeRawMaterial(coffeeRawMaterial.get().getName());
                        coffeeOrderDTO.setCoffeeRawMaterialAmount(coffeeRecipe.getCoffeeRawMaterialAmount());
                        coffeeOrderDTOList.add(coffeeOrderDTO);

                        coffeeRawMaterial.get().setTotalRawMaterialCount(
                                coffeeRawMaterial.get().getTotalRawMaterialCount() - coffeeRecipe.getCoffeeRawMaterialAmount());

                        coffeeRawMaterialRepository.save(coffeeRawMaterial.get());

                    }
                    else {
                        return new ErrorResult(coffeeRawMaterial.get().getName() +
                                "hammaddesi bulunmadığından kahve hazırlanamıyor.");
                    }
                }

            }
            return new DataResult<List<CoffeeOrderDTO>>(coffeeOrderDTOList,
                    coffee.getCoffeeName() + " adlı kahve siparişiniz hazırlanıyor");
        }
        else {
            return new ErrorResult( name + " adlı kahve sistemde  bulunmadığından sipariş gerçekleştirilemedi.");
        }

    }

}
