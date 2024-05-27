package com.tracker.expense_tracker_application.controller;

import com.tracker.expense_tracker_application.model.AppUser;
import com.tracker.expense_tracker_application.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Controller for handling user-related requests.
 */
@Controller
@RequestMapping("/users")
public class AppUserController {

    private final AppUserService appUserService;

    /**
     * Constructor for AppUserController.
     *
     * @param appUserService the service to be used for user operations
     */
    @Autowired
    public AppUserController(AppUserService appUserService) {
        this.appUserService = appUserService;
    }

    /**
     * Handles the GET request to fetch all users.
     *
     * @param model the model to add attributes to for rendering in the view
     * @return the name of the view to render
     */
    @GetMapping
    public String getAllUsers(Model model) {
        List<AppUser> users = appUserService.findAllUsers();
        model.addAttribute("users", users);
        return "user-list";
    }

    /**
     * Handles the GET request to fetch a user by their ID.
     *
     * @param id the ID of the user to fetch
     * @param model the model to add attributes to for rendering in the view
     * @return the name of the view to render
     */
    @GetMapping("/{id}")
    public String getUserById(@PathVariable Long id, Model model) {
        Optional<AppUser> userOpt = appUserService.findUserById(id);
        if (userOpt.isPresent()) {
            model.addAttribute("user", userOpt.get());
            return "user-detail";
        } else {
            model.addAttribute("error", "User not found");
            return "error";
        }
    }

    /**
     * Handles the GET request to display the form for creating a new user.
     *
     * @param model the model to add attributes to for rendering in the view
     * @return the name of the view to render
     */
    @GetMapping("/new")
    public String createUserForm(Model model) {
        model.addAttribute("user", new AppUser());
        return "user-form";
    }

    /**
     * Handles the POST request to save a new user.
     *
     * @param user the user to save
     * @return the redirect view name
     */
    @PostMapping
    public String saveUser(@ModelAttribute AppUser user) {
        appUserService.saveUser(user);
        return "redirect:/users";
    }

    /**
     * Handles the DELETE request to delete a user by their ID.
     *
     * @param id the ID of the user to delete
     * @return the redirect view name
     */
    @DeleteMapping("/{id}")
    public String deleteUserById(@PathVariable Long id) {
        appUserService.deleteUserById(id);
        return "redirect:/users";
    }
}