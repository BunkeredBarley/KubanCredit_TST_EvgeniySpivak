package com.bank.kubancredit_tst_evgeniyspivak.service;

import com.bank.kubancredit_tst_evgeniyspivak.DAO.TaskDAO;
import com.bank.kubancredit_tst_evgeniyspivak.DTO.NewTaskRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;

@Component
@RequiredArgsConstructor
public class TaskQueueService {

    private final TaskDAO taskDAO;

    LinkedList<NewTaskRequestDTO> taskQueue = new LinkedList<>();


    public void addTaskToQueue(NewTaskRequestDTO newTask) {
        taskQueue.add(newTask);

        if (taskQueue.size() > 3) {
            flushTasksToDB();
        }
    }

    public NewTaskRequestDTO pollFirstTaskFromQueue() {
        return taskQueue.pollFirst();
    }

    @Transactional
    public void flushTasksToDB() {
        for (int i = 0; i < 3; i++) {
            Thread thread = new Thread(() -> {
                NewTaskRequestDTO newTask = pollFirstTaskFromQueue();
                taskDAO.addNewTask(newTask);
            });
            thread.start();
        }
    }

}
