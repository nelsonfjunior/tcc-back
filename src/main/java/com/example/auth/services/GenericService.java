package com.example.auth.services;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.auth.exceptions.PadraoException;
import com.example.auth.mapper.GenericMapper;

import java.util.List;

@Service
public abstract class GenericService<TEntity, TResponse, TRequest, RepositorioGenerics extends JpaRepository<TEntity, String>>
        implements GenericServiceTypes<TResponse, TRequest> {

    protected RepositorioGenerics repositoryGenerics;
    protected GenericMapper<TEntity, TResponse, TRequest> genericMapper;

    protected GenericService(RepositorioGenerics repositoryGenerics,
            GenericMapper<TEntity, TResponse, TRequest> genericMapper) {
        this.repositoryGenerics = repositoryGenerics;
        this.genericMapper = genericMapper;
    }

    @Override
    public List<TResponse> findAll() {
        return repositoryGenerics.findAll().stream()
                .map(genericMapper::toDTO)
                .toList();
    }

    @Override
    public TResponse findById(String id) {
        return repositoryGenerics.findById(id)
                .map(genericMapper::toDTO)
                .orElseThrow(() -> new PadraoException("Registro não encontrado"));
    }

    @Override
    public TResponse save(TRequest request) {
        TEntity entity = genericMapper.toEntity(request);
        return genericMapper.toDTO(repositoryGenerics.save(entity));
    }

    @Override
    public TResponse update(String id, TRequest request) {
        try {
            TEntity entity = repositoryGenerics.findById(id).orElseThrow(() -> new PadraoException("Registro não encontrado"));
            entity = genericMapper.toEntity(request);
            return genericMapper.toDTO(repositoryGenerics.save(entity));
        } catch (Exception e) {
            System.out.println(e);
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Erro ao atualizar entidade", e);
        }
    }

    @Override
    public void remove(String id) {
        repositoryGenerics.deleteById(id);
    }
}