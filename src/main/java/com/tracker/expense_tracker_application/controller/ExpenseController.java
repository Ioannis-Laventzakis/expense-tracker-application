
package com.tracker.expense_tracker_application.controller;

import org.springframework.ui.Model;
import com.tracker.expense_tracker_application.model.Expense;
import com.tracker.expense_tracker_application.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/expenses")
public class ExpenseController {
    @Autowired
    private ExpenseService expenseService;

    @GetMapping
    public String getAllExpenses(Model model) {
        List<Expense> expenses = expenseService.findAllExpenses();
        model.addAttribute("expenses", expenses);
        return "expense-list";
    }

    @GetMapping("/{id}")
    public String getExpenseById(@PathVariable Long id, Model model) {
        Expense expense = expenseService.findExpenseById(id).orElse(null);
        model.addAttribute("expense", expense);
        return "expense-detail";
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

    @GetMapping("/delete/{id}")
    public String deleteExpenseById(@PathVariable Long id) {
        expenseService.deleteExpenseById(id);
        return "redirect:/expenses";
    }
}
