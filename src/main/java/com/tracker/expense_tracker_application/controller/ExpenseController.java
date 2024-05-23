// File: src/main/java/com/tracker/expense_tracker_application/controller/ExpenseController.java
package com.tracker.expense_tracker_application.controller;

import org.springframework.ui.Model;
import com.tracker.expense_tracker_application.model.Expense;
import com.tracker.expense_tracker_application.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller for handling expense-related requests.
 */
@Controller
@RequestMapping("/expenses")
public class ExpenseController {

    @Autowired
    private ExpenseService expenseService;

    /**
     * Handles GET requests to fetch all expenses.
     * @param model the model to add attributes to for the view
     * @return the name of the view to render
     */
    @GetMapping
    public String getAllExpenses(Model model) {
        List<Expense> expenses = expenseService.findAllExpenses();
        model.addAttribute("expenses", expenses);
        return "expense-list";
    }

    /**
     * Handles GET requests to fetch an expense by their ID.
     * @param id the ID of the expense to fetch
     * @param model the model to add attributes to for the view
     * @return the name of the view to render
     */
    @GetMapping("/{id}")
    public String getExpenseById(@PathVariable Long id, Model model) {
        Expense expense = expenseService.findExpenseById(id).orElse(null);
        model.addAttribute("expense", expense);
        return "expense-detail";
    }

    /**
     * Handles GET requests to display the form for creating a new expense.
     * @param model the model to add attributes to for the view
     * @return the name of the view to render
     */
    @GetMapping("/new")
    public String createExpenseForm(Model model) {
        model.addAttribute("expense", new Expense());
        return "expense-form";
    }

    /**
     * Handles POST requests to save a new expense.
     * @param expense the expense to save
     * @return a redirect to the expense list view
     */
    @PostMapping
    public String saveExpense(@ModelAttribute Expense expense) {
        expenseService.saveExpense(expense);
        return "redirect:/expenses";
    }

    /**
     * Handles GET requests to delete an expense by their ID.
     * @param id the ID of the expense to delete
     * @return a redirect to the expense list view
     */
    @GetMapping("/delete/{id}")
    public String deleteExpenseById(@PathVariable Long id) {
        expenseService.deleteExpenseById(id);
        return "redirect:/expenses";
    }
}