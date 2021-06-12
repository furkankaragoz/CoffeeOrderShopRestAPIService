package com.coffeeorder.shop.repository;

import com.coffeeorder.shop.entity.Coffee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoffeeRepository  extends JpaRepository<Coffee,Long> {

    Coffee findByCoffeeName(String name);
}
