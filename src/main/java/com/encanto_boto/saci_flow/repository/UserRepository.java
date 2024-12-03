package com.encanto_boto.saci_flow.repository;

import com.encanto_boto.saci_flow.model.Task;
import com.encanto_boto.saci_flow.row.mapper.TaskRowMapper;
import com.encanto_boto.saci_flow.row.mapper.UserRowMapper;
import com.encanto_boto.saci_flow.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class UserRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    // Método para criar usuários
    public void createUser(User user) {
        jdbcTemplate.update("INSERT INTO users (username, mail, password) VALUES (?, ?, ?)", user.getUsername(), user.getMail(), user.getPassword());
    }

    // Método para fazer login
    public boolean login(User user) {
        User userDB = jdbcTemplate.queryForObject("SELECT * FROM users WHERE username = ? AND password = ?", new UserRowMapper(), user.getUsername(), user.getPassword());
        return userDB != null;
    }

    // Método para buscar todos os usuários

    public List<User> findAll() {
        List<User> users = jdbcTemplate.query("SELECT * FROM users", new UserRowMapper());
        List<Task> tasks = jdbcTemplate.query("SELECT t.*, u.username FROM tasks t JOIN users u ON t.user_id = u.id", new TaskRowMapper());
        for (User user : users) {
            for (Task task : tasks) {
                if (task.getUserDTO().getId().equals(user.getId())) {
                    user.getTasks().add(task);
                }
            }
        }
        return users;
    }

    // Método para buscar um usuário pelo ID
    public User findById(Long id) {
        User user = jdbcTemplate.queryForObject("SELECT * FROM users WHERE id = ?", new UserRowMapper(), id);
        List<Task> tasks = jdbcTemplate.query("SELECT t.*, u.username FROM tasks t JOIN users u ON t.user_id = u.id", new TaskRowMapper());

        for (Task task : tasks) {
            if (task.getUserDTO().getId().equals(user.getId())) {
                user.getTasks().add(task);
            }
        }
        return user;
    }

    // Método para buscar um usuário pelo usuário
    public User findByUsername(String username) {
        User user = jdbcTemplate.queryForObject("SELECT * FROM users WHERE username = ?", new UserRowMapper(), username);
        List<Task> tasks = jdbcTemplate.query("SELECT t.*, u.username FROM tasks t JOIN users u ON t.user_id = u.id", new TaskRowMapper());

        for (Task task : tasks) {
            if (task.getUserDTO().getId().equals(user.getId())) {
                user.getTasks().add(task);
            }
        }
        return user;
    }

    // Método para buscar um usuário pelo e-mail
    public User findByMail(String mail) {
        User user = jdbcTemplate.queryForObject("SELECT * FROM users WHERE mail = ?", new UserRowMapper(), mail);
        List<Task> tasks = jdbcTemplate.query("SELECT t.*, u.username FROM tasks t JOIN users u ON t.user_id = u.id", new TaskRowMapper());

        for (Task task : tasks) {
            if (task.getUserDTO().getId().equals(user.getId())) {
                user.getTasks().add(task);
            }
        }
        return user;
    }

    // Método para editar um usuário pelo ID
    public void updateUser(Long id, String username, String mail, String password) {
        jdbcTemplate.update("UPDATE users SET username = ?, mail = ?, password = ? WHERE id = ?", username, mail, password, id);
    }

    // Método para deletar um usuário pelo ID
    public void deleteById(Long id) {
        jdbcTemplate.update("DELETE FROM users WHERE id = ?", id);
    }

    // Método para deletar todos os usuários
    public void deleteAll() {
        jdbcTemplate.update("DELETE FROM users");
    }

}