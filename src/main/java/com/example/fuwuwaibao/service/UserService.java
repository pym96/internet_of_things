/**
 * Author : Pan Jiaxiang
 * Date : 2023 / 3 / 22
 * Comment : This is the interface for WX program user to login in.
 */
package com.example.fuwuwaibao.service;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.example.fuwuwaibao.pojo.User;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserService {
    User userLogin(String json_str) throws JsonProcessingException;
    int testInsert(String test_num) throws JsonProcessingException;

    boolean insertUserInfo(String openid, String session_key);
    List<User> printOutTest();
}
