package com.coffeeorder.shop.repository;

import com.coffeeorder.shop.entity.CoffeeRecipe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoffeeRecipeRepository  extends JpaRepository<CoffeeRecipe,Long> {
}
