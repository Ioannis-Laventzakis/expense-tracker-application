package com.tracker.expense_tracker_application.controller;

import com.tracker.expense_tracker_application.model.Expense;
import com.tracker.expense_tracker_application.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Controller for handling expense-related requests.
 */
@Controller
@RequestMapping("/expenses")
public class ExpenseController {

    private final ExpenseService expenseService;

    /**
     * Constructor for ExpenseController.
     *
     * @param expenseService the service to be used for expense operations
     */
    @Autowired
    public ExpenseController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    /**
     * Handles the GET request to fetch all expenses.
     *
     * @param model the model to add attributes to for rendering in the view
     * @return the name of the view to render
     */
    @GetMapping
    public String getAllExpenses(Model model) {
        List<Expense> expenses = expenseService.findAllExpenses();
        model.addAttribute("expenses", expenses);
        return "expense-list";
    }

    /**
     * Handles the GET request to fetch an expense by their ID.
     *
     * @param id the ID of the expense to fetch
     * @param model the model to add attributes to for rendering in the view
     * @return the name of the view to render
     */
    @GetMapping("/{id}")
    public String getExpenseById(@PathVariable Long id, Model model) {
        Optional<Expense> expenseOpt = expenseService.findExpenseById(id);
        if (expenseOpt.isPresent()) {
            model.addAttribute("expense", expenseOpt.get());
            return "expense-detail";
        } else {
            model.addAttribute("error", "Expense not found");
            return "error";
        }
    }

    /**
     * Handles the GET request to display the form for creating a new expense.
     *
     * @param model the model to add attributes to for rendering in the view
     * @return the name of the view to render
     */
    @GetMapping("/new")
    public String createExpenseForm(Model model) {
        model.addAttribute("expense", new Expense());
        return "expense-form";
    }

    /**
     * Handles the POST request to save a new expense.
     *
     * @param expense the expense to save
     * @return the redirect view name
     */
    @PostMapping
    public String saveExpense(@ModelAttribute Expense expense) {
        expenseService.saveExpense(expense);
        return "redirect:/expenses";
    }

    /**
     * Handles the DELETE request to delete an expense by their ID.
     *
     * @param id the ID of the expense to delete
     * @return the redirect view name
     */
    @DeleteMapping("/{id}")
    public String deleteExpenseById(@PathVariable Long id) {
        expenseService.deleteExpenseById(id);
        return "redirect:/expenses";
    }
}