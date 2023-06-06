package com.example.fuwuwaibao;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.fuwuwaibao.mapper")
public class FuWuWaiBaoApplication {

    public static void main(String[] args) {
        System.out.println("进入服务外包");
        SpringApplication.run(FuWuWaiBaoApplication.class, args);
    }

}
