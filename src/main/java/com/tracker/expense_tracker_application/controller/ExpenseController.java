package com.tracker.expense_tracker_application.controller;

import com.tracker.expense_tracker_application.model.User;
import com.tracker.expense_tracker_application.service.ExpenseService;
import com.tracker.expense_tracker_application.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * This is a controller class for handling expense-related operations.
 * It handles HTTP GET and POST requests for the "/expenses" endpoint.
 * It uses the UserService to perform user-related operations.
 */
@Controller
@RequestMapping("/expenses")
public class ExpenseController {

    private final ExpenseService expenseService;
    private final UserService userService;

    /**
     * This is a constructor for the ExpenseController.
     * It initializes the ExpenseService and UserService.
     *
     * @param expenseService the expense service to be used by this controller
     * @param userService the user service to be used by this controller
     */
    @Autowired
    public ExpenseController(ExpenseService expenseService, UserService userService) {
        this.expenseService = expenseService;
        this.userService = userService;
    }

    /**
     * This method handles the HTTP GET request for the "/expenses" endpoint.
     * It retrieves all users from the UserService and adds them to the model.
     * It then returns the name of the view to be rendered, in this case "user-list".
     *
     * @param model the model to add attributes to for the view
     * @return the name of the view
     */
    @GetMapping
    public String listUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "user-list";
    }

    /**
     * This method handles the HTTP GET request for the "/expenses/new" endpoint.
     * It creates a new User object and adds it to the model.
     * It then returns the name of the view to be rendered, in this case "user-form".
     *
     * @param model the model to add attributes to for the view
     * @return the name of the view
     */
    @GetMapping("/new")
    public String showUserForm(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "user-form";
    }

    /**
     * This method handles the HTTP POST request for the "/expenses" endpoint.
     * It saves a new user using the UserService.
     * It then redirects to the "/expenses" endpoint.
     *
     * @param user the user to be saved
     * @return the redirect view name
     */
    @PostMapping
    public String saveUser(@ModelAttribute("user") User user) {
        userService.createUser(user);
        return "redirect:/expenses";
    }

    /**
     * This method handles the HTTP GET request for the "/expenses/edit/{id}" endpoint.
     * It retrieves a user by their ID using the UserService and adds them to the model.
     * It then returns the name of the view to be rendered, in this case "user-form".
     *
     * @param id the ID of the user to edit
     * @param model the model to add attributes to for the view
     * @return the name of the view
     */
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        User user = userService.getUserById(id);
        model.addAttribute("user", user);
        return "user-form";
    }

    /**
     * This method handles the HTTP POST request for the "/expenses/update/{id}" endpoint.
     * It updates a user by their ID using the UserService.
     * It then redirects to the "/expenses" endpoint.
     *
     * @param id the ID of the user to update
     * @param user the user data to update
     * @return the redirect view name
     */
    @PostMapping("/update/{id}")
    public String updateUser(@PathVariable Long id, @ModelAttribute("user") User user) {
        userService.updateUser(id, user);
        return "redirect:/expenses";
    }

    /**
     * This method handles the HTTP GET request for the "/expenses/delete/{id}" endpoint.
     * It deletes a user by their ID using the UserService.
     * It then redirects to the "/expenses" endpoint.
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