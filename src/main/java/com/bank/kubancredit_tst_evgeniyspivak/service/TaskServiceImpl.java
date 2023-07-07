package com.bank.kubancredit_tst_evgeniyspivak.service;

import com.bank.kubancredit_tst_evgeniyspivak.DAO.TaskDAO;
import com.bank.kubancredit_tst_evgeniyspivak.DTO.TaskShortDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    private TaskDAO taskDAO;

    @Override
    public List<TaskShortDTO> getAllTasks() {
        return null;
    }
}
