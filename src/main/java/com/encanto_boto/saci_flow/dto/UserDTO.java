package com.encanto_boto.saci_flow.dto;

import java.util.List;

public class UserDTO {
    private Long id;
    private String username;

    // Classe para mostrar apenas o usuário no findAllByUser do TaskService
    public UserDTO(Long id,String username) {
        this.username = username;
        this.id = id;
    }

    // GETTERS AND SETTERS

    // Usuário
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    // ID
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
}
