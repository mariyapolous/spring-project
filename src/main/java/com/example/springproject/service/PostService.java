package com.example.springproject.service;

import com.example.springproject.domain.entity.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PostService {

    Page<Post> get(Long userId, Pageable pageable);

    Post getAndInitialize(Long id);

    Post create(Long userId, Post post);

    Post update(Long postId, Post post);

    void delete(Long userId, Long postId);
}
