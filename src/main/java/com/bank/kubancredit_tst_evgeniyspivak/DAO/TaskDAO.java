package com.bank.kubancredit_tst_evgeniyspivak.DAO;

import com.bank.kubancredit_tst_evgeniyspivak.DTO.TaskModifyDTO;
import com.bank.kubancredit_tst_evgeniyspivak.entity.Task;

import java.util.List;

public interface TaskDAO {

    List<Task> getAllTasks();

    Task getTask(int id);

    void modifyTask(int id, TaskModifyDTO taskModify);

    void setWorkerOnTask(int taskId, int workerId);

    List<Task> getTasksOnWorker(int workerId);

}
