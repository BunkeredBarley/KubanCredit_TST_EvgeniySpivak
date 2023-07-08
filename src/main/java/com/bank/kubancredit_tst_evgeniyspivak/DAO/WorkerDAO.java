package com.bank.kubancredit_tst_evgeniyspivak.DAO;

import com.bank.kubancredit_tst_evgeniyspivak.DTO.NewWorkerDTO;
import com.bank.kubancredit_tst_evgeniyspivak.DTO.WorkerFullDTO;
import com.bank.kubancredit_tst_evgeniyspivak.entity.Worker;

import java.util.List;

public interface WorkerDAO {

    List<Worker> getAllWorkers();

    Worker getWorker(int id);

    List<Worker> getWorkersOnTask(int taskId);

    void addWorker(NewWorkerDTO newWorker);

    void updateWorker(int id, NewWorkerDTO updatedWorker);

    void deleteWorker(int id);

}
