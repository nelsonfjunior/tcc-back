package com.example.auth.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.example.auth.domain.commentary.Commentary;
import com.example.auth.domain.publish.Publish;
import com.example.auth.domain.publish.PublishRequestDTO;
import com.example.auth.domain.publish.PublishResponseDTO;
import com.example.auth.domain.user.UserResponseDTO;
import com.example.auth.utils.Utils;

@Component
public class PublishMapper implements GenericMapper<Publish, PublishResponseDTO, PublishRequestDTO> {
    @Override
    public PublishResponseDTO toDTO(Publish obj) {
        if(obj == null) return null;

        UserResponseDTO user = new UserResponseDTO(
                                    obj.getAuthor().getId(), 
                                    obj.getAuthor().getName(),
                                    obj.getAuthor().getLogin(),
                                    Utils.bytesToBase64(obj.getAuthor().getImage()),
                                    obj.getAuthor().getRole()
                                );

        return new PublishResponseDTO(
                    obj.getId(), 
                    Utils.bytesToBase64(obj.getImage()), 
                    obj.getDescription(), 
                    user, 
                    obj.getCommentaries()
                );
    }

    @Override
    public Publish toEntity(PublishRequestDTO obj) {
        if(obj == null) return null;

        List<Commentary> commentaries = new ArrayList<>();

        return new Publish(
                    obj.id(), 
                    obj.description(), 
                    null,
                    Utils.multipartToBytes(obj.image()),
                    obj.author(),
                    commentaries,
                    obj.group()
                );
    }
}
