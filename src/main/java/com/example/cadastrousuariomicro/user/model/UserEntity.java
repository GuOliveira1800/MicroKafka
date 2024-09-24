package com.example.cadastrousuariomicro.user.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "user")
public class UserEntity {
    @Id
    @GeneratedValue
    private Long id;
    private String nome;
    private String email;
    private String senha;

    public UserEntity(UserDto user) {
        this.id = user.getId();
        this.nome = user.getNome();
        this.email = user.getEmail();
        this.senha = user.getSenha();
    }

    public UserEntity() {

    }
}
