package com.project.personal_budget_manager.controller.budgetController;

import com.project.personal_budget_manager.model.Income;
import com.project.personal_budget_manager.service.IncomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/view")
public class IncomeViewController {

    @Autowired
    private IncomeService incomeService;

    // View income records page (for Thymeleaf)
    @GetMapping("/income")
    public String viewIncome(Model model) {
        List<Income> incomeList = incomeService.getAllIncome();
        model.addAttribute("incomeList", incomeList);
        return "income"; // Refers to the Thymeleaf template 'income.html'
    }

    // Add new income record (Thymeleaf form submission)
    @PostMapping("/income/add")
    public String addIncome(@RequestParam String date, @RequestParam double amount,
                            @RequestParam String source, @RequestParam(required = false) String notes) {
        Income income = new Income(date, amount, source, notes);
        incomeService.addIncome(income);
        return "redirect:/view/income";
    }

    // Update existing income record (Thymeleaf form submission)
    @PostMapping("/income/update")
    public String updateIncome(@RequestParam Long id, @RequestParam String date, @RequestParam double amount,
                               @RequestParam String source, @RequestParam(required = false) String notes) {
        Income updatedIncome = new Income(date, amount, source, notes);
        incomeService.updateIncome(id, updatedIncome);
        return "redirect:/view/income";
    }

    // Method for handling the rendering of the income update form, if needed
    @GetMapping("/income/edit/{id}")
    public String editIncomeForm(@PathVariable("id") Long id, Model model) {
        Optional<Income> income = incomeService.getIncomeById(id);
        if (income.isPresent()) {
            model.addAttribute("income", income.get());
            return "edit-income"; // Refers to the Thymeleaf template 'edit-income.html'
        }
        return "redirect:/view/income";
    }
}

