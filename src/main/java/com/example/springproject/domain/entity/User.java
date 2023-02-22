package com.example.springproject.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

import static lombok.AccessLevel.PRIVATE;


@Entity
@Table(name="users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor(access= PRIVATE)
public class User extends BaseEntity{

    @NotBlank
    @Column(unique=true)
    private String email;
    @NotBlank
    @Column(unique=true)
    private String username;
    @NotBlank
    private String password;
    @Column(unique=true)
    private String name;


    @Setter(PRIVATE)
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Post> posts = new ArrayList<>();

    public void addPost(Post post) {
        this.posts.add(post);
        post.setUser(this);
    }

    @Setter(PRIVATE)
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Comment> comments = new ArrayList<>();

    public void removePost(Post post) {
        this.posts.remove(post);
    }

    public void addComment(Comment comment) {
        this.comments.add(comment);
        comment.setUser(this);
    }


}
