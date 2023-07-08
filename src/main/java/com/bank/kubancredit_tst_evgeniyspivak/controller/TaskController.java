package com.bank.kubancredit_tst_evgeniyspivak.controller;

import com.bank.kubancredit_tst_evgeniyspivak.DTO.TaskShortDTO;
import com.bank.kubancredit_tst_evgeniyspivak.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;


    @GetMapping
    public List<TaskShortDTO> getAllTasks() {
        return taskService.getAllTasks();
    }

}
