package com.example.auth.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.auth.domain.user.User;
import com.example.auth.domain.user.UserRequestDTO;
import com.example.auth.domain.user.UserResponseDTO;
import com.example.auth.services.GenericServiceTypes;

@RestController
@RequestMapping("/api/user")
public class UserController extends GenericController<User, UserResponseDTO, UserRequestDTO> {
    protected UserController(GenericServiceTypes<UserResponseDTO, UserRequestDTO> genericService) {
        super(genericService);
    }
}