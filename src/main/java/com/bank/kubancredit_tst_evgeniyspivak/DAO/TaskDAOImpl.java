package com.bank.kubancredit_tst_evgeniyspivak.DAO;

import com.bank.kubancredit_tst_evgeniyspivak.DTO.TaskModifyDTO;
import com.bank.kubancredit_tst_evgeniyspivak.entity.Task;
import com.bank.kubancredit_tst_evgeniyspivak.entity.Worker;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class TaskDAOImpl implements TaskDAO {

    private final JdbcTemplate jdbcTemplate;

    @Override
    public List<Task> getAllTasks() {
        return jdbcTemplate.query("SELECT * FROM tasks", new BeanPropertyRowMapper<>(Task.class));
    }

    @Override
    public Task getTask(int id) {
        return jdbcTemplate.query("SELECT * FROM tasks WHERE id=?",
                new BeanPropertyRowMapper<>(Task.class), id)
                .stream().findAny().orElse(null);
    }

    @Override
    public void modifyTask(int id, TaskModifyDTO taskModify) {
        jdbcTemplate.update("""
                UPDATE tasks
                SET title = ?, description = ?,
                    get_time = ?,
                    status = ?
                WHERE id = ?""", taskModify.getTitle(), taskModify.getDescription(),
                taskModify.getGet_time(), taskModify.getStatus(), id);
    }

    @Override
    public void setWorkerOnTask(int taskId, int workerId) {
        jdbcTemplate.update("""
                INSERT INTO task_worker (task_id, worker_id)
                VALUES (?, ?)""", taskId, workerId);
    }

    @Override
    public List<Task> getTasksOnWorker(int workerId) {
        return jdbcTemplate.query("""
                        SELECT DISTINCT tasks.id, title, description, get_time, status
                        FROM tasks
                        JOIN task_worker ON tasks.id = task_worker.task_id
                        JOIN workers ON task_worker.worker_id = workers.id
                        WHERE workers.id = ?""",
                new BeanPropertyRowMapper<>(Task.class), workerId);
    }
}
