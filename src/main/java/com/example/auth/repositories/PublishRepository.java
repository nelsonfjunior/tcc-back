package com.example.auth.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.auth.domain.publish.Publish;

public interface PublishRepository extends JpaRepository<Publish, String>{
    
}
