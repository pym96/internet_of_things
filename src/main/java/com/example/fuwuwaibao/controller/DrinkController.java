package com.example.fuwuwaibao.controller;

import com.example.fuwuwaibao.pojo.Drink;
import com.example.fuwuwaibao.service.DrinkService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/drinkInfo")
public class DrinkController {
    @Autowired
    DrinkService drinkService;


    @PostMapping("/getCokeLeft")
    @ResponseBody
    public int getCokeDrinkLeft(@RequestBody Drink drink_name) throws JsonProcessingException {
        System.out.println("We get the drink_name front End " + drink_name.getDrink_name());
        return drinkService.selectDrinkLeft(drink_name.getDrink_name());
    }

    @PostMapping("/getNongFuLeft")
    @ResponseBody
    public int getNonfuDrinkLeft(@RequestBody Drink drink) throws JsonProcessingException{
        System.out.println("We get the drink_name from front End " + drink.getDrink_name());
        return drinkService.selectDrinkLeft(drink.getDrink_name());
    }

    @PostMapping("/getPesiLeft")
    @ResponseBody
    public int getPesiDrinkLeft(@RequestBody Drink drink) throws JsonProcessingException{
        System.out.println("We get the drink_name front End " + drink.getDrink_name());
        return drinkService.selectDrinkLeft(drink.getDrink_name());
    }

    @PostMapping("/getRedBullLeft")
    @ResponseBody
    public int getRedBullDrinkLeft(@RequestBody Drink drink_name) throws JsonProcessingException{
        System.out.println("We get the drink_name front End " + drink_name.getDrink_name());
        return drinkService.selectDrinkLeft(drink_name.getDrink_name());
    }

}
