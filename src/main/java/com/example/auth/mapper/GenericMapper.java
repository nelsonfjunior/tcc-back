package com.example.auth.mapper;

import java.io.IOException;
import java.util.Base64;

import org.springframework.web.multipart.MultipartFile;

public interface GenericMapper<TEntity, TResponse, TRequest> {
    TResponse toDTO(TEntity obj);
    TEntity toEntity(TRequest obj);

    default String bytesToBase64(byte[] image) {
        return image != null ? "data:image/png;base64," + Base64.getEncoder().encodeToString(image) : null;
    }

    default byte[] multipartToBytes(MultipartFile file) {
        try {
            return file != null ? file.getBytes() : null;
        } catch (IOException e) {
            throw new RuntimeException("Erro ao converter MultipartFile para byte[]", e);
        }
    }
}
