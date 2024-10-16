package com.project.personal_budget_manager.service;



import com.project.personal_budget_manager.model.Expense;
import com.project.personal_budget_manager.model.Income;
import com.project.personal_budget_manager.model.SavingsGoal;
import com.project.personal_budget_manager.repository.ExpenseRepository;
import com.project.personal_budget_manager.repository.IncomeRepository;
import com.project.personal_budget_manager.repository.SavingsGoalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Service class that handles business logic for managing budget-related data.
 */
@Service
public class ExpenseService {
    // Autowiring repositories to perform CRUD operations
    @Autowired
    private ExpenseRepository expenseRepository;

    /**
     * Adds a new expense to the database.
     * @param expense The expense object to be added.
     * @return The saved expense object.
     */
    public Expense addExpense(Expense expense) {
        // Save the expense to the database and return it
        return expenseRepository.save(expense);
    }

    /**
     * Retrieves all expenses from the database.
     * @return A list of all expenses.
     */
    public List<Expense> getAllExpenses() {
        // Fetch all expenses from the database
        return expenseRepository.findAll();
    }

    /**
     * Retrieves a specific expense by its ID.
     * @param id The ID of the expense.
     * @return The expense with the given ID, wrapped in an Optional.
     */
    public Optional<Expense> getExpenseById(Long id) {
        // Find the expense by its ID
        return expenseRepository.findById(id);
    }

    /**
     * Updates an existing expense in the database.
     *
     * @param id
     * @param expense The updated expense object.
     * @return The updated expense object.
     */
    public Expense updateExpense(Long id, Expense expense) {
        // Save the updated expense to the database and return it
        return expenseRepository.save(expense);
    }

    /**
     * Deletes an expense from the database by its ID.
     *
     * @param id The ID of the expense to be deleted.
     */
    public void deleteExpense(Long id) {

    }

    public void updateExpense(Long id, String date, double amount, String category, String notes) {
    }
}
