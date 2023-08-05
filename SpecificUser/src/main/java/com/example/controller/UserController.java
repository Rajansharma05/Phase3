package com.example.controller;

import com.example.model.User;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // ... Other methods ...

    @GetMapping("/{id}")
    public String getUserById(@PathVariable Long id, Model model) {
        User user = userService.getUserById(id);
        model.addAttribute("user", user);
        return "user-details"; // Return the name of the JSP view
    }

    @GetMapping("/update/{id}")
    public String showUpdateForm(@PathVariable Long id, Model model) {
        User user = userService.getUserById(id);
        model.addAttribute("user", user);
        return "update-user"; // Return the name of the JSP update form
    }

    @PostMapping("/update/{id}")
    public String updateUser(@PathVariable Long id, User updatedUser) {
        userService.updateUserInformation(id, updatedUser.getUsername(), updatedUser.getEmail());
        return "redirect:/user/" + id; // Redirect to user details page
    }
}
