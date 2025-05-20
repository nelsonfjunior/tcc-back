package com.example.auth.utils;

import java.io.IOException;
import java.util.Base64;

import org.springframework.web.multipart.MultipartFile;

public class Utils {
    static public String bytesToBase64(byte[] image) {
        return image != null ? "data:image/png;base64," + Base64.getEncoder().encodeToString(image) : null;
    }

    static public byte[] multipartToBytes(MultipartFile file) {
        try {
            return file != null ? file.getBytes() : null;
        } catch (IOException e) {
            throw new RuntimeException("Erro ao converter MultipartFile para byte[]", e);
        }
    }

    static public byte[] base64ToBytes(String base64) {
        if (base64 == null || base64.isEmpty()) {
            return null;
        }
        String pureBase64 = base64.contains(",") ? base64.split(",")[1] : base64; // Remove prefixo "data:image/png;base64,"
        return Base64.getDecoder().decode(pureBase64);
    }
}
