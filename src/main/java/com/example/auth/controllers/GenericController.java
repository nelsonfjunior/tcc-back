package com.example.auth.controllers;

import jakarta.validation.constraints.Positive;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.auth.services.GenericServiceTypes;

import java.util.List;
import java.util.UUID;

@Validated
@RestController
public abstract class GenericController<TEntity, TResponse, TRequest> {

    private final GenericServiceTypes<TResponse, TRequest> genericService;

    protected GenericController(GenericServiceTypes<TResponse, TRequest> genericService) {
        this.genericService = genericService;
    }

    @GetMapping
    public ResponseEntity<List<TResponse>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(genericService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TResponse> findById(@PathVariable UUID id) {
        return ResponseEntity.status(HttpStatus.OK).body(genericService.findById(id));
    }

    @PostMapping
    public ResponseEntity<TResponse> save(@RequestBody TRequest entity) {
        return ResponseEntity.status(HttpStatus.CREATED).body(genericService.save(entity));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TResponse> update(@PathVariable @Positive UUID id, @RequestBody TRequest entity) {
        return ResponseEntity.status(HttpStatus.OK).body(genericService.update(id, entity));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> remove(@PathVariable UUID id) {
        genericService.remove(id);
        if (genericService.findById(id) == null) {
            return ResponseEntity.status(HttpStatus.OK).body("Excluído");
        }else{
            return ResponseEntity.status(HttpStatus.NOT_MODIFIED).body("Registro não pôde ser excluído");
        }
    }
}