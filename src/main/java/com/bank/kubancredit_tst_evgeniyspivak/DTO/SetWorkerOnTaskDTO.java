package com.bank.kubancredit_tst_evgeniyspivak.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SetWorkerOnTaskDTO {

    private int taskId;
    private int workerId;

}
