package com.project.personal_budget_manager.model;



import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String username;
    private String password;
    private String role;

    // New fields
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    // Constructor for the new fields
    public User(String username, String password, String role, String firstName, String lastName, String email, String phoneNumber, LocalDateTime createdAt) {
        this.username = username;
        this.password = password;
        this.role = role;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.createdAt = createdAt;
    }


}