package com.encanto_boto.saci_flow.service;

import com.encanto_boto.saci_flow.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.encanto_boto.saci_flow.repository.UserRepository;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    // Método para criar usuários
    public void createUser(User user) {
        userRepository.createUser(user);
    }

    // Método para fazer login
    public boolean login(User user) {
        return userRepository.login(user);
    }

    // Método para buscar todos os usuários
    public List<User> findAll() {
        return userRepository.findAll();
    }

    // Método para buscar um usuário pelo ID
    public User findById(Long id) {
        return userRepository.findById(id);
    }

    // Método para buscar um usuário pelo usuário
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    // Método para buscar um usuário pelo e-mail
    public User findByMail(String mail) {
        return userRepository.findByMail(mail);
    }

    // Método para editar um usuário pelo ID
    public void updateUser(Long id, String username, String mail, String password) {
        userRepository.updateUser(id, username, mail, password);
    }

    // Método para deletar um usuário pelo ID
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    // Método para deletar todos os usuários
    public void deleteAll() {
        userRepository.deleteAll();
    }
}
