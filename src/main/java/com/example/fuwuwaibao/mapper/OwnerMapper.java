package com.example.fuwuwaibao.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface OwnerMapper {

    String getMachineId(@Param("phone") String phone);


    Boolean updateInvited(@Param("phone") String phone);


    Boolean isInvited(@Param("phone") String phone);

    void reset(@Param("phone") String phone);

    Boolean inputed(@Param("cater_id") String cater_id);

    Boolean inputOk(@Param("cater_id") String cater_id);

    Boolean inputReset(@Param("cater_id") String cater_id);

}
