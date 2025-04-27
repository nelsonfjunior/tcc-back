package com.example.auth.controllers;

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
    public ResponseEntity<TResponse> findById(@PathVariable String id) {
        return ResponseEntity.status(HttpStatus.OK).body(genericService.findById(id));
    }

    @PostMapping
    public ResponseEntity<TResponse> save(@RequestBody TRequest entity) {
        return ResponseEntity.status(HttpStatus.CREATED).body(genericService.save(entity));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TResponse> update(@PathVariable String id, @RequestBody TRequest entity) {
        return ResponseEntity.status(HttpStatus.OK).body(genericService.update(id, entity));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> remove(@PathVariable String id) {
        TResponse res = genericService.findById(id);

        if(res == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Registro não encontrado");
        }

        genericService.remove(id);
        return ResponseEntity.status(HttpStatus.OK).body("Registro removido com sucesso");
    }
}