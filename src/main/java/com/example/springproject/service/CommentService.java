package com.example.springproject.service;

import com.example.springproject.domain.entity.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CommentService {
    Page<Comment> get(Long postId, Pageable pageable);

    Comment create(Long postId, Comment comment);
}
