package com.bank.kubancredit_tst_evgeniyspivak.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
public class TaskFullDTO {

    private int id;
    private String title;
    private String description;
    private LocalDateTime get_time;
    private String status;
    private List<String> performers;

}
