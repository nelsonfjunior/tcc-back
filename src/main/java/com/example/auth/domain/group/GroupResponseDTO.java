package com.example.auth.domain.group;

import com.example.auth.domain.user.UserResponseDTO;

public record GroupResponseDTO(
        String id,
        UserResponseDTO adm,
        String description,
        String image,
        String image_name,
        String name,
        UserResponseDTO[] users) {
}
