package com.bank.kubancredit_tst_evgeniyspivak.service;

import com.bank.kubancredit_tst_evgeniyspivak.DAO.TaskDAO;
import com.bank.kubancredit_tst_evgeniyspivak.DAO.WorkerDAO;
import com.bank.kubancredit_tst_evgeniyspivak.DTO.*;
import com.bank.kubancredit_tst_evgeniyspivak.entity.Task;
import com.bank.kubancredit_tst_evgeniyspivak.entity.Worker;
import com.bank.kubancredit_tst_evgeniyspivak.errorHandler.NoSuchEntityException;
import com.bank.kubancredit_tst_evgeniyspivak.mapper.TaskToTaskFullDTOMapper;
import com.bank.kubancredit_tst_evgeniyspivak.mapper.TaskToTaskShortDTOMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {

    private final TaskDAO taskDAO;
    private final WorkerDAO workerDAO;

    private final TaskQueueService taskQueueService;

    @Override
    public List<TaskShortDTO> getAllTasks() {
        List<Task> tasks = taskDAO.getAllTasks();
        return tasks.stream().
                map(TaskToTaskShortDTOMapper::taskToTaskShortDTO).
                toList();
    }

    @Override
    public TaskFullDTO getTask(int id) {
        Task task = taskDAO.getTask(id);
        List<Worker> workers = workerDAO.getWorkersOnTask(id);

        if (task == null) {
            throw new NoSuchEntityException();
        }

        return TaskToTaskFullDTOMapper.taskToTaskFullDTO(task, workers);
    }

    @Override
    public void addNewTask(NewTaskRequestDTO newTask) {
        taskQueueService.addTaskToQueue(newTask);
    }

    @Override
    public void modifyTask(int id, TaskModifyDTO taskModify) {
        taskDAO.modifyTask(id, taskModify);
    }

    @Override
    public void setWorkerOnTask(SetWorkerOnTaskDTO setWorkerOnTaskDTO) {
        taskDAO.setWorkerOnTask(setWorkerOnTaskDTO.getTaskId(),
                setWorkerOnTaskDTO.getWorkerId());
    }

    @Override
    public void deleteTask(int id) {
        taskDAO.deleteTask(id);
    }
}
