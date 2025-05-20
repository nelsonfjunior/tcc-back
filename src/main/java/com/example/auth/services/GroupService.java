package com.example.auth.services;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.auth.domain.group.Group;
import com.example.auth.domain.group.GroupRequestDTO;
import com.example.auth.domain.group.GroupResponseDTO;
import com.example.auth.domain.publish.Publish;
import com.example.auth.domain.publish.PublishRequestDTO;
import com.example.auth.mapper.GroupMapper;
import com.example.auth.mapper.PublishMapper;
import com.example.auth.repositories.GroupRepository;
import com.example.auth.repositories.PublishRepository;

@Service
public class GroupService extends GenericService<Group, GroupResponseDTO, GroupRequestDTO, GroupRepository>{
    @Autowired
    private PublishRepository publishRepository;

    @Autowired 
    private PublishMapper publishMapper;

    protected GroupService(GroupRepository repositoryGenerics, GroupMapper genericMapper) {
        super(repositoryGenerics, genericMapper);
    }

    public void savePublish(PublishRequestDTO req) {
        Publish obj = publishMapper.toEntity(req);
        obj.setWhenSent(LocalDateTime.now());
        publishRepository.save(obj);       
    }
}
