package com.example.springproject.service.impl;

import com.example.springproject.domain.entity.Post;
import com.example.springproject.domain.entity.User;
import com.example.springproject.domain.mapper.PostMapper;
import com.example.springproject.repository.PostRepository;
import com.example.springproject.service.PostService;
import com.example.springproject.service.UserService;
import lombok.RequiredArgsConstructor;
import org.hibernate.Hibernate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;
    private final PostMapper postMapper;
    private final UserService userService;

    @Override
    public Page<Post> get(Long userId, Pageable pageable) {
        return postRepository.findAllByUserId(userId, pageable);
    }

    @Override
    public Post getAndInitialize(Long id){
        Post postinfo = postRepository.getById(id);
        Hibernate.initialize(postinfo);
        Hibernate.initialize(postinfo.getComments());
        return postinfo;
    }

    @Override
    @Transactional
    public Post create(Long userId, Post post) {
        final User user = userService.getAndInitialize(userId);
        user.addPost(post);
        return postRepository.save(post);
    }

    @Override
    @Transactional
    public Post update(Long postId, Post post) {
        return Optional.of(postId)
                .map(postRepository::getById)
                .map(current -> postMapper.merge(current, post))
                .map(postRepository::save)
                .orElseThrow();
    }
    @Override
    @Transactional
    public void delete(Long userId, Long postId) {
        final Post toDelete = postRepository.findById(postId).orElseThrow();
        userService.getAndInitialize(userId).removePost(toDelete);
    }

}
