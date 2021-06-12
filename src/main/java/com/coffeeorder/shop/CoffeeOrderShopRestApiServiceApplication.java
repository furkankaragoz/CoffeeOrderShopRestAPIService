package com.coffeeorder.shop;

import com.coffeeorder.shop.entity.Coffee;
import com.coffeeorder.shop.repository.CoffeeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CoffeeOrderShopRestApiServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CoffeeOrderShopRestApiServiceApplication.class, args);
    }


    @Bean
    CommandLineRunner createInitialCoffees(CoffeeRepository coffeeRepository) {
        return args -> {
            Coffee espresso = coffeeRepository.save(new Coffee("ESPRESSO",7));
            Coffee dEspresso = coffeeRepository.save(new Coffee("Double Espresso",12));
            Coffee americano = coffeeRepository.save(new Coffee("Americano",12));
            Coffee cappuccino = coffeeRepository.save(new Coffee("Cappuccino",12));
            Coffee latte = coffeeRepository.save(new Coffee("Caffe Latte",13));
            Coffee mocha = coffeeRepository.save(new Coffee("Mocha",10));
            Coffee hwater = coffeeRepository.save(new Coffee("Hot Water",3));

        };
    }

}
