package com.example.fuwuwaibao.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DrinkMapper {

    // 筛选出特定饮料的剩余数量
    Integer selectDrinksLeft(@Param("drink_name") String drink_name);


}
