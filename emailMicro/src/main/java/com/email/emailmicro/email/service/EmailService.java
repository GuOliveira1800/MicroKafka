package com.email.emailmicro.email.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    private final JavaMailSender mailSender;

    public EmailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    @KafkaListener(topics = "users", groupId = "email-service-group")
    public void confirmEmail(String email) {
        // Lógica para enviar o email de confirmação de conta
        System.out.println("Bem-vindo(a) " + email + "! Confirme seu cadastro.");
        sendEmail(email, "Confirmação de Cadastro", "Bem-vindo(a) " + email + "! Confirme seu cadastro.");
    }

    private void sendEmail(String to, String subject, String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);
        mailSender.send(message);
    }
}
