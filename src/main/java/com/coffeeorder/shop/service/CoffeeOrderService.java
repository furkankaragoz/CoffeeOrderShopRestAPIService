package com.coffeeorder.shop.service;


import com.coffeeorder.shop.entity.Coffee;
import com.coffeeorder.shop.repository.CoffeeRepository;
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


}
