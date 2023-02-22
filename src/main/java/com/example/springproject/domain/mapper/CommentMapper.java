package com.example.springproject.domain.mapper;

import com.example.springproject.domain.dto.comment.CommentDTO;
import com.example.springproject.domain.dto.comment.CommentInfoDTO;
import com.example.springproject.domain.entity.Comment;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import static org.mapstruct.NullValuePropertyMappingStrategy.IGNORE;

@Mapper
public interface CommentMapper {

    @Mapping(target = "user", ignore = true)
    @Mapping(target = "post", ignore = true)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "version", ignore = true)
    Comment toComment(CommentDTO commentDTO);

    @Mapping(target = "username", source = "user.username")
    CommentDTO toDTO(Comment comment);

    @Mapping(target = "username", source = "user.username")
    CommentInfoDTO toInfoDTO(Comment comment);

    @BeanMapping(nullValuePropertyMappingStrategy = IGNORE)
    Comment merge(@MappingTarget Comment target, Comment source);

}
