package com.example.springproject.repository;

import com.example.springproject.domain.entity.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long>{
    Page<Comment> findAllByPostId (Long postId, Pageable pageable);
}
