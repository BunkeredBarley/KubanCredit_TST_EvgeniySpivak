package com.bank.kubancredit_tst_evgeniyspivak.mapper;

import com.bank.kubancredit_tst_evgeniyspivak.DTO.TaskFullDTO;
import com.bank.kubancredit_tst_evgeniyspivak.entity.Task;
import com.bank.kubancredit_tst_evgeniyspivak.entity.Worker;

import java.util.List;

public class TaskToTaskFullDTOMapper {

    public static TaskFullDTO taskToTaskFullDTO(Task task, List<Worker> workers) {
        return new TaskFullDTO(task.getId(),
                task.getTitle(),
                task.getDescription(),
                task.getGet_time(),
                task.getStatus(),
                workers.stream().map(Worker::getName).toList());
    }

}
