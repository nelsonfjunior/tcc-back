package com.example.auth.domain.user;

public record RegisterDTO(String name, String login, String password, UserRole role, byte[] imagem) {
}
