package com.project.personal_budget_manager.repository;
import com.project.personal_budget_manager.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.Optional;
import java.util.UUID;
@Repository
public interface UserRepository extends JpaRepository<User, UUID> {
    @Query("SELECT u FROM User u WHERE u.username = ?1")
    Optional<User> findUserByName(String name);

    User findByUsername(String username);

Optional<User> findById(UUID userid);
}