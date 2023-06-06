package com.example.fuwuwaibao.controller;

import com.example.fuwuwaibao.service.OwnerService;
import com.example.fuwuwaibao.utils.MqttUtils.Subscribe;
import org.apache.ibatis.annotations.Param;
import org.bouncycastle.cert.ocsp.Req;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/owner")
public class OwnerController {

    private final String ID = "RFID_ID";
    private final String NUM = "RFID_mun";
    private final String OPEN_THE_DOOR = "Contorl_Door";
    private final String DOOR_SITUATION = "Door_Situatin";

    @Autowired
    OwnerService ownerService;

    @RequestMapping("/getNum")
    @ResponseBody
    public Boolean isLess(){

        return true;
    }

    @RequestMapping("/input")
    @ResponseBody
    public Boolean needInput(@RequestBody String cater_id){

        // 将need input 设为真
        ownerService.needInput(cater_id);
        return true;
    }


    // 供货端监控接口
    @RequestMapping("/inputYes")
    @ResponseBody
    public Boolean inputYes(@RequestBody String cater_id) {

        return ownerService.inputYes(cater_id);
    }



    @RequestMapping("resetInput")
    @ResponseBody
    public Boolean inputReset(@RequestBody String cater_id){
        return ownerService.inputReset(cater_id);
    }


}
