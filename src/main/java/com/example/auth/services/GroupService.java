package com.example.auth.services;

import org.springframework.stereotype.Service;

import com.example.auth.domain.group.Group;
import com.example.auth.domain.group.GroupRequestDTO;
import com.example.auth.domain.group.GroupResponseDTO;
import com.example.auth.mapper.GroupMapper;
import com.example.auth.repositories.GroupRepository;

@Service
public class GroupService extends GenericService<Group, GroupResponseDTO, GroupRequestDTO, GroupRepository>{

    protected GroupService(GroupRepository repositoryGenerics, GroupMapper genericMapper) {
        super(repositoryGenerics, genericMapper);
    }

}
