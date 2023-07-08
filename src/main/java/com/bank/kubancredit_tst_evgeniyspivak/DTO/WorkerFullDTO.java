package com.bank.kubancredit_tst_evgeniyspivak.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class WorkerFullDTO {

    private int id;
    private String name;
    private String position;
    private String avatar;
    List<TaskShortDTO> tasks;

}
