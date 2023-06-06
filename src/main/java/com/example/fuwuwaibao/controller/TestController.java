package com.example.fuwuwaibao.controller;


import com.example.fuwuwaibao.pojo.User;
import com.example.fuwuwaibao.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    UserService userService;

    @PostMapping("/t1")
    @ResponseBody
    public int UserController() throws JsonProcessingException {
        return userService.testInsert("12345");
    }

    @GetMapping("/t2")
    @ResponseBody
    public List<User> u2(){
        return userService.printOutTest();
    }

    @GetMapping
    @ResponseBody
    public String t3() {
        return "HELLO WORLD";
    }


}
