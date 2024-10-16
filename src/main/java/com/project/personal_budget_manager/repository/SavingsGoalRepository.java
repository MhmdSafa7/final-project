package com.project.personal_budget_manager.repository;



import com.project.personal_budget_manager.model.SavingsGoal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SavingsGoalRepository extends JpaRepository<SavingsGoal, Long> {

    // Custom query methods
    Optional<SavingsGoal> findByGoalName(String goalName);
}
