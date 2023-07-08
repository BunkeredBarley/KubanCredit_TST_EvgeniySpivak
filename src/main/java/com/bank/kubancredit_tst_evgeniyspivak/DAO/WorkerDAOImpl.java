package com.bank.kubancredit_tst_evgeniyspivak.DAO;

import com.bank.kubancredit_tst_evgeniyspivak.entity.Task;
import com.bank.kubancredit_tst_evgeniyspivak.entity.Worker;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class WorkerDAOImpl implements WorkerDAO {

    private final JdbcTemplate jdbcTemplate;

    @Override
    public Worker getWorker(int id) {
        return jdbcTemplate.query("SELECT * FROM workers WHERE id=?",
                        new BeanPropertyRowMapper<>(Worker.class), id)
                .stream().findAny().orElse(null);
    }

    @Override
    public List<Worker> getWorkersOnTask(int taskId) {
        return jdbcTemplate.query("""
                        SELECT DISTINCT workers.id, name, position, avatar
                        FROM tasks
                        JOIN task_worker ON tasks.id = task_worker.task_id
                        JOIN workers ON task_worker.worker_id = workers.id
                        WHERE tasks.id = ?""",
                new BeanPropertyRowMapper<>(Worker.class), taskId);
    }
}
