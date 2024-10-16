package com.project.personal_budget_manager.DTO;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Data Transfer Object (DTO) for SavingsGoal.
 *
 * This class is used to transfer data between layers, such as between
 * the service layer and the controller layer.
 */
public class SavingsGoalDto {

    // Unique identifier for the savings goal
    private Long id;

    // The name or description of the savings goal
    private String name;

    // The target amount to save
    private BigDecimal targetAmount;

    // The amount that has been saved so far
    private BigDecimal savedAmount;

    // The deadline by which the goal should be achieved
    private LocalDate deadline;

    // Constructor with fields
    public SavingsGoalDto(Long id, String name, BigDecimal targetAmount, BigDecimal savedAmount, LocalDate deadline) {
        this.id = id;
        this.name = name;
        this.targetAmount = targetAmount;
        this.savedAmount = savedAmount;
        this.deadline = deadline;
    }

    // Default constructor
    public SavingsGoalDto() {}

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getTargetAmount() {
        return targetAmount;
    }

    public void setTargetAmount(BigDecimal targetAmount) {
        this.targetAmount = targetAmount;
    }

    public BigDecimal getSavedAmount() {
        return savedAmount;
    }

    public void setSavedAmount(BigDecimal savedAmount) {
        this.savedAmount = savedAmount;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDate deadline) {
        this.deadline = deadline;
    }
}
