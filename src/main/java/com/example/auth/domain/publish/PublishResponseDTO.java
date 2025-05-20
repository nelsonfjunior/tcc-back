package com.example.auth.domain.publish;

import java.util.List;

import com.example.auth.domain.commentary.Commentary;
import com.example.auth.domain.user.UserResponseDTO;

public record PublishResponseDTO(
    String id,
    String image,
    String description,
    UserResponseDTO author,
    List<Commentary> commentaries
) { }
