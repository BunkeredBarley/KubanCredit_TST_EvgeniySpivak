package com.bank.kubancredit_tst_evgeniyspivak.DAO;

import com.bank.kubancredit_tst_evgeniyspivak.DTO.NewWorkerDTO;
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
    public List<Worker> getAllWorkers() {
        return jdbcTemplate.query("SELECT * FROM workers", new BeanPropertyRowMapper<>(Worker.class));
    }

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

    @Override
    public void addWorker(NewWorkerDTO newWorker) {
        jdbcTemplate.update("""
                INSERT INTO workers (name, position, avatar)
                VALUES (?, ? ,?)""", newWorker.getName(), newWorker.getPosition(), newWorker.getAvatar());
    }

    @Override
    public void updateWorker(int id, NewWorkerDTO updatedWorker) {
        jdbcTemplate.update("""
                UPDATE workers SET name = ?, position = ?, avatar = ?
                WHERE id = ?""",updatedWorker.getName(), updatedWorker.getPosition(),
                updatedWorker.getAvatar(), id);
    }

    @Override
    public void deleteWorker(int id) {
        jdbcTemplate.update("""
                DELETE FROM workers WHERE id = ?;
                DELETE  FROM task_worker WHERE worker_id = ?""", id, id);
    }
}
