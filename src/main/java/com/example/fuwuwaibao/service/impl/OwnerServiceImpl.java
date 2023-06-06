package com.example.fuwuwaibao.service.impl;

import com.example.fuwuwaibao.mapper.OwnerMapper;
import com.example.fuwuwaibao.service.OwnerService;
import com.example.fuwuwaibao.utils.OtherUtils.JsonParseUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OwnerServiceImpl implements OwnerService {

    @Autowired
    OwnerMapper ownerMapper;

    JsonParseUtils jsonParseUtils;

    @Override
    public String getMachineId(String json_str) throws JsonProcessingException {

        String machine_id = ownerMapper.getMachineId(jsonParseUtils.getMachineId(json_str));

        return "000";
    }

    @Override
    public Boolean setInvitedState(String phone){
            ownerMapper.updateInvited(phone);
            return true;
    }

    @Override
    public Boolean isInvited(String phone) throws JsonProcessingException {
        return ownerMapper.isInvited(phone);
    }

    @Override
    public void reset(String phone) throws JsonProcessingException {
        ownerMapper.reset(phone);
    }


    @Override
    public void needInput(String cater_id) {
            ownerMapper.inputed(cater_id);
    }

    @Override
    public Boolean inputYes(String cater_id) {

        return ownerMapper.inputOk(cater_id);
    }

    @Override
    public Boolean inputReset(String cater_id) {

        ownerMapper.inputReset(cater_id);

        return true;
    }
}
