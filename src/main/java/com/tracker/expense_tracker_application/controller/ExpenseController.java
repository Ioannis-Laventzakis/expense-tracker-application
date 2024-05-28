package com.tracker.expense_tracker_application.controller;

import com.tracker.expense_tracker_application.model.AppUser;
import com.tracker.expense_tracker_application.service.ExpenseService;
import com.tracker.expense_tracker_application.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Controller for handling expense-related requests.
 */
@Controller
@RequestMapping("/expenses")
public class ExpenseController {

    private final ExpenseService expenseService;
    private final UserServiceImpl userService;

    /**
     * Constructor for ExpenseController.
     *
     * @param expenseService the expense service to be used by this controller
     * @param userService the user service to be used by this controller
     */
    @Autowired
    public ExpenseController(ExpenseService expenseService, UserServiceImpl userService) {
        this.expenseService = expenseService;
        this.userService = userService;
    }

    /**
     * Handles GET requests to fetch all users.
     *
     * @param model the model to which the users will be added
     * @return the name of the view to be rendered
     */
    @GetMapping
    public String listUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "user-list";
    }

    /**
     * Handles GET requests to display the user creation form.
     *
     * @param model the model to which a new user will be added
     * @return the name of the view to be rendered
     */
    @GetMapping("/new")
    public String showUserForm(Model model) {
        AppUser user = new AppUser();
        model.addAttribute("user", user);
        return "user-form";
    }

    /**
     * Handles POST requests to save a new user.
     *
     * @param user the user to be saved
     * @return the redirect view name
     */
    @PostMapping
    public String saveUser(@ModelAttribute("user") AppUser user) {
        userService.createUser(user);
        return "redirect:/expenses";
    }

    /**
     * Handles GET requests to display the user edit form.
     *
     * @param id the ID of the user to edit
     * @param model the model to which the user will be added
     * @return the name of the view to be rendered
     */
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        AppUser user = userService.getUserById(id);
        model.addAttribute("user", user);
        return "user-form";
    }

    /**
     * Handles POST requests to update a user.
     *
     * @param id the ID of the user to update
     * @param user the user data to update
     * @return the redirect view name
     */
    @PostMapping("/update/{id}")
    public String updateUser(@PathVariable Long id, @ModelAttribute("user") AppUser user) {
        userService.updateUser(id, user);
        return "redirect:/expenses";
    }

    /**
     * Handles GET requests to delete a user by their ID.
     *
     * @param id the ID of the user to delete
     * @return the redirect view name
     */
    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return "redirect:/expenses";
    }
}