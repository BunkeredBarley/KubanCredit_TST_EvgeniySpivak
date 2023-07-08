package com.bank.kubancredit_tst_evgeniyspivak.mapper;

import com.bank.kubancredit_tst_evgeniyspivak.DTO.TaskShortDTO;
import com.bank.kubancredit_tst_evgeniyspivak.entity.Task;

public class TaskToTaskShortDTOMapper {

    public static TaskShortDTO taskToTaskShortDTO(Task task) {
        return new TaskShortDTO(task.getId(),
                task.getDescription(),
                task.getStatus());
    }

}
