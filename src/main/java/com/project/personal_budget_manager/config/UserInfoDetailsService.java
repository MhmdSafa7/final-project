package com.project.personal_budget_manager.config;
import com.project.personal_budget_manager.model.User;
import com.project.personal_budget_manager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Configuration
public class UserInfoDetailsService implements UserDetailsService {

    private static final Logger logger = LoggerFactory.getLogger(UserInfoDetailsService.class);

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userService.findUserByUserName(username);
        return user.map(UserInfoDetails::new)
                .orElseThrow(() -> {
                    logger.error("User not found: {}", username);
                    return new UsernameNotFoundException("User not found in the database");
                });
    }
}