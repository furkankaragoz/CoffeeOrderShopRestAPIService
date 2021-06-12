package com.coffeeorder.shop;

import com.coffeeorder.shop.entity.Coffee;
import com.coffeeorder.shop.entity.CoffeeRawMaterial;
import com.coffeeorder.shop.entity.CoffeeRecipe;
import com.coffeeorder.shop.repository.CoffeeRawMaterialRepository;
import com.coffeeorder.shop.repository.CoffeeRecipeRepository;
import com.coffeeorder.shop.repository.CoffeeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@EnableJpaAuditing
public class CoffeeOrderShopRestApiServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CoffeeOrderShopRestApiServiceApplication.class, args);
    }


    @Bean
    CommandLineRunner createInitialCoffees(CoffeeRepository coffeeRepository, CoffeeRawMaterialRepository coffeeRawMaterialRepository, CoffeeRecipeRepository coffeeRecipeRepository) {
        return args -> {

            // Coffees and prices

            Coffee espresso = coffeeRepository.save(new Coffee("ESPRESSO",7));
            Coffee dEspresso = coffeeRepository.save(new Coffee("Double Espresso",12));
            Coffee americano = coffeeRepository.save(new Coffee("Americano",12));
            Coffee cappuccino = coffeeRepository.save(new Coffee("Cappuccino",12));
            Coffee latte = coffeeRepository.save(new Coffee("Caffe Latte",13));
            Coffee mocha = coffeeRepository.save(new Coffee("Mocha",10));
            Coffee hwater = coffeeRepository.save(new Coffee("Hot Water",3));

            // Coffee System rawmaterial and total counts

            CoffeeRawMaterial espressoRawMaterial =
                    coffeeRawMaterialRepository.save(new CoffeeRawMaterial("Espresso",10));
            CoffeeRawMaterial  hotWaterRawMaterial =
                    coffeeRawMaterialRepository.save(new CoffeeRawMaterial("Hot Water",10));
            CoffeeRawMaterial steamedMilkRawMaterial =
                    coffeeRawMaterialRepository.save(new CoffeeRawMaterial("Steamed Milk",10));
            CoffeeRawMaterial milkFoamMaterial =
                    coffeeRawMaterialRepository.save(new CoffeeRawMaterial("Milk Foam",10));
            CoffeeRawMaterial hotChocalateMaterial =
                    coffeeRawMaterialRepository.save(new CoffeeRawMaterial("Hot Chocolate ",10));

            // Raw materials needed by a coffee

            coffeeRecipeRepository.save(new CoffeeRecipe(espresso,espressoRawMaterial,1));
            coffeeRecipeRepository.save(new CoffeeRecipe(dEspresso,espressoRawMaterial,2));
            coffeeRecipeRepository.save(new CoffeeRecipe(americano,espressoRawMaterial,1));
            coffeeRecipeRepository.save(new CoffeeRecipe(americano,hotWaterRawMaterial,4));
            coffeeRecipeRepository.save(new CoffeeRecipe(cappuccino,espressoRawMaterial,1));
            coffeeRecipeRepository.save(new CoffeeRecipe(cappuccino,steamedMilkRawMaterial,2));
            coffeeRecipeRepository.save(new CoffeeRecipe(cappuccino,milkFoamMaterial,2));
            coffeeRecipeRepository.save(new CoffeeRecipe(latte,espressoRawMaterial,1));
            coffeeRecipeRepository.save(new CoffeeRecipe(latte,steamedMilkRawMaterial,3));
            coffeeRecipeRepository.save(new CoffeeRecipe(latte,milkFoamMaterial,1));
            coffeeRecipeRepository.save(new CoffeeRecipe(mocha,espressoRawMaterial,1));
            coffeeRecipeRepository.save(new CoffeeRecipe(mocha,steamedMilkRawMaterial,1));
            coffeeRecipeRepository.save(new CoffeeRecipe(mocha,milkFoamMaterial,1));
            coffeeRecipeRepository.save(new CoffeeRecipe(mocha,hotChocalateMaterial,2));
            coffeeRecipeRepository.save(new CoffeeRecipe(hwater,hotWaterRawMaterial,5));

        };
    }

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.coffeeorder.shop"))
                .build();
    }

}
