package com.example.auth.mapper;

public interface GenericMapper<TEntity, TResponse, TRequest> {
    TResponse toDTO(TEntity obj);
    TEntity toEntity(TRequest obj);
}
