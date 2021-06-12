package com.coffeeorder.shop.result;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Result {
    private String message;


    public Result(String message) {
        this.message = message;
    }
}
