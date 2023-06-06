package com.example.fuwuwaibao.controller;

import com.example.fuwuwaibao.utils.OtherUtils.JsonParseUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.example.fuwuwaibao.pojo.User;
import com.example.fuwuwaibao.service.UserService;
import com.example.fuwuwaibao.utils.WeiXinUtils.WeiXinRequestUtils;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/login")
@Data
public class UserController {

    @Autowired
    UserService userService;

    private JsonParseUtils jsonParse;

    // 向微信端发送请求
    @PostMapping("/userLogin")
    @ResponseBody
    public User login(@RequestBody User user) throws JsonProcessingException{
        String json_str = WeiXinRequestUtils.sendGet(user.getCode());
        System.out.println(json_str);

        jsonParse = new JsonParseUtils();
        var l = jsonParse.getOpenIdAndSessionKey(json_str);
//        userService.insertUserInfo(l.get(0),l.get(1));

        return userService.userLogin(json_str);
    }


}
