package com.example.auth.domain.publish;

import org.springframework.web.multipart.MultipartFile;

import com.example.auth.domain.group.Group;
import com.example.auth.domain.user.User;

public record PublishRequestDTO(
    MultipartFile image,
    String description,
    User author,
    Group group
) {}
