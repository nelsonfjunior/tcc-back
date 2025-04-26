package com.example.auth.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.auth.domain.group.Group;
import com.example.auth.domain.group.GroupRequestDTO;
import com.example.auth.domain.group.GroupResponseDTO;
import com.example.auth.services.GenericServiceTypes;
import com.example.auth.services.GroupService;

@RestController
@RequestMapping("/api/group")
public class GroupController extends GenericController<Group, GroupResponseDTO, GroupRequestDTO>{
    @Autowired
    private GroupService groupService;

    protected GroupController(GenericServiceTypes<GroupResponseDTO, GroupRequestDTO> genericService) {
        super(genericService);
    }

    @Override
    @PostMapping
    public ResponseEntity<GroupResponseDTO> save(@ModelAttribute GroupRequestDTO req) {
        return ResponseEntity.status(HttpStatus.CREATED).body(groupService.save(req));
    }
}