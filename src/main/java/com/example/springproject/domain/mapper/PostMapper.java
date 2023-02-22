package com.example.springproject.domain.mapper;
import com.example.springproject.domain.dto.post.PostDTO;
import com.example.springproject.domain.dto.post.PostInfoDTO;
import com.example.springproject.domain.entity.Post;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import static org.mapstruct.NullValuePropertyMappingStrategy.IGNORE;


@Mapper
public interface PostMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "version", ignore = true)
    @Mapping(target = "user", ignore = true) //с чего вдруг тут надо игнорить юзера?
    @Mapping(target = "comments", ignore = true) //
    Post toPost(PostDTO postDTO);

    @Mapping(target = "username", source = "user.username")
    PostDTO toDTO(Post post);

    @Mapping(target = "username", source = "user.username")
    PostInfoDTO toInfoDTO(Post post);

    @BeanMapping(nullValuePropertyMappingStrategy = IGNORE)
    Post merge(@MappingTarget Post target, Post source);
}
