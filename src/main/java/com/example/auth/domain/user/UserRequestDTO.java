package com.example.auth.domain.user;

import org.springframework.web.multipart.MultipartFile;

public record UserRequestDTO(
    String id,
    String name,
    String login,
    MultipartFile image,
    UserRole role
) {
    
}
