package com.example.fuwuwaibao.mapper;

import com.example.fuwuwaibao.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.jmx.export.annotation.ManagedOperationParameter;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Author : Pan Jiaxiang
 * Date : 2023 / 3 / 22
 * Comment : This is the java file for sql manipulation
 */
@Repository
public interface UserMapper {
    int insertUserInfo(@Param("openid")String openid,
                       @Param("session_key")String session_key,
                       @Param("unionid")String unionId);

    // 数据库测试
    int insertTestDemo(@Param("test_num") String test_num);


    // 将用户的openId和session_key插入到数据库中
    boolean insertOpenIdAndSessionKey(@Param("openid") String openid,
                                      @Param("session_key") String session_key);

    List<User> selectAlltest();
}
