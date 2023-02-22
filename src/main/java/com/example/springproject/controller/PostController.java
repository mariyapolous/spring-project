package com.example.springproject.controller;

import com.example.springproject.domain.dto.post.PostDTO;
import com.example.springproject.domain.mapper.PostMapper;
import com.example.springproject.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
@RequestMapping
public class PostController {

    private final PostMapper postMapper;
    private final PostService postService;


    @GetMapping("users/{userId}/posts")
    public Page<PostDTO> get(@PathVariable Long userId, Pageable pageable) {
        return Optional.of(userId)
                .map(it -> postService.get(userId, pageable)) //что еще за it???
                .map(it -> it.map(postMapper::toDTO)) //что еще за it???
                .orElseThrow();
    }

    @PostMapping("users/{userId}/posts/create")
    public PostDTO create(@PathVariable Long userId, @RequestBody PostDTO postDTO) {
        return Optional.of(postDTO)
                .map(postMapper::toPost)
                .map(it -> postService.create(userId, it))
                .map(postMapper::toDTO)
                .orElseThrow();
    }

    @PatchMapping("users/{userId}/posts/edit/{postId}")
    public PostDTO update(@PathVariable Long postId, @RequestBody PostDTO postDTO) {
        return Optional.of(postDTO)
                .map(postMapper::toPost)
                .map(it -> postService.update(postId, it))
                .map(postMapper::toDTO)
                .orElseThrow();
    }

    @DeleteMapping("users/{userId}/posts/delete/{postId}")
    public void delete(@PathVariable Long userId, @PathVariable Long postId) {
        postService.delete(userId, postId);
    }


}
