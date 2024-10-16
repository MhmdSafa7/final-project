package com.project.personal_budget_manager.controller.budgetController;

import com.project.personal_budget_manager.model.SavingsGoal;
import com.project.personal_budget_manager.service.SavingsGoalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/budget")
public class SavingsGoalController {

    @Autowired
    private SavingsGoalService savingsGoalService;

    // API: Get all savings goals
    @GetMapping("/savings-goals")
    public ResponseEntity<List<SavingsGoal>> getAllSavingsGoals() {
        List<SavingsGoal> savingsGoals = savingsGoalService.getAllSavingsGoals();
        return new ResponseEntity<>(savingsGoals, HttpStatus.OK);
    }

    // API: Get a savings goal by its ID
    @GetMapping("/savings-goals/{id}")
    public ResponseEntity<Optional<SavingsGoal>> getSavingsGoalById(@PathVariable("id") Long id) {
        Optional<SavingsGoal> savingsGoal = savingsGoalService.getSavingsGoalById(id);
        return new ResponseEntity<>(savingsGoal, HttpStatus.OK);
    }

    // API: Create a new savings goal
    @PostMapping("/savings-goals")
    public ResponseEntity<SavingsGoal> createSavingsGoal(@RequestBody SavingsGoal savingsGoal) {
        SavingsGoal createdSavingsGoal = savingsGoalService.addSavingsGoal(savingsGoal);
        return new ResponseEntity<>(createdSavingsGoal, HttpStatus.CREATED);
    }

    // API: Update an existing savings goal
    @PutMapping("/savings-goals/{id}")
    public ResponseEntity<SavingsGoal> updateSavingsGoal(@PathVariable("id") Long id, @RequestBody SavingsGoal savingsGoal) {
        SavingsGoal updatedSavingsGoal = savingsGoalService.updateSavingsGoal(id, savingsGoal);
        return new ResponseEntity<>(updatedSavingsGoal, HttpStatus.OK);
    }

    // API: Delete a savings goal by its ID
    @DeleteMapping("/savings-goals/{id}")
    public ResponseEntity<Void> deleteSavingsGoal(@PathVariable("id") Long id) {
        savingsGoalService.deleteSavingsGoal(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // View: Show savings goal page (Thymeleaf template)
    @GetMapping("/savingsGoal")
    public String showSavingsGoalPage() {
        return "savingsGoal"; // This corresponds to src/main/resources/templates/savingsGoal.html
    }

    // View: Display all savings goals in a Thymeleaf template
    @GetMapping("/view/savingsGoal")
    public String viewSavingsGoals(Model model) {
        List<SavingsGoal> savingsGoalList = savingsGoalService.getAllSavingsGoals();
        model.addAttribute("savingsGoalList", savingsGoalList);
        return "savingsGoal";
    }

    // View: Add new savings goal via a form in Thymeleaf
    @PostMapping("/view/savingsGoal/add")
    public String addSavingsGoal(@RequestParam String goalName, @RequestParam double amount) {
        SavingsGoal savingsGoal = new SavingsGoal(goalName, amount);
        savingsGoalService.addSavingsGoal(savingsGoal);
        return "redirect:/view/savingsGoal";
    }

    // View: Update an existing savings goal via a form in Thymeleaf
    @PostMapping("/view/savingsGoal/update")
    public String updateSavingsGoal(@RequestParam Long id, @RequestParam String goalName, @RequestParam double amount) {
        savingsGoalService.updateSavingsGoal(id, goalName, amount);  // Ensure this service method exists
        return "redirect:/view/savingsGoal";
    }
}
