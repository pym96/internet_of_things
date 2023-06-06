package com.example.fuwuwaibao.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@Data
@NoArgsConstructor
@AllArgsConstructor
public class VendingMachine {

        private Boolean is_opened;

        private String open_the_door;

        private Integer label_num;

        private String label_id;

        private String machine_id;

        private Boolean can_use;
}
