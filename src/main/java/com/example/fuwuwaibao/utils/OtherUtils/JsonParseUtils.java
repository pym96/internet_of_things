package com.example.fuwuwaibao.utils.OtherUtils;

import com.example.fuwuwaibao.mapper.UserMapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class JsonParseUtils {
    @Autowired
    UserMapper userMapper;

    public String getMachineId(String json_str) throws JsonProcessingException{
        ObjectMapper objectMapper = new ObjectMapper();


        JsonNode jsonNode = objectMapper.readTree(json_str);

        String phone = jsonNode.get("phone").asText();

        System.out.println("得到的车主电话为" + phone);

        return phone;

    }

    public String getDrinkName(String json_str) throws JsonProcessingException{
        ObjectMapper objectMapper = new ObjectMapper();

        JsonNode jsonNode = objectMapper.readTree(json_str);

        String drink_name = jsonNode.get("drink_name").asText();

        System.out.println("Json 结算后的饮料名字为： " + drink_name);

        return drink_name;
    }

    public List<String> getOpenIdAndSessionKey(String json_str) throws JsonProcessingException {

        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(json_str);

        String session_key = jsonNode.get("session_key").asText();
        String openid = jsonNode.get("openid").asText();

        List<String> listReturn = new ArrayList<>();
        listReturn.add(session_key);
        listReturn.add(openid);

        for(String str: listReturn)
            System.out.println("str" + '\t');

        return listReturn;
    }

}
