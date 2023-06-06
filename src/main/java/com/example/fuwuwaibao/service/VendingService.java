package com.example.fuwuwaibao.service;

import com.fasterxml.jackson.core.JsonProcessingException;

public interface VendingService {

    void openTheDoor(String command) throws JsonProcessingException;

    Boolean getAuth(String phone) throws JsonProcessingException;

}
