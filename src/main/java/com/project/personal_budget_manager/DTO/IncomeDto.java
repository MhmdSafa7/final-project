package com.project.personal_budget_manager.DTO;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Data Transfer Object (DTO) for Income.
 *
 * This class is used to transfer data between layers, such as between
 * the service layer and the controller layer.
 */
public class IncomeDto {

    // Unique identifier for the income
    private Long id;

    // Description or source of the income
    private String description;

    // The amount of income received
    private BigDecimal amount;

    // The date when the income was received
    private LocalDate dateReceived;

    // Constructor with fields
    public IncomeDto(Long id, String description, BigDecimal amount, LocalDate dateReceived) {
        this.id = id;
        this.description = description;
        this.amount = amount;
        this.dateReceived = dateReceived;
    }

    // Default constructor
    public IncomeDto() {}

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

    public LocalDate getDateReceived() {
        return dateReceived;
    }

    public void setDateReceived(LocalDate dateReceived) {
        this.dateReceived = dateReceived;
    }
}

