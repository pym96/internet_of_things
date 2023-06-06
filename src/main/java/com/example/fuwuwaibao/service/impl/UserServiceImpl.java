/**
 *
 *
 */

package com.example.fuwuwaibao.service.impl;

import com.example.fuwuwaibao.mapper.UserMapper;
import com.example.fuwuwaibao.pojo.User;
import com.example.fuwuwaibao.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public User userLogin(String json_str) throws JsonProcessingException {
        return null;
    }

    @Override
    public int testInsert(String test_num) throws JsonProcessingException {
        ObjectMapper userMapper = new ObjectMapper();
        User user = userMapper.readValue(test_num,User.class);
        System.out.println(user);

        int u = this.userMapper.insertTestDemo(user.getTest_num());
        if(u != 1){
            System.out.println("插入数据失败");
        }else{
            System.out.println("插入数据成功");
        }
        return u;
    }

    @Override
    public boolean insertUserInfo(String openid, String session_key) {

        boolean result = userMapper.insertOpenIdAndSessionKey(openid,session_key);
        
        return result;
    }

    @Override
    public List<User> printOutTest() {
        return userMapper.selectAlltest();
    }
}
