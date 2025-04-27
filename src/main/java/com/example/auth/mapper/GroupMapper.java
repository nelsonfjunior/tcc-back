package com.example.auth.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.example.auth.domain.group.Group;
import com.example.auth.domain.group.GroupRequestDTO;
import com.example.auth.domain.group.GroupResponseDTO;

@Mapper(componentModel = "spring")
public interface GroupMapper extends GenericMapper<Group, GroupResponseDTO, GroupRequestDTO> {
    @Override
    @Mapping(target = "adm.id", source = "adm")
    Group toEntity(GroupRequestDTO dto);
}

