package com.example.auth.mapper;

import org.mapstruct.Mapper;

import com.example.auth.domain.user.User;
import com.example.auth.domain.user.UserRequestDTO;
import com.example.auth.domain.user.UserResponseDTO;

@Mapper(componentModel = "spring")
public interface UserMapper extends GenericMapper<User, UserResponseDTO, UserRequestDTO>{
}