package com.example.springproject.controller;

import com.example.springproject.domain.dto.comment.CommentDTO;
import com.example.springproject.domain.mapper.CommentMapper;
import com.example.springproject.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping
public class CommentController {

    private final CommentMapper commentMapper;
    private final CommentService commentService;

    @GetMapping("users/{userId}/posts/{postId}/comments")
    public Page<CommentDTO> get(@PathVariable Long postId, Pageable pageable) {
        return Optional.of(postId)
                .map(it -> commentService.get(postId, pageable))
                .map(it -> it.map(commentMapper::toDTO))
                .orElseThrow();
    }

    @PostMapping("users/{userId}/posts/{postId}/add-comment")
    public CommentDTO create(@PathVariable Long postId, @RequestBody CommentDTO commentDTO){
        return Optional.of(commentDTO)
                .map(commentMapper::toComment)
                .map(it -> commentService.create(postId, it))
                .map(commentMapper::toDTO).orElseThrow();

    }


}
