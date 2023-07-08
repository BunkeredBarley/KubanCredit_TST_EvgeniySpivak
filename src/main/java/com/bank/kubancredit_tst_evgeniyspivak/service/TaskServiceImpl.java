package com.bank.kubancredit_tst_evgeniyspivak.service;

import com.bank.kubancredit_tst_evgeniyspivak.DAO.TaskDAO;
import com.bank.kubancredit_tst_evgeniyspivak.DTO.TaskShortDTO;
import com.bank.kubancredit_tst_evgeniyspivak.entity.Task;
import com.bank.kubancredit_tst_evgeniyspivak.mapper.TaskToTaskShortDTOMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {

    private final TaskDAO taskDAO;

    @Override
    public List<TaskShortDTO> getAllTasks() {
        List<Task> tasks = taskDAO.getAllTasks();
        return tasks.stream().
                map(TaskToTaskShortDTOMapper::taskToTaskShortDTO).
                toList();
    }
}
