package com.example.auth.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.auth.domain.group.Group;
import com.example.auth.domain.group.GroupRequestDTO;
import com.example.auth.domain.group.GroupResponseDTO;
import com.example.auth.domain.publish.PublishRequestDTO;
import com.example.auth.exceptions.PadraoException;
import com.example.auth.services.GenericServiceTypes;
import com.example.auth.services.GroupService;

@RestController
@RequestMapping("/api/group")
public class GroupController extends GenericController<Group, GroupResponseDTO, GroupRequestDTO> {
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

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<GroupResponseDTO> update(@PathVariable String id, @ModelAttribute GroupRequestDTO req) {
        return ResponseEntity.status(HttpStatus.CREATED).body(groupService.update(id, req));
    }
    
    @PostMapping("/publish")
    public ResponseEntity<String> savePublish(@ModelAttribute PublishRequestDTO req) {
        try {
            groupService.savePublish(req);
            return ResponseEntity.status(HttpStatus.CREATED).body("Publicação criada com sucesso");
        } catch (Exception e) {
            System.out.println(e);
            throw new PadraoException("Erro ao criar publicação, tente novamente.");
        }
    }
    
}