// File: src/main/java/com/tracker/expense_tracker_application/controller/AppUserController.java
package com.tracker.expense_tracker_application.controller;

import com.tracker.expense_tracker_application.model.AppUser;
import com.tracker.expense_tracker_application.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller for handling user-related requests.
 */
@Controller
@RequestMapping("/users")
public class AppUserController {

    @Autowired
    private AppUserService appUserService;

    /**
     * Handles GET requests to fetch all users.
     * @param model the model to add attributes to for the view
     * @return the name of the view to render
     */
    @GetMapping
    public String getAllUsers(Model model) {
        List<AppUser> users = appUserService.findAllUsers();
        model.addAttribute("users", users);
        return "user-list";
    }

    /**
     * Handles GET requests to fetch a user by their ID.
     * @param id the ID of the user to fetch
     * @param model the model to add attributes to for the view
     * @return the name of the view to render
     */
    @GetMapping("/{id}")
    public String getUserById(@PathVariable Long id, Model model) {
        AppUser user = appUserService.findUserById(id).orElse(null);
        model.addAttribute("user", user);
        return "user-detail";
    }

    /**
     * Handles GET requests to display the form for creating a new user.
     * @param model the model to add attributes to for the view
     * @return the name of the view to render
     */
    @GetMapping("/new")
    public String createUserForm(Model model) {
        model.addAttribute("user", new AppUser());
        return "user-form";
    }

    /**
     * Handles POST requests to save a new user.
     * @param user the user to save
     * @return a redirect to the user list view
     */
    @PostMapping
    public String saveUser(@ModelAttribute AppUser user) {
        appUserService.saveUser(user);
        return "redirect:/users";
    }

    /**
     * Handles GET requests to delete a user by their ID.
     * @param id the ID of the user to delete
     * @return a redirect to the user list view
     */
    @GetMapping("/delete/{id}")
    public String deleteUserById(@PathVariable Long id) {
        appUserService.deleteUserById(id);
        return "redirect:/users";
    }
}