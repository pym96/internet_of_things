package com.example.fuwuwaibao.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Drink {
    private String drink_name;
    private Float drink_price;
    private String drink_tag;
    private String drink_left;
}
