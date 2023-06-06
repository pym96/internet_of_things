package com.example.fuwuwaibao.service;


import com.example.fuwuwaibao.pojo.User;
import com.fasterxml.jackson.core.JsonProcessingException;

/**
 * @AUTHOR:Pan: Jiaxiang
 * @DATE: 2023/4/7
 * @INTRO: This is the class for Owner table manipulation
 */
public interface OwnerService {

    String getMachineId(String json_str) throws JsonProcessingException;

    Boolean setInvitedState(String phone) throws JsonProcessingException;

    Boolean isInvited(String phone) throws JsonProcessingException;


    void reset(String phone) throws JsonProcessingException;

    void needInput(String cater_id);

    Boolean inputYes(String cater_id);

    Boolean inputReset(String cater_id);

}
