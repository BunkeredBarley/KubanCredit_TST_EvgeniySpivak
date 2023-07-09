package com.bank.kubancredit_tst_evgeniyspivak.service;


import com.bank.kubancredit_tst_evgeniyspivak.DTO.*;

import java.util.List;

public interface TaskService {

    List<TaskShortDTO> getAllTasks ();

    TaskFullDTO getTask(int id);

    void addNewTask(NewTaskRequestDTO newTask);

    void modifyTask(int id, TaskModifyDTO taskModify);

    void setWorkerOnTask(SetWorkerOnTaskDTO setWorkerOnTaskDTO);

    void deleteTask(int id);

}
