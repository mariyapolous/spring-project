package com.example.springproject.repo;

import com.example.springproject.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/** repository file
 * @author mariyapolous
 *
 */

public interface UserRepo extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}
