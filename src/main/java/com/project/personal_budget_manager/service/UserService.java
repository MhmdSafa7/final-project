package com.project.personal_budget_manager.service;


import com.project.personal_budget_manager.enums.Roles;
import com.project.personal_budget_manager.model.User;
import com.project.personal_budget_manager.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public Optional<User> findById(UUID id) {
        return userRepository.findById(id); // This assumes your repository has a findById method
    }
    public User createUser(String username, String password, String role, String firstName, String lastName, String email, String phoneNumber) {
        // Validate role using the enum
        if (!Roles.isValidRole(role)) {
            throw new IllegalArgumentException("Invalid role");
        }


        // Create the User object with new fields
        User user = new User(
                username,
                passwordEncoder.encode(password),
                role.toUpperCase(),
                firstName,
                lastName,
                email,
                phoneNumber,
                LocalDateTime.now() // Setting the createdAt field to current time
        );

        // Save the user to the repository
        return userRepository.save(user);
    }
    // Method to get the current logged-in user
    public User getCurrentUser(Authentication authentication) {
        String username = authentication.getName();

        return userRepository.findByUsername(username);

    }
    public boolean hasRole(Authentication authentication, String role) {
        if (authentication == null) {
            return false;
        }

        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        return authorities.stream()
                .anyMatch(grantedAuthority -> grantedAuthority.getAuthority().equals(role));
    }

    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }



    public Optional<User> findUserByUserName(String username) {
        return userRepository.findUserByName(username);
    }

    public void deleteUser(UUID id) {
        Optional<User> userOpt = userRepository.findById(id);
        if (userOpt.isPresent()) {
            userRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("User not found");
        }
    }
    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }
    public User getUserById(UUID id) {
        return userRepository.findById(id).orElse(null);
    }






}