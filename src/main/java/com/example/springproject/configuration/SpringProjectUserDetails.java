package com.example.springproject.configuration;

import com.example.springproject.model.SecurityUser;
import com.example.springproject.model.User;
import com.example.springproject.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

/** UserDetailsService file
 * @author mariyapolous
 *
 */

@Service
public interface SpringProjectUserDetails extends UserDetailsService {


        @Autowired
        private UserRepo userRepo;

        @Override
        public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
            List<User> user = userRepo.findByEmail(username);
            if (user.size() == 0) {
                throw new UsernameNotFoundException("User details not found for the user : " + username);
            }
            return new SecurityUser(user.get(0));

        }
    }


