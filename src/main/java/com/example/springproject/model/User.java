package com.example.springproject.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.Collection;


/** Entity file
 * @author mariyapolous
 *
 */
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private Long id;


    @Column(name = "email", unique = true, nullable = false)
    @Email(message = "*Укажите ваш e-mail")
    @NotEmpty(message = "*Строка обязательна к заполнению")
    private String email;

    @Column(name = "password", nullable = false)
    @Length(min = 6, message = "*Your password must have at least 5 characters")
    @NotEmpty(message = "*Строка обязательна к заполнению")
    private String password;

    @Column(name = "username", nullable = false, unique = true)
    @Length(min = 5, message = "*Придумайте никнейм")
    @NotEmpty(message = "*Please provide your name")
    private String username;

    @Column(name = "name")
    @NotEmpty(message = "*Please provide your name")
    private String name;

    @Column(name = "last_name")
    @NotEmpty(message = "*Please provide your last name")
    private String lastName;

    @OneToMany(mappedBy = "user")
    private Collection<Post> posts;

    @Column(name = "role", nullable = false)
    private String role;


    public User (Long id, String email, String password, String username, String name, String lastName) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.username = username;
        this.name = name;
        this.lastName = lastName;
        this.posts = posts;
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    public Collection<Post> getPosts() {
        return posts;
    }

    public void setPosts(Collection<Post> posts) {
        this.posts = posts;
    }

    public String getRole() {
        return role;
    }

    public void setRole (String role) {
        this.role = role;
    }
}
