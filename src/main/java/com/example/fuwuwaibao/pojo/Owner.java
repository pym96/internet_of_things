package com.example.fuwuwaibao.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Owner {

    // Part for wechat login in
    private String openid;
    private String session_key;
    private String unionid;

    // Part for business handling
    private String phone;
    private String car_info;

    private Boolean is_invited;

}
