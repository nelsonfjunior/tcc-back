package com.example.auth.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.auth.domain.group.Group;

@Repository
public interface GroupRepository extends JpaRepository<Group, String> {

}
