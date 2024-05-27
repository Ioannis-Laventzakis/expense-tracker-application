package com.tracker.expense_tracker_application.controller;

import com.tracker.expense_tracker_application.model.AppUser;
import com.tracker.expense_tracker_application.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/users")
public class AppUserController {

    private final AppUserService appUserService;

    @Autowired
    public AppUserController(AppUserService appUserService) {
        this.appUserService = appUserService;
    }

    @GetMapping
    public String getAllUsers(Model model) {
        List<AppUser> users = appUserService.findAllUsers();
        model.addAttribute("users", users);
        return "user-list";
    }

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

    @GetMapping("/new")
    public String createUserForm(Model model) {
        model.addAttribute("user", new AppUser());
        return "user-form";
    }

    @PostMapping
    public String saveUser(@ModelAttribute AppUser user) {
        appUserService.saveUser(user);
        return "redirect:/users";
    }

    @DeleteMapping("/{id}")
    public String deleteUserById(@PathVariable Long id) {
        appUserService.deleteUserById(id);
        return "redirect:/users";
    }
}
