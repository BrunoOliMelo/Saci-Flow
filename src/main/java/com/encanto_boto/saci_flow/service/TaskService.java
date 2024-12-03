package com.encanto_boto.saci_flow.service;

import com.encanto_boto.saci_flow.model.Task;
import com.encanto_boto.saci_flow.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;

    // Método criar uma tarefa
    public void createTask(Task task) {
        taskRepository.createTask(task);
    }

    // Método para buscar todas as tarefas
    public List<Task> findAll() {
        return taskRepository.findAll();
    }

    // Método para buscar todas as tarefas de um usuário
    public List<Task> findAllByUser(Long userId) {
        return taskRepository.findAllByUser(userId);
    }

    // Método para buscar uma tarefa pelo ID
    public Optional<Task> findById(Long id) {
        return Optional.ofNullable(taskRepository.findById(id));
    }

    // Método para editar uma tarefa pelo ID
    public void updateTask(Long id, String title, String description, boolean completed,LocalDateTime createdAt, LocalDateTime updatedAt) {
        taskRepository.updateTask(id, title, description, completed,createdAt, updatedAt);
    }


    // Método para deletar uma tarefa
    public void deleteById(Long id) {
        taskRepository.deleteById(id);
    }

    // Método para deletar todas as tarefas
    public void deleteAll() {
        taskRepository.deleteAll();
    }
}
