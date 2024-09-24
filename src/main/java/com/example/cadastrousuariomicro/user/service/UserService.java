package com.example.cadastrousuariomicro.user.service;

import com.example.cadastrousuariomicro.user.model.UserDto;
import com.example.cadastrousuariomicro.user.model.UserEntity;
import com.example.cadastrousuariomicro.user.model.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final KafkaTemplate<String, String> kafkaTemplate;

    public UserService(KafkaTemplate<String, String> kafkaTemplate,UserRepository userRepository) {
        this.kafkaTemplate = kafkaTemplate;
        this.userRepository = userRepository;
    }

    public ResponseEntity<String> save(UserDto user) {

        userRepository.save(new UserEntity(user));
        kafkaTemplate.send("users", UUID.randomUUID().toString(), user.getEmail());

        return ResponseEntity.ok("Sucesso!");
    }
}
