package com.example.fuwuwaibao.service.impl;

import com.example.fuwuwaibao.mapper.DrinkMapper;
import com.example.fuwuwaibao.service.DrinkService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DrinkServiceImpl implements DrinkService {

    @Autowired
    DrinkMapper drinkMapper;

    @Override
    public Integer selectDrinkLeft(String drink_name) throws JsonProcessingException {

        Integer drink_left_num = null;

        drink_left_num = drinkMapper.selectDrinksLeft(drink_name);

        if(drink_left_num == null){
            System.out.println("饮料名字为" + drink_name);
            System.out.println("获取 " + drink_name + " 饮料剩余数量失败");
            return -1;
        }else{
            System.out.println("获取" + drink_name + "成功， 剩余数量为" + drink_left_num);
        }

        return drink_left_num;
    }
}
