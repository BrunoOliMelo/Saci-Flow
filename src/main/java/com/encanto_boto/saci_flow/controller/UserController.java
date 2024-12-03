package com.encanto_boto.saci_flow.controller;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.encanto_boto.saci_flow.model.User;
import com.encanto_boto.saci_flow.service.UserService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    // Método para criar usuários
    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void createUser(@RequestBody User user) {
        userService.createUser(user);
    }

    // Método para buscar todos os usuários
    @GetMapping("/getAll")
    public ResponseEntity<List<User>> findAll() {
        return ResponseEntity.ok(userService.findAll());
    }

    // Método para buscar um usuário pelo ID
    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(userService.findById(id));
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // Método para buscar um usuário pelo usuário
    @GetMapping("/username/{username}")
    public ResponseEntity<User> findByUsername(@PathVariable String username) {
        try {
            return ResponseEntity.ok(userService.findByUsername(username));
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // Método para buscar um usuário pelo e-mail
    @GetMapping("/mail/{mail}")
    public ResponseEntity<User> findByMail(@PathVariable String mail) {
        try {
            return ResponseEntity.ok(userService.findByMail(mail));
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // Método para editar um usuário pelo ID
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateUser(@PathVariable Long id, @RequestBody User user) {
        try {
            userService.updateUser(id, user.getUsername(), user.getMail(), user.getPassword());
        } catch (EntityNotFoundException e) {
            e.printStackTrace();
        }
    }

    // Método para deletar um usuário pelo ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        try {
            userService.deleteById(id);
            return ResponseEntity.noContent().build();
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // Método para deletar todos os usuários
    @DeleteMapping("/deleteAll")
    public ResponseEntity<Void> deleteAll() {
        userService.deleteAll();
        return ResponseEntity.noContent().build();
    }
}
