package com.bank.kubancredit_tst_evgeniyspivak.DAO;

import com.bank.kubancredit_tst_evgeniyspivak.DTO.TaskModifyDTO;
import com.bank.kubancredit_tst_evgeniyspivak.entity.Task;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
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
}
