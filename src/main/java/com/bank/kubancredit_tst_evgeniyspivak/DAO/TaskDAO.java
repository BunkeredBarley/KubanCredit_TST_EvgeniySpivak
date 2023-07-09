package com.bank.kubancredit_tst_evgeniyspivak.DAO;

import com.bank.kubancredit_tst_evgeniyspivak.DTO.NewTaskRequestDTO;
import com.bank.kubancredit_tst_evgeniyspivak.DTO.TaskModifyDTO;
import com.bank.kubancredit_tst_evgeniyspivak.entity.Task;

import java.util.List;

public interface TaskDAO {

    List<Task> getAllTasks();

    Task getTask(int id);

    void addNewTask(NewTaskRequestDTO newTask);

    void modifyTask(int id, TaskModifyDTO taskModify);

    void setWorkerOnTask(int taskId, int workerId);

    List<Task> getTasksOnWorker(int workerId);

    void deleteTask(int id);

}
