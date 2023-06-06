package com.example.fuwuwaibao.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface VendingMapper {

    void updateAuthority(@Param("machine_id") String machine_id);

    void getAuthority(@Param("machine_id") String machine_id);


}
