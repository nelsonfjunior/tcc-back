package com.example.auth.services;

import jakarta.validation.constraints.Positive;

import java.util.List;
import java.util.UUID;

public interface GenericServiceTypes<TResponse, TRequest> {

    List<TResponse> findAll();

    TResponse findById(UUID id);

    TResponse save(TRequest entity);

    TResponse update(@Positive UUID id, TRequest entity);

    void remove(UUID id);

}