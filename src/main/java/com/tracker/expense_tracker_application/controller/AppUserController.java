// File: src/main/java/com/tracker/expense_tracker_application/controller/AppUserController.java
package com.tracker.expense_tracker_application.controller;

import com.tracker.expense_tracker_application.model.AppUser;
import com.tracker.expense_tracker_application.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/users")
public class AppUserController {

    @Autowired
    private AppUserService appUserService;

    @GetMapping
    public String getAllUsers(Model model) {
        List<AppUser> users = appUserService.findAllUsers();
        model.addAttribute("users", users);
        return "user-list";
    }

    @GetMapping("/{id}")
    public String getUserById(@PathVariable Long id, Model model) {
        AppUser user = appUserService.findUserById(id).orElse(null);
        model.addAttribute("user", user);
        return "user-detail";
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

    @GetMapping("/delete/{id}")
    public String deleteUserById(@PathVariable Long id) {
        appUserService.deleteUserById(id);
        return "redirect:/users";
    }
}
