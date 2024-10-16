package com.project.personal_budget_manager.service;

import com.project.personal_budget_manager.model.Income;
import com.project.personal_budget_manager.model.User;
import com.project.personal_budget_manager.repository.IncomeRepository;
import com.project.personal_budget_manager.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class IncomeService {
    @Autowired
    private IncomeRepository incomeRepository;
    @Autowired
    private UserRepository userRepository;
    public Optional<User> getAllIncomeByUserId(UUID userId) {
        // Implementation to fetch income records associated with the user ID
        return userRepository.findById(userId); // Hypothetical method, adjust as necessary
    }


    /**
     * Adds a new income record to the database.
     * @param income The income object to be added.
     * @return The saved income object.
     */
    public Income addIncome(Income income) {
        // Save the income to the database and return it
        return incomeRepository.save(income);
    }

    /**
     * Retrieves all income records from the database.
     * @return A list of all income records.
     */
    public List<Income> getAllIncome() {
        // Fetch all income records from the database
        return incomeRepository.findAll();
    }

    /**
     * Retrieves a specific income record by its ID.
     * @param id The ID of the income record.
     * @return The income record with the given ID, wrapped in an Optional.
     */
    public Optional<Income> getIncomeById(Long id) {
        // Find the income record by its ID
        return incomeRepository.findById(id);
    }

    /**
     * Updates an existing income record in the database.
     *
     * @param id
     * @param income The updated income object.
     * @return The updated income object.
     */
    public Income updateIncome(Long id, Income income) {
        // Save the updated income to the database and return it
        return incomeRepository.save(income);
    }

    /**
     * Deletes an income record from the database by its ID.
     * @param id The ID of the income record to be deleted.
     */
    public void deleteIncome(Long id) {
        // Remove the income record from the database
        incomeRepository.deleteById(id);
    }

    public void updateIncome(Long id, String date, double amount, String source, String notes) {
    }
}
