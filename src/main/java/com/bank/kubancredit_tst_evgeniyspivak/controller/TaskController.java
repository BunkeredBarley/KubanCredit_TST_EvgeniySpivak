package com.bank.kubancredit_tst_evgeniyspivak.controller;

import com.bank.kubancredit_tst_evgeniyspivak.DTO.SetWorkerOnTaskDTO;
import com.bank.kubancredit_tst_evgeniyspivak.DTO.TaskFullDTO;
import com.bank.kubancredit_tst_evgeniyspivak.DTO.TaskModifyDTO;
import com.bank.kubancredit_tst_evgeniyspivak.DTO.TaskShortDTO;
import com.bank.kubancredit_tst_evgeniyspivak.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{id}")
    public TaskFullDTO getTask(@PathVariable Integer id) {
        return taskService.getTask(id);
    }

    @PostMapping("/{id}")
    public void modifyTask(@PathVariable Integer id, @RequestBody TaskModifyDTO taskModify) {
        taskService.modifyTask(id, taskModify);
    }

    @PostMapping("/set")
    public void setWorkerOnTask(@RequestBody SetWorkerOnTaskDTO setWorkerOnTaskDTO) {
        taskService.setWorkerOnTask(setWorkerOnTaskDTO);
    }

}
