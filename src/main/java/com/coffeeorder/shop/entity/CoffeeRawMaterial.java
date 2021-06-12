package com.coffeeorder.shop.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@Getter
@Setter
@Entity
@NoArgsConstructor
public class CoffeeRawMaterial {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private int totalRawMaterialCount;

    public CoffeeRawMaterial(String name, int totalRawMaterialCount) {
        this.name = name;
        this.totalRawMaterialCount = totalRawMaterialCount;
    }
}

