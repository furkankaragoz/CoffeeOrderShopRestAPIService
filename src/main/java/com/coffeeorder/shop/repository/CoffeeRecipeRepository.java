package com.coffeeorder.shop.repository;

import com.coffeeorder.shop.entity.CoffeeRecipe;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CoffeeRecipeRepository  extends JpaRepository<CoffeeRecipe,Long> {

    List<CoffeeRecipe> findByCoffee_Id(Long id);
}
