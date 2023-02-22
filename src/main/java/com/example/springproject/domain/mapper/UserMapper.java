package com.example.springproject.domain.mapper;

import com.example.springproject.domain.dto.user.UserCreateDTO;
import com.example.springproject.domain.dto.user.UserDTO;
import com.example.springproject.domain.dto.user.UserInfoDTO;
import com.example.springproject.domain.dto.user.UserUpdateDTO;
import com.example.springproject.domain.entity.User;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import static org.mapstruct.NullValuePropertyMappingStrategy.IGNORE;

@Mapper
public interface UserMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "posts", ignore = true)
    @Mapping(target = "comments", ignore = true)
    User fromCreateDTO(UserCreateDTO userCreateDTO);


    @Mapping(target = "id", ignore = true)
    @Mapping(target = "password", ignore = true)
    @Mapping(target = "posts", ignore = true)
    @Mapping(target = "comments", ignore = true)
    User fromUpdateDTO (UserUpdateDTO userUpdateDTO);


    @Mapping(target = "posts", ignore = true)
    @Mapping(target = "password", ignore = true)
    @Mapping(target = "version", ignore = true)
    @Mapping(target = "comments", ignore = true)
    User toUser(UserDTO userDTO);

    UserDTO toDTO(User user);

    UserInfoDTO toInfoDTO(User user);

    @Mapping(target = "posts", ignore = true)
    @BeanMapping(nullValuePropertyMappingStrategy = IGNORE)
    User merge(@MappingTarget User target, User source);


}
