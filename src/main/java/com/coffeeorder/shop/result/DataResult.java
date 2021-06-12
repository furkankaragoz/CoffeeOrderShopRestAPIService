package com.coffeeorder.shop.result;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DataResult <T> extends Result{
    private T data;
    public DataResult(T data, String message) {
        super(message);
        this.data=data;
    }
}