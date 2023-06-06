package com.example.fuwuwaibao.service.impl;

import com.example.fuwuwaibao.mapper.VendingMapper;
import com.example.fuwuwaibao.service.VendingService;
import com.example.fuwuwaibao.utils.MqttUtils.Publish;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VendingServiceImpl implements VendingService {

    @Autowired
    VendingMapper vendingMapper;

    @Autowired
    Publish publisher;

    @Override
    public void openTheDoor(String command) throws JsonProcessingException {
        // 这里我们调用Mapping方法向数据库发送开门消息.

        publisher.publish("Control_Door","open");

    }



    @Override
    public Boolean getAuth(String phone) throws JsonProcessingException {



        return true;
    }
}
