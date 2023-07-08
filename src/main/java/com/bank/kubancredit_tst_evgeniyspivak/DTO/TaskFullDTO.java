package com.bank.kubancredit_tst_evgeniyspivak.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalTime;

@Data
@AllArgsConstructor
public class TaskFullDTO {

    private int id;
    private String title;
    private String description;
    private LocalTime get_time;
    private String status;
    private String performer;

}
