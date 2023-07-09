package com.bank.kubancredit_tst_evgeniyspivak.controller;

import com.bank.kubancredit_tst_evgeniyspivak.DTO.*;
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

    @PostMapping
    public void addNewTask(@RequestBody NewTaskRequestDTO newTask) {
        taskService.addNewTask(newTask);
    }

    @PutMapping("/{id}")
    public void modifyTask(@PathVariable Integer id, @RequestBody TaskModifyDTO taskModify) {
        taskService.modifyTask(id, taskModify);
    }

    @PostMapping("/set")
    public void setWorkerOnTask(@RequestBody SetWorkerOnTaskDTO setWorkerOnTaskDTO) {
        taskService.setWorkerOnTask(setWorkerOnTaskDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Integer id) {
        taskService.deleteTask(id);
    }

}
