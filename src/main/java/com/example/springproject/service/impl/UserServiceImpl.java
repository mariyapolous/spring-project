package com.example.springproject.service.impl;


import com.example.springproject.domain.entity.User;
import com.example.springproject.domain.mapper.UserMapper;
import com.example.springproject.repository.UserRepository;
import com.example.springproject.service.UserService;
import lombok.RequiredArgsConstructor;
import org.hibernate.Hibernate;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Primary
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public User getAndInitialize(Long id){
        User userinfo = userRepository.getById(id);
        Hibernate.initialize(userinfo);
        Hibernate.initialize(userinfo.getPosts());
        return userinfo;
    }

    @Transactional
    @Override
    public User create(User user) {
        return userRepository.save(user);
    }

    @Transactional
    @Override
    public User update(Long id, User user) {
        return Optional.of(id)
                .map(this::getAndInitialize)
                .map(current -> userMapper.merge(current, user))
                .map(userRepository::save)
                .orElseThrow();
    }


    @Transactional
    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }


}

