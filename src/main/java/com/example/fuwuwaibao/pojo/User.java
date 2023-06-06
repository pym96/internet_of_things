package com.example.fuwuwaibao.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private String openid;
    private String session_key;
    private String unionid;
    private String code;
    private String test_num;
}
