package com.coffeeorder.shop.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class CoffeeRecipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Coffee coffee;

    @OneToOne
    private CoffeeRawMaterial coffeeRawMaterial;

    private int coffeeRawMaterialAmount;

    public CoffeeRecipe(Coffee coffee, CoffeeRawMaterial coffeeRawMaterial, int coffeeRawMaterialAmount) {
        this.coffee = coffee;
        this.coffeeRawMaterial = coffeeRawMaterial;
        this.coffeeRawMaterialAmount = coffeeRawMaterialAmount;
    }
}

