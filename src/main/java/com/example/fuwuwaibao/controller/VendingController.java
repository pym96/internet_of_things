package com.example.fuwuwaibao.controller;

import com.example.fuwuwaibao.utils.MqttUtils.Publish;
import com.example.fuwuwaibao.utils.MqttUtils.Subscribe;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.service.annotation.PostExchange;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/vending")
public class VendingController {

    @Autowired
    Publish publisher;

    @Autowired
    Subscribe subscriber;

    private final String ID = "RFID_ID";
    private final String NUM = "RFID_mun";
    private final String OPEN_THE_DOOR = "Contorl_Door";
    private final String DOOR_SITUATION = "Door_Situatin";

    // 这是司机端绑定柜子后等到饮料id的部分
    @PostMapping("/id")
    @ResponseBody
    public List<String> getId() throws JsonProcessingException {

        System.out.println("开始订阅售卖柜子");
        List<String> lis = new ArrayList<String>(subscriber.get(ID));
        return lis;
    }

    @GetMapping("/num")
    @ResponseBody
    public Integer getNum() throws  JsonProcessingException{
        // 这里return 的值指的是剩余的量.
        System.out.println("开始订阅商品剩余");
        var x = subscriber.get(NUM);

        if(x.size() == 2){
            return 1;
        }

        if(x.size() == 3){
            return 0;
        }
        return 2;
    }


    @GetMapping("/situation")
    @ResponseBody
    public void getSituation() throws JsonProcessingException{

        System.out.println("开始订阅柜子当前状态");

        subscriber.get(DOOR_SITUATION);
    }

    @GetMapping("/open")
    @ResponseBody
    public void openTheDoor()throws JsonProcessingException{

        System.out.println("发布开门指令"); // 应该在一个新线程里边发
        publisher = new Publish();
        System.out.println(publisher);
        publisher.publish(OPEN_THE_DOOR,"open");
    }

}
