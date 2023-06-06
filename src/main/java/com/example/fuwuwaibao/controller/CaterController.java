package com.example.fuwuwaibao.controller;


import com.example.fuwuwaibao.pojo.Owner;
import com.example.fuwuwaibao.service.OwnerService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cater")
public class CaterController {

    @Autowired
    OwnerService ownerService;

    // 1.通过得到CarOwner的货柜名，然后设置到cater表里设置该货柜的权限。
    @PostMapping("/auth")
    @ResponseBody
    public Boolean getAuthority(@RequestBody String phone){
        return true;
    }

    @PostMapping("/invite")
    @ResponseBody
    public Boolean inviteCarOwner(@RequestBody Owner owner) throws JsonProcessingException {

        // 根据前端发送的owner的电话更改车主的是否被邀请信息.
        System.out.println(owner.getPhone());
        ownerService.setInvitedState(owner.getPhone());

        return true;
    }

    @PostMapping("/isinvited")
    @ResponseBody
    public Boolean isInvited(@RequestBody Owner owner) throws JsonProcessingException{
        return ownerService.isInvited(owner.getPhone());
    }

    @PostMapping("/reset")
    @ResponseBody
    public void reset(@RequestBody Owner owner) throws JsonProcessingException{
        System.out.println("得到返回的值为" + owner.getIs_invited());
        System.out.println("Before reset " + owner.getIs_invited());
        ownerService.reset(owner.getPhone());
        System.out.println("After reset " + owner.getIs_invited());
    }

}
