package com.project.personal_budget_manager.controller.budgetController;

import com.project.personal_budget_manager.model.Expense;
import com.project.personal_budget_manager.model.User;
import com.project.personal_budget_manager.service.ExpenseService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Controller
@RequestMapping("/view")
public class ExpenseViewController {
    @Autowired
    private ExpenseService expenseService;

    @GetMapping("/view")
    public String showIncomeList(Model model, HttpSession session) {
        List<Expense> expenseList = expenseService.getAllExpenses();
        model.addAttribute("expenseList", expenseList);
        return "expense"; // Return the "income.html" Thymeleaf template
    }



    // Add new expense record (Thymeleaf form submission)
    @PostMapping("/expense/add")
    public String addExpense(@RequestParam String date, @RequestParam double amount,
                             @RequestParam String category, @RequestParam(required = false) String notes) {
        Expense expense = new Expense(date, amount, category, notes);
        expenseService.addExpense(expense);
        return "redirect:/view/expense";
    }

    // Update existing expense record (Thymeleaf form submission)
    @PostMapping("/expense/update")
    public String updateExpense(@RequestParam Long id, @RequestParam String date, @RequestParam double amount,
                                @RequestParam String category, @RequestParam(required = false) String notes) {
        Expense updatedExpense = new Expense(date, amount, category, notes);
        expenseService.updateExpense(id, updatedExpense);
        return "redirect:/view/expense";
    }

    // Method for handling the rendering of the expense update form
    @GetMapping("/expense/edit/{id}")
    public String editExpenseForm(@PathVariable("id") Long id, Model model) {
        Optional<Expense> expense = expenseService.getExpenseById(id);
        if (expense.isPresent()) {
            model.addAttribute("expense", expense.get());
            return "edit-expense"; // Refers to the Thymeleaf template 'edit-expense.html'
        }
        return "redirect:/view/expense";
    }
}
