package com.example.auth.domain.publish;

import java.util.List;

import com.example.auth.domain.commentary.Commentary;

public record PublishResponseDTO(
    String id,
    String image,
    String description,
    String author,
    List<Commentary> commentaries
) { }
