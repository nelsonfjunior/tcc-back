package com.example.auth.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.example.auth.domain.group.Group;
import com.example.auth.domain.group.GroupRequestDTO;
import com.example.auth.domain.group.GroupResponseDTO;
import com.example.auth.domain.publish.Publish;
import com.example.auth.domain.user.User;
import com.example.auth.domain.user.UserResponseDTO;
import com.example.auth.exceptions.PadraoException;
import com.example.auth.repositories.UserRepository;
import com.example.auth.utils.Utils;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class GroupMapper implements GenericMapper<Group, GroupResponseDTO, GroupRequestDTO> {
    private final UserRepository userRepository;

    @Override
    public GroupResponseDTO toDTO(Group obj) {
        if (obj == null)
            return null;

        UserResponseDTO user = new UserResponseDTO(
                obj.getAdm().getId(),
                obj.getAdm().getName(),
                obj.getAdm().getLogin(),
                Utils.bytesToBase64(obj.getAdm().getImage()),
                obj.getAdm().getRole());

        List<UserResponseDTO> users = obj.getUsers().stream().map(currUser -> {
            return new UserResponseDTO(
                    currUser.getId(),
                    currUser.getName(),
                    currUser.getLogin(),
                    Utils.bytesToBase64(currUser.getImage()),
                    currUser.getRole());
        }).toList();

        return new GroupResponseDTO(obj.getId(), user, obj.getDescription(), Utils.bytesToBase64(obj.getImage()),
                obj.getImage_name(), obj.getName(), users);
    }

    @Override
    public Group toEntity(GroupRequestDTO obj) {
        if (obj == null)
            return null;

        List<User> user = new ArrayList<>();
        List<Publish> publish = new ArrayList<>();
        User adm = userRepository.findById(obj.adm()).orElseThrow(() -> new PadraoException("Registro não encontrado"));

        return new Group(
                    obj.id(), 
                    obj.name(), 
                    obj.description(), 
                    obj.image_name(), 
                    Utils.multipartToBytes(obj.image()),
                    adm, 
                    user, 
                    publish);
    }
}
