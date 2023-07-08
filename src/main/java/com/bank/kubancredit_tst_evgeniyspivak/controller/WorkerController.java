package com.bank.kubancredit_tst_evgeniyspivak.controller;

import com.bank.kubancredit_tst_evgeniyspivak.DTO.NewWorkerDTO;
import com.bank.kubancredit_tst_evgeniyspivak.DTO.WorkerFullDTO;
import com.bank.kubancredit_tst_evgeniyspivak.service.WorkerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/workers")
@RequiredArgsConstructor
public class WorkerController {

    private final WorkerService workerService;

    @GetMapping
    public List<WorkerFullDTO> getAllWorkers() {
        return workerService.getAllWorkers();
    }

    @GetMapping("/{id}")
    public WorkerFullDTO getWorker(@PathVariable Integer id) {
        return workerService.getWorker(id);
    }

    @PostMapping
    public void addWorker(@RequestBody NewWorkerDTO newWorker) {
        workerService.addWorker(newWorker);
    }

    @DeleteMapping("/{id}")
    public void deleteWorker(@PathVariable Integer id) {
        workerService.deleteWorker(id);
    }


}
