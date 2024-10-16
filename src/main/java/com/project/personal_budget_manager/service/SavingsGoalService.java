package com.project.personal_budget_manager.service;



import com.project.personal_budget_manager.model.Expense;
import com.project.personal_budget_manager.model.SavingsGoal;
import com.project.personal_budget_manager.repository.SavingsGoalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class SavingsGoalService {

    @Autowired
    private SavingsGoalRepository savingsGoalRepository;

    /**
     * Adds a new savings goal to the database.
     * @param savingsGoal The savings goal object to be added.
     * @return The saved savings goal object.
     */
    public SavingsGoal addSavingsGoal(SavingsGoal savingsGoal) {
        // Save the savings goal to the database and return it
        return savingsGoalRepository.save(savingsGoal);
    }

    /**
     * Retrieves all savings goals from the database.
     * @return A list of all savings goals.
     */
    public List<SavingsGoal> getAllSavingsGoals() {
        // Fetch all expenses from the database
        return savingsGoalRepository.findAll();
    }

    /**
     * Retrieves a specific savings goal by its ID.
     * @param id The ID of the savings goal.
     * @return The savings goal with the given ID, wrapped in an Optional.
     */
    public Optional<SavingsGoal> getSavingsGoalById(Long id) {
        // Find the savings goal by its ID
        return savingsGoalRepository.findById(id);
    }

    /**
     * Updates an existing savings goal in the database.
     *
     * @param id
     * @param savingsGoal The updated savings goal object.
     * @return The updated savings goal object.
     */
    public SavingsGoal updateSavingsGoal(Long id, SavingsGoal savingsGoal) {
        // Save the updated savings goal to the database and return it
        return savingsGoalRepository.save(savingsGoal);
    }

    /**
     * Deletes a savings goal from the database by its ID.
     *
     * @param id The ID of the savings goal to be deleted.
     */
    public void deleteSavingsGoal(Long id) {

    }

    public void updateSavingsGoal(Long id, String goalName, double amount) {
    }
}

