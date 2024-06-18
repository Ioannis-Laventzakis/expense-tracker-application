package com.tracker.expense_tracker_application.controller;

import com.tracker.expense_tracker_application.model.User;
import com.tracker.expense_tracker_application.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
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
public class UserController {

    private final UserService appUserService;

    /**
     * Constructor for AppUserController.
     *
     * @param appUserService the user service to be used by this controller
     */
    @Autowired
    public UserController(UserService appUserService) {
        this.appUserService = appUserService;
    }

    /**
     * Handles GET requests to fetch all users.
     *
     * @param model the model to which the users will be added
     * @return the name of the view to be rendered
     */
    @GetMapping
    public String getAllUsers(Model model) {
        List<User> users = appUserService.getAllUsers();
        model.addAttribute("users", users);
        return "user-list";
    }

    /**
     * Handles GET requests to fetch a user by their ID.
     *
     * @param id the ID of the user to fetch
     * @param model the model to which the user will be added
     * @return the name of the view to be rendered
     */
    @GetMapping("/{id}")
    public String getUserById(@PathVariable Long id, Model model) {
        Optional<User> userOpt = Optional.ofNullable(appUserService.getUserById(id));
        if (userOpt.isPresent()) {
            model.addAttribute("user", userOpt.get());
            return "user-detail";
        } else {
            model.addAttribute("error", "User not found");
            return "error";
        }
    }

    /**
     * Handles GET requests to display the user creation form.
     *
     * @param model the model to which a new user will be added
     * @return the name of the view to be rendered
     */
    @GetMapping("/new")
    public String createUserForm(Model model) {
        model.addAttribute("user", new User());
        return "user-form";
    }

    /**
     * Handles POST requests to save a new user.
     *
     * @param user the user to be saved
     * @return the redirect view name
     */
    @PostMapping
    public String saveUser(@ModelAttribute User user) {
        appUserService.createUser(user);
        return "redirect:/users";
    }

    /**
     * Handles DELETE requests to delete a user by their ID.
     *
     * @param id the ID of the user to delete
     * @return the redirect view name
     */
    @DeleteMapping("/{id}")
    public String deleteUserById(@PathVariable Long id) {
        appUserService.deleteUser(id);
        return "redirect:/users";
    }
    @Autowired
    private PasswordEncoder passwordencoder;

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }
    @PostMapping("/register")
    public String registerUser(@ModelAttribute User user) {
        user.setPassword(passwordencoder.encode(user.getPassword()));
        appUserService.createUser(user);
        return "redirect:/login";
    }


}