package com.project.personal_budget_manager.repository;


import com.project.personal_budget_manager.model.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Long> {


}

