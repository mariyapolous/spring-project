package com.example.springproject.controller;

import com.example.springproject.domain.dto.user.UserCreateDTO;
import com.example.springproject.domain.dto.user.UserDTO;
import com.example.springproject.domain.dto.user.UserInfoDTO;
import com.example.springproject.domain.dto.user.UserUpdateDTO;
import com.example.springproject.domain.mapper.UserMapper;
import com.example.springproject.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;


@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController{

    private final UserMapper userMapper;
    private final UserService userService;

    @GetMapping("/{userId}")
    public UserDTO getUser(@PathVariable (name="userId") Long id) {
        return Optional.of(id)
                .map(userService::getAndInitialize)
                .map(userMapper::toDTO)
                .orElseThrow();
    }

    @GetMapping("/about/{userId}")
    public UserInfoDTO getUserInfo(@PathVariable (name="userId") Long id) {
        return Optional.of(id)
                .map(userService::getAndInitialize)
                .map(userMapper::toInfoDTO)
                .orElseThrow();
    }

    @PostMapping("/new")
    public UserDTO create(@RequestBody UserCreateDTO userCreateDTO) {


        return Optional.ofNullable(userCreateDTO)
                .map(userMapper::fromCreateDTO)
                .map(userService::create)
                .map(userMapper::toDTO)
                .orElseThrow();
    }

    @PatchMapping("change/{id}")
    public UserDTO update(@PathVariable Long id, @RequestBody UserUpdateDTO userUpdateDTO) {
        return Optional.ofNullable(userUpdateDTO)
                .map(userMapper::fromUpdateDTO)
                .map(toUpdate -> userService.update(id, toUpdate))
                .map(userMapper::toDTO)
                .orElseThrow();
    }

    @DeleteMapping("/{userId}")
    public void delete(@PathVariable (name="userId") Long id) {
        userService.delete(id);
    }

}