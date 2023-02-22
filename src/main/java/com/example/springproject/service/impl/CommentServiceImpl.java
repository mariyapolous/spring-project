package com.example.springproject.service.impl;

import com.example.springproject.domain.entity.Comment;
import com.example.springproject.domain.entity.Post;
import com.example.springproject.domain.mapper.CommentMapper;
import com.example.springproject.repository.CommentRepository;
import com.example.springproject.service.CommentService;
import com.example.springproject.service.PostService;
import com.example.springproject.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CommentServiceImpl implements CommentService {
    private final CommentRepository commentRepository;
    private final CommentMapper commentMapper;
    private final PostService postService;
    private final UserService userService;

    @Override
    public Page<Comment> get(Long postId, Pageable pageable) {
        return commentRepository.findAllByPostId(postId, pageable);
    }


    @Override
    @Transactional
    public Comment create(Long postId, Comment comment) {
        final Post post = postService.getAndInitialize(postId);
        post.addComment(comment);
        return commentRepository.save(comment);
    }



}
