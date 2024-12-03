package com.encanto_boto.saci_flow.controller;

import com.encanto_boto.saci_flow.model.User;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.encanto_boto.saci_flow.service.UserService;

@RestController
public class LoginController {
    @Autowired
    private UserService userService;

    // Método para fazer login
    @PostMapping("/login")
    public ResponseEntity<Boolean> login(@RequestBody User user) {
        try {
            if (userService.login(user)) {
                return ResponseEntity.ok(true);
            }
            throw new EntityNotFoundException("Usuário não encontrado");
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
