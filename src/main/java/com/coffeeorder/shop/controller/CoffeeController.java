package com.coffeeorder.shop.controller;


import com.coffeeorder.shop.entity.Coffee;
import com.coffeeorder.shop.service.CoffeeOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api/coffeeorder")
public class CoffeeController {

    @Autowired
    private CoffeeOrderService coffeeOrderService;

    @GetMapping("/allCoffies")
    public List<Coffee> getAllCoffies() {
        return coffeeOrderService.getAllCoffee();
    }


}
