package com.example.auth.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.auth.domain.group.Group;
import com.example.auth.domain.group.GroupRequestDTO;
import com.example.auth.domain.group.GroupResponseDTO;
import com.example.auth.services.GenericServiceTypes;

@RestController
@RequestMapping("/api/group")
public class GroupController extends GenericController<Group, GroupResponseDTO, GroupRequestDTO>{

    protected GroupController(GenericServiceTypes<GroupResponseDTO, GroupRequestDTO> genericService) {
        super(genericService);
    }

}