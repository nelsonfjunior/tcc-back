package com.example.auth.domain.group;

import org.springframework.web.multipart.MultipartFile;
import com.example.auth.domain.user.UserResponseDTO;

public record GroupRequestDTO(
    String id, 
    String name,
    String description,
    String image_name,
    MultipartFile image,
    UserResponseDTO adm
) {
    
}
