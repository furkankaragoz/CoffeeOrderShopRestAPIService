package com.coffeeorder.shop.controller;


import com.coffeeorder.shop.entity.Coffee;
import com.coffeeorder.shop.result.Result;
import com.coffeeorder.shop.service.CoffeeOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @GetMapping("/getCoffeePrice/{name}")
    public ResponseEntity<Integer> getCoffeePrice(@PathVariable String name) {

        Coffee coffeee = coffeeOrderService.getCoffeeByName(name);
        if(coffeee == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(coffeee.getCoffeePrice());

    }

    @PostMapping("/createCoffeeOrder/{name}")
    public Result createCoffeeOrder(@PathVariable String name) {

        return coffeeOrderService.createCoffeeOrder(name);

    }


}
