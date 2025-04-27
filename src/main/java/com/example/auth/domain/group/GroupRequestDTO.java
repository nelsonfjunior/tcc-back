package com.example.auth.domain.group;

import org.springframework.web.multipart.MultipartFile;

public record GroupRequestDTO(
        String id,
        String name,
        String description,
        String image_name,
        MultipartFile image,
        String adm) {

}
