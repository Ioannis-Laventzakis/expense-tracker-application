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
 * This is a controller class for handling user-related operations.
 * It handles HTTP GET, POST, and DELETE requests for the "/users" endpoint.
 * It uses the UserService to perform user-related operations and PasswordEncoder for password encoding.
 */
@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService appUserService;

    /**
     * This is a constructor for UserController.
     * It initializes the UserService.
     *
     * @param appUserService the user service to be used by this controller
     */
    @Autowired
    public UserController(UserService appUserService) {
        this.appUserService = appUserService;
    }

    /**
     * This method handles the HTTP GET request for the "/users" endpoint.
     * It retrieves all users from the UserService and adds them to the model.
     * It then returns the name of the view to be rendered, in this case "user-list".
     *
     * @param model the model to add attributes to for the view
     * @return the name of the view
     */
    @GetMapping
    public String getAllUsers(Model model) {
        List<User> users = appUserService.getAllUsers();
        model.addAttribute("users", users);
        return "user-list";
    }

    /**
     * This method handles the HTTP GET request for the "/users/{id}" endpoint.
     * It retrieves a user by their ID from the UserService and adds them to the model.
     * If the user is not found, it adds an error message to the model.
     * It then returns the name of the view to be rendered, in this case "user-detail" or "error".
     *
     * @param id the ID of the user to fetch
     * @param model the model to add attributes to for the view
     * @return the name of the view
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
     * This method handles the HTTP GET request for the "/users/new" endpoint.
     * It creates a new User object and adds it to the model.
     * It then returns the name of the view to be rendered, in this case "user-form".
     *
     * @param model the model to add attributes to for the view
     * @return the name of the view
     */
    @GetMapping("/new")
    public String createUserForm(Model model) {
        model.addAttribute("user", new User());
        return "user-form";
    }

    /**
     * This method handles the HTTP POST request for the "/users" endpoint.
     * It saves a new user using the UserService.
     * It then redirects to the "/users" endpoint.
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
     * This method handles the HTTP DELETE request for the "/users/{id}" endpoint.
     * It deletes a user by their ID using the UserService.
     * It then redirects to the "/users" endpoint.
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

    /**
     * This method handles the HTTP GET request for the "/users/register" endpoint.
     * It creates a new User object and adds it to the model.
     * It then returns the name of the view to be rendered, in this case "register".
     *
     * @param model the model to add attributes to for the view
     * @return the name of the view
     */
    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    /**
     * This method handles the HTTP POST request for the "/users/register" endpoint.
     * It encodes the password of the user and saves the new user using the UserService.
     * It then redirects to the "/login" endpoint.
     *
     * @param user the user to be registered
     * @return the redirect view name
     */
    @PostMapping("/register")
    public String registerUser(@ModelAttribute User user) {
        user.setPassword(passwordencoder.encode(user.getPassword()));
        appUserService.createUser(user);
        return "redirect:/login";
    }
}