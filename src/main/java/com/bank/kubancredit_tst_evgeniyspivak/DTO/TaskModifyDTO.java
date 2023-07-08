package com.bank.kubancredit_tst_evgeniyspivak.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class TaskModifyDTO {

    private String title;
    private String description;
    private LocalDateTime get_time;
    private String status;

}
