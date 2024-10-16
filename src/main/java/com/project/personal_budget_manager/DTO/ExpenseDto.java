package com.project.personal_budget_manager.DTO;



import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Data Transfer Object (DTO) for Expense.
 *
 * This class is used to transfer data between layers, such as between
 * the service layer and the controller layer.
 */
public class ExpenseDto {

    // Unique identifier for the expense
    private Long id;

    // Description or category of the expense
    private String description;

    // The amount spent
    private BigDecimal amount;

    // The date when the expense was incurred
    private LocalDate dateIncurred;

    // The category of the expense (e.g., food, transportation)
    private String category;

    // Constructor with fields
    public ExpenseDto(Long id, String description, BigDecimal amount, LocalDate dateIncurred, String category) {
        this.id = id;
        this.description = description;
        this.amount = amount;
        this.dateIncurred = dateIncurred;
        this.category = category;
    }

    // Default constructor
    public ExpenseDto() {}

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public LocalDate getDateIncurred() {
        return dateIncurred;
    }

    public void setDateIncurred(LocalDate dateIncurred) {
        this.dateIncurred = dateIncurred;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}

