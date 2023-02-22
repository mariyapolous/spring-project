package com.example.springproject.service;

import com.example.springproject.domain.entity.User;

public interface UserService {

    User getAndInitialize(Long id);

    User create(User user);

    User update(Long id, User user);

    void delete(Long id);
}
