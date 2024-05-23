// File: src/main/java/com/tracker/expense_tracker_application/service/ExpenseService.java
package com.tracker.expense_tracker_application.service;

import com.tracker.expense_tracker_application.model.Expense;
import com.tracker.expense_tracker_application.repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;

/**
 * Service class for handling operations related to Expense entities.
 * This class is marked as a Service, meaning it is a Spring component that holds business logic.
 * It is also marked as Transactional, meaning that Spring will automatically manage transactions around method calls.
 */
@Service
@Transactional
public class ExpenseService {

    @Autowired
    private ExpenseRepository expenseRepository;

    /**
     * Fetches all Expense entities from the database.
     * @return a list of all Expense entities
     */
    public List<Expense> findAllExpenses() {
        return expenseRepository.findAll();
    }

    /**
     * Fetches an Expense entity by its ID.
     * @param id the ID of the Expense entity to fetch
     * @return an Optional containing the Expense entity if found, or empty if not found
     */
    public Optional<Expense> findExpenseById(Long id) {
        return expenseRepository.findById(id);
    }

    /**
     * Saves an Expense entity to the database.
     * If the Expense entity already exists, it will be updated; otherwise, a new entity will be created.
     * @param expense the Expense entity to save
     * @return the saved Expense entity
     */
    public Expense saveExpense(Expense expense) {
        return expenseRepository.save(expense);
    }

    /**
     * Deletes an Expense entity by its ID.
     * @param id the ID of the Expense entity to delete
     */
    public void deleteExpenseById(Long id) {
        expenseRepository.deleteById(id);
    }
}