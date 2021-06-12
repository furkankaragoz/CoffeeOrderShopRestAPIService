package com.coffeeorder.shop.service;


import com.coffeeorder.shop.entity.Coffee;
import com.coffeeorder.shop.repository.CoffeeRepository;
import com.coffeeorder.shop.result.DataResult;
import com.coffeeorder.shop.result.ErrorResult;
import com.coffeeorder.shop.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoffeeOrderService {

    @Autowired
    private CoffeeRepository coffeeRepository;


    public List<Coffee> getAllCoffee() {
        return coffeeRepository.findAll();
    }

    public Coffee getCoffeeByName(String name) {
        Coffee coffee = coffeeRepository.findByCoffeeName(name);
        return coffee;
    }

    public Result createCoffeeOrder (String name) {
        Coffee coffeee = getCoffeeByName(name);
        if(coffeee != null) {
            return new DataResult(coffeee.getCoffeeName() , coffeee.getCoffeeName() + " adlı Kahve siparişiniz hazırlanıyor.");
        }
        else {
            return new ErrorResult( name + " adlı kahve sistemde  bulunmadığından siparişi gerçekleşememiştir.");
        }

    }


}
