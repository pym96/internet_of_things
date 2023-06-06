package com.example.fuwuwaibao.service;


import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.stereotype.Service;

/**
 * @Author: Pan Jiaxiang
 * @Date: 2023/4/6
 * @INTRO: This is a service for manipulating drinks info
 */
public interface DrinkService {

    Integer selectDrinkLeft(String drink_name) throws JsonProcessingException;

}
