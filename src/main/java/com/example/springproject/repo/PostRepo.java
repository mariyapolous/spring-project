package com.example.springproject.repo;

import com.example.springproject.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
/** repository file
 * @author mariyapolous
 *
 */

public interface PostRepo extends JpaRepository<Post, Long> {
}
