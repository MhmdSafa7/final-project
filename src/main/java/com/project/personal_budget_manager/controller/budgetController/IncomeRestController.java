package com.project.personal_budget_manager.controller.budgetController;

import com.project.personal_budget_manager.model.User;
import com.project.personal_budget_manager.service.IncomeService;
import com.project.personal_budget_manager.model.Income;
import com.project.personal_budget_manager.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Controller
@RequestMapping("/income")
public class IncomeRestController {

    @Autowired
    private IncomeService incomeService;

    @Autowired
    private UserService userService;

    // Method to display the income list
    @GetMapping("/list")
    public String showIncomeList(Model model, HttpSession session) {
        UUID userId = (UUID) session.getAttribute("userId"); // Fetch user ID from session
        if (userId != null) {
            Optional<User> incomeList = incomeService.getAllIncomeByUserId(userId); // Fetch income for the specific user
            model.addAttribute("incomeList", incomeList);
        } else {
            model.addAttribute("incomeList", List.of()); // Return an empty list if no user is found
        }
        return "income"; // Return the "income.html" Thymeleaf template
    }

    @PostMapping("/add")
    public String addIncome(@ModelAttribute Income income, Principal principal, HttpSession session) {
        if (principal == null) {
            return "redirect:/api/login"; // Redirect if not logged in
        }

        UUID userId = (UUID) session.getAttribute("userId"); // Fetch user ID from session
        if (userId != null) {
            Optional<User> user = userService.findById(userId); // Fetch the user object using the user ID
            if (user.isPresent()) {
                income.setUser(user.get()); // Set the user in income
                incomeService.addIncome(income); // Save income
            }
        }

        return "redirect:/income/list"; // Redirect to the income list after adding
    }

    // Method to delete income by id
    @GetMapping("/delete/{id}")
    public String deleteIncome(@PathVariable Long id) {
        incomeService.deleteIncome(id);
        return "redirect:/income/list"; // Redirect to the income list after deleting
    }

    @GetMapping("/income")
    public String getIncome(Model model, Principal principal) {
        // Assuming you have a method to get user by username
        User user = userService.findByUsername(principal.getName());

        // Add the user ID to the model
        model.addAttribute("userId", user.getId());

        // Add income list to the model
        Optional<User> incomeList = incomeService.getAllIncomeByUserId(user.getId());
        model.addAttribute("incomeList", incomeList);

        return "income"; // return the name of your Thymeleaf template
    }
}
