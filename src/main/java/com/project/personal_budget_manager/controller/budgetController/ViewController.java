package com.project.personal_budget_manager.controller.budgetController;

import com.project.personal_budget_manager.model.Expense;
import com.project.personal_budget_manager.model.Income;
import com.project.personal_budget_manager.model.SavingsGoal;
import com.project.personal_budget_manager.service.ExpenseService;
import com.project.personal_budget_manager.service.IncomeService;
import com.project.personal_budget_manager.service.SavingsGoalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class ViewController {

    @Autowired
    private ExpenseService expenseService;

    @Autowired
    private SavingsGoalService savingsGoalService;

    @Autowired
    private IncomeService incomeService;


    // Dashboard view with summaries and recent transactions
    @GetMapping("dashboard")
    public String viewDashboard(Model model) {
        List<Expense> expenses = expenseService.getAllExpenses();
        List<Income> incomes = incomeService.getAllIncome();
        List<SavingsGoal> savingsGoals = savingsGoalService.getAllSavingsGoals();

        model.addAttribute("expenses", expenses);
        model.addAttribute("income", incomes);
        model.addAttribute("savingsGoals", savingsGoals);

        // Calculate totals
        model.addAttribute("totalIncome", incomes.stream().mapToDouble(Income::getAmount).sum());
        model.addAttribute("totalExpenses", expenses.stream().mapToDouble(Expense::getAmount).sum());
        //model.addAttribute("currentSavings", savingsGoals.stream().mapToDouble(SavingsGoal::getAmount).sum());

        return "dashboard";
    }




    // View for Expenses
//    @GetMapping("/expense")
//    public String viewExpenses(Model model) {
//        List<Expense> expenses = expenseService.getAllExpenses();
//        model.addAttribute("expense", expenses);
//        return "expense";  // This should match the Thymeleaf template name (expense.html)
//    }


    // View for Income
    @GetMapping("/income")
    public String viewIncome(Model model) {
        List<Income> incomes = incomeService.getAllIncome();
        model.addAttribute("incomeList", incomes);
        return "income"; // Ensure this matches the Thymeleaf template name
    }



    @GetMapping("/expense2")
    public String showExpenseForm(Model model) {
        model.addAttribute("expense", new Expense());  // Add a new expense object
        return "expense";  // Return the template name
    }

//    @GetMapping("/expense")
//    public String showExpenses(Model model) {
//        List<Expense> expenses = expenseService.getAllExpenses(); // Fetch expenses from service
//        model.addAttribute("expenses", expenses); // Add expenses to model
//        model.addAttribute("expense", new Expense()); // Add empty expense for form binding
//        return "expense"; // Return the name of the template file (without .html)
//    }



    // View for Savings Goals
    @GetMapping("/savings-goals")
    public String viewSavingsGoals(Model model) {
        List<SavingsGoal> savingsGoals = savingsGoalService.getAllSavingsGoals();
        model.addAttribute("savingsGoals", savingsGoals);
        return "savings-goals"; // Ensure this matches the Thymeleaf template name
    }


}
