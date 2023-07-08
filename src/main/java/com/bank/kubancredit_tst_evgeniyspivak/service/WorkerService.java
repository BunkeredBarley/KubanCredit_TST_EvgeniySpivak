package com.bank.kubancredit_tst_evgeniyspivak.service;

import com.bank.kubancredit_tst_evgeniyspivak.DTO.WorkerFullDTO;

import java.util.List;

public interface WorkerService {

    List<WorkerFullDTO> getAllWorkers();

    WorkerFullDTO getWorker(int id);

}
