package com.example.auth.mapper;

import org.springframework.stereotype.Component;

import com.example.auth.domain.user.User;
import com.example.auth.domain.user.UserRequestDTO;
import com.example.auth.domain.user.UserResponseDTO;
import com.example.auth.domain.user.UserRole;
import com.example.auth.utils.Utils;

@Component
public class UserMapper implements GenericMapper<User, UserResponseDTO, UserRequestDTO>{
    @Override
    public UserResponseDTO toDTO(User obj) {
        if ( obj == null ) {
            return null;
        }

        String id = obj.getId();
        String name = obj.getName();
        String login = obj.getLogin();
        String image = Utils.bytesToBase64(obj.getImage());
        UserRole role = obj.getRole();

        UserResponseDTO userResponseDTO = new UserResponseDTO( id, name, login, image, role );

        return userResponseDTO;
    }

    @Override
    public User toEntity(UserRequestDTO obj) {
        if ( obj == null ) {
            return null;
        }

        String name = null;
        String login = null;
        byte[] image = null;
        UserRole role = null;

        name = obj.name();
        login = obj.login();
        role = obj.role();

        if(obj.image() != null){
            image = Utils.multipartToBytes(obj.image());
        }

        String password = null;

        User user = new User( name, login, password, role, image );

        return user;
    }
}
