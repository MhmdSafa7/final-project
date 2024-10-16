package com.project.personal_budget_manager.controller;
import com.project.personal_budget_manager.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.UUID;

@Controller
@RequestMapping("/api")
public class AuthController {
    @Autowired
    private UserService userService;
    private final AuthenticationManager authenticationManager;

    @Autowired
    public AuthController(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    // GET method to show the login page
    @GetMapping("/login")
    public String showLoginPage(Model model) {
        return "login"; // Return the name of your login HTML template
    }
    @PostMapping("/login")
    public String login(@RequestParam Map<String, String> credentials, Model model, HttpSession session) {
        String username = credentials.get("username");
        String password = credentials.get("password");

        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(username, password)
            );

            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            UUID userId = userService.findByUsername(userDetails.getUsername()).getId();
            session.setAttribute("userId", userId); // Save user ID in session

            return "redirect:/dashboard";
        } catch (AuthenticationException e) {
            model.addAttribute("error", true);
            model.addAttribute("errorMessage", "Invalid credentials");
            return "login";
        }
    }


    @PostMapping("/logout")
    public ResponseEntity<String> logout() {
        return ResponseEntity.ok("Logout successful");
    }
}