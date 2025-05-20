package com.example.auth.domain.group;

import java.util.List;

import com.example.auth.domain.user.UserResponseDTO;

public record GroupResponseDTO(
        String id,
        UserResponseDTO adm,
        String description,
        String image,
        String image_name,
        String name,
        List<UserResponseDTO> users) {
}
