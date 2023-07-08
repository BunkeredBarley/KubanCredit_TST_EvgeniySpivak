package com.bank.kubancredit_tst_evgeniyspivak.mapper;

import com.bank.kubancredit_tst_evgeniyspivak.DTO.TaskShortDTO;
import com.bank.kubancredit_tst_evgeniyspivak.DTO.WorkerFullDTO;
import com.bank.kubancredit_tst_evgeniyspivak.entity.Task;
import com.bank.kubancredit_tst_evgeniyspivak.entity.Worker;

import java.util.List;

public class WorkerToWorkerFullDTOMapper {

    public static WorkerFullDTO workerToWorkerFullDTO(Worker worker, List<Task> tasks) {
        List<TaskShortDTO> taskShortDTOS = tasks.stream()
                .map(task -> new TaskShortDTO(task.getId(),
                        task.getTitle(),
                        task.getStatus())).toList();


        WorkerFullDTO workerFullDTO = new WorkerFullDTO(
                worker.getId(),
                worker.getName(),
                worker.getPosition(),
                worker.getAvatar(),
                taskShortDTOS
        );

        return workerFullDTO;
    }

}
