package com.bank.kubancredit_tst_evgeniyspivak.service;

import com.bank.kubancredit_tst_evgeniyspivak.DAO.TaskDAO;
import com.bank.kubancredit_tst_evgeniyspivak.DAO.WorkerDAO;
import com.bank.kubancredit_tst_evgeniyspivak.DTO.WorkerFullDTO;
import com.bank.kubancredit_tst_evgeniyspivak.entity.Task;
import com.bank.kubancredit_tst_evgeniyspivak.entity.Worker;
import com.bank.kubancredit_tst_evgeniyspivak.mapper.WorkerToWorkerFullDTOMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WorkerServiceImpl implements WorkerService {

    private final TaskDAO taskDAO;
    private final WorkerDAO workerDAO;

    @Override
    public List<WorkerFullDTO> getAllWorkers() {
        return null;
    }

    @Override
    public WorkerFullDTO getWorker(int id) {
        Worker worker = workerDAO.getWorker(id);
        List<Task> tasks = taskDAO.getTasksOnWorker(id);

        return WorkerToWorkerFullDTOMapper.workerToWorkerFullDTO(worker, tasks);
    }
}
