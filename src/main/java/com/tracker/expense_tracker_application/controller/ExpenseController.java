package com.tracker.expense_tracker_application.controller;

import com.tracker.expense_tracker_application.model.Expense;
import com.tracker.expense_tracker_application.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/expenses")
public class ExpenseController {

    private final ExpenseService expenseService;

    @Autowired
    public ExpenseController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    @GetMapping
    public String getAllExpenses(Model model) {
        List<Expense> expenses = expenseService.findAllExpenses();
        model.addAttribute("expenses", expenses);
        return "expense-list";
    }

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

    @GetMapping("/new")
    public String createExpenseForm(Model model) {
        model.addAttribute("expense", new Expense());
        return "expense-form";
    }

    @PostMapping
    public String saveExpense(@ModelAttribute Expense expense) {
        expenseService.saveExpense(expense);
        return "redirect:/expenses";
    }

    @DeleteMapping("/{id}")
    public String deleteExpenseById(@PathVariable Long id) {
        expenseService.deleteExpenseById(id);
        return "redirect:/expenses";
    }
}
