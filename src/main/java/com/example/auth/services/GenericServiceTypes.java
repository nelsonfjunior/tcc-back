package com.example.auth.services;

import jakarta.validation.constraints.Positive;

import java.util.List;

public interface GenericServiceTypes<TResponse, TRequest> {

    List<TResponse> findAll();

    TResponse findById(String id);

    TResponse save(TRequest entity);

    TResponse update(@Positive String id, TRequest entity);

    void remove(String id);

}