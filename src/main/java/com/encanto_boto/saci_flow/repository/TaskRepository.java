package com.encanto_boto.saci_flow.repository;

import com.encanto_boto.saci_flow.row.mapper.TaskRowMapper;
import com.encanto_boto.saci_flow.model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public class TaskRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    // Método para criar tarefas
    public void createTask(Task task) {
        task.setCompleted(false);
        LocalDateTime now = LocalDateTime.now();
        task.setCreatedAt(now);
        task.setUpdatedAt(now);
        // Método antigo para criar tarefas
//        jdbcTemplate.update("INSERT INTO tasks (title, description, completed, created_at, updated_at) VALUES (?, ?, ?, ?, ?)", task.getTitle(), task.getDescription(), task.isCompleted(), task.getCreatedAt(), task.getUpdatedAt());
//        return task;
        //Novo método para criar tarefas
        jdbcTemplate.update("INSERT INTO tasks (title, description, completed, created_at, updated_at, user_id) VALUES (?, ?, ?, ?, ?, ?)", task.getTitle(), task.getDescription(), task.isCompleted(), task.getCreatedAt(), task.getUpdatedAt(), task.getUser().getId());
    }

    // Método para buscar todas as tarefas
    public List<Task> findAll() {
        String sql = "SELECT t.*, u.username FROM tasks t JOIN users u ON t.user_id = u.id";
        return jdbcTemplate.query(sql, new TaskRowMapper());
    }

    // Método para buscar todas as tarefas de um usuário
    public List<Task> findAllByUser(Long userId) {
        String sql = "SELECT t.*, u.username FROM tasks t JOIN users u ON t.user_id = u.id WHERE t.user_id = ?";
        return jdbcTemplate.query(sql, new TaskRowMapper(), userId);
    }

    // Método para buscar uma tarefa pelo ID
    public Task findById(Long id) {
        String sql = "SELECT t.*, u.username FROM tasks t JOIN users u ON t.user_id = u.id WHERE t.id = ?";
        return jdbcTemplate.queryForObject(sql, new TaskRowMapper(), id);
    }

    // Método para editar uma tarefa pelo ID
    public void updateTask(Long id, String title, String description, boolean completed, LocalDateTime createdAt, LocalDateTime updatedAt) {
        jdbcTemplate.update("UPDATE tasks SET title = ?, description = ?, completed = ?, created_at =?,updated_at = ? WHERE id = ?", title, description, completed, createdAt,updatedAt, id);
    }

    // Método para deletar uma tarefa pelo ID
    public void deleteById(Long id) {
        jdbcTemplate.update("DELETE FROM tasks WHERE id = ?", id);
    }

    // Método para deletar todas as tarefas
    public void deleteAll() {
        jdbcTemplate.update("DELETE FROM tasks");
    }
}