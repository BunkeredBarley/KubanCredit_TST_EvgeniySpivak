package com.bank.kubancredit_tst_evgeniyspivak.DAO;

import com.bank.kubancredit_tst_evgeniyspivak.entity.Worker;

import java.util.List;

public interface WorkerDAO {

    Worker getWorker(int id);

    List<Worker> getWorkersOnTask(int taskId);

}
