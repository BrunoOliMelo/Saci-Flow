package com.encanto_boto.saci_flow.controller;

import com.encanto_boto.saci_flow.model.Task;
import com.encanto_boto.saci_flow.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    @Autowired
    private TaskService taskService;

    // Método para criar uma tarefa
    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void createTask(@RequestBody Task task) {
        taskService.createTask(task);
    }

    // Método para buscar todas as tarefas
    @GetMapping("/getAll")
    public ResponseEntity<List<Task>> findAll() {
        return ResponseEntity.ok(taskService.findAll());
    }

    // Método para buscar todas as tarefas de um usuário
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Task>> findAllByUser(@PathVariable Long userId) {
        return ResponseEntity.ok(taskService.findAllByUser(userId));
    }

    // Método para buscar uma tarefa pelo ID
    @GetMapping("/{id}")
    public ResponseEntity<Task> findById(@PathVariable Long id) {
        return taskService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Método para editar uma tarefa pelo ID
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateTask(@PathVariable Long id, @RequestBody Task task) {
        try {
            taskService.updateTask(id, task.getTitle(), task.getDescription(), task.isCompleted(), task.getCreatedAt(), task.getUpdatedAt());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Método para deletar uma tarefa pelo ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        taskService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    // Método para deletar todas as tarefas
    @DeleteMapping("/deleteAll")
    public ResponseEntity<Void> deleteAll() {
        taskService.deleteAll();
        return ResponseEntity.noContent().build();
    }
}
