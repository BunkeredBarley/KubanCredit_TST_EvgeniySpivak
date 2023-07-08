package com.bank.kubancredit_tst_evgeniyspivak.service;


import com.bank.kubancredit_tst_evgeniyspivak.DTO.TaskFullDTO;
import com.bank.kubancredit_tst_evgeniyspivak.DTO.TaskShortDTO;

import java.util.List;

public interface TaskService {

    List<TaskShortDTO> getAllTasks ();

    TaskFullDTO getTask(int id);

}
