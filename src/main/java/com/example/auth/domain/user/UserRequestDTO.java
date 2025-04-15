package com.example.auth.domain.user;

public record UserRequestDTO(
    String id,
    String name,
    String login,
    String image,
    UserRole role
) {
    
}
