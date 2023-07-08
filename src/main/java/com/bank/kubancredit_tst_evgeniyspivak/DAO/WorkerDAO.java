package com.bank.kubancredit_tst_evgeniyspivak.DAO;

import com.bank.kubancredit_tst_evgeniyspivak.entity.Worker;

public interface WorkerDAO {

    Worker getWorker(int id);

    Worker getWorkerOnTask(int taskId);

}
