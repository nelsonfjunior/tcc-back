package com.example.auth.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.example.auth.domain.publish.Publish;
import com.example.auth.domain.publish.PublishRequestDTO;
import com.example.auth.domain.publish.PublishResponseDTO;

@Mapper(componentModel = "spring")
public interface PublishMapper extends GenericMapper<Publish, PublishResponseDTO, PublishRequestDTO> {
    @Override
    @Mapping(target = "author", source = "author.id")
    PublishResponseDTO toDTO(Publish obj);
}
