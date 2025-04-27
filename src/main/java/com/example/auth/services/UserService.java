package com.example.auth.services;

import org.springframework.stereotype.Service;

import com.example.auth.domain.user.User;
import com.example.auth.domain.user.UserRequestDTO;
import com.example.auth.domain.user.UserResponseDTO;
import com.example.auth.mapper.UserMapper;
import com.example.auth.repositories.UserRepository;

@Service
public class UserService extends GenericService<User, UserResponseDTO, UserRequestDTO, UserRepository>{

    protected UserService(UserRepository repositoryGenerics, UserMapper genericMapper) {
        super(repositoryGenerics, genericMapper);
    }

}
