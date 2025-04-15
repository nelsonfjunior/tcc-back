package com.example.auth.domain.user;

public record UserResponseDTO(
    String id,
    String name,
    String login,
    String image,
    UserRole role
) {
    
}
