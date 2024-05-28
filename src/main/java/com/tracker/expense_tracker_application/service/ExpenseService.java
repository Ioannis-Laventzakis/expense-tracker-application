package com.tracker.expense_tracker_application.service;

import com.tracker.expense_tracker_application.model.Expense;
import java.time.LocalDate;
import java.util.List;

/**
 * Service interface for handling operations related to the Expense entity.
 * This interface provides methods for CRUD operations and custom operations
 * such as updating specific fields of an expense, deleting expenses by category or date range, etc.
 */
public interface ExpenseService {

    /**
     * Retrieves all expenses.
     *
     * @return a list of all expenses
     */
    List<Expense> getAllExpenses();

    /**
     * Retrieves an expense by its ID.
     *
     * @param id the ID of the expense to retrieve
     * @return the expense with the given ID
     */
    Expense getExpenseById(Long id);

    /**
     * Creates a new expense.
     *
     * @param expense the expense to create
     * @return the created expense
     */
    Expense createExpense(Expense expense);

    /**
     * Updates an existing expense.
     *
     * @param id the ID of the expense to update
     * @param expense the expense data to update
     * @return the updated expense
     */
    Expense updateExpense(Long id, Expense expense);

    /**
     * Deletes an expense by its ID.
     *
     * @param id the ID of the expense to delete
     */
    void deleteExpense(Long id);

    // Custom Operations

    /**
     * Updates the amount of an expense.
     *
     * @param id the ID of the expense to update
     * @param amount the new amount
     */
    void updateExpenseAmount(Long id, Double amount);

    /**
     * Deletes expenses by category.
     *
     * @param category the category of the expenses to delete
     */
    void deleteByCategory(String category);

    /**
     * Updates the description of an expense.
     *
     * @param id the ID of the expense to update
     * @param description the new description
     */
    void updateExpenseDescription(Long id, String description);

    /**
     * Updates the category of an expense.
     *
     * @param id the ID of the expense to update
     * @param category the new category
     */
    void updateExpenseCategory(Long id, String category);

    /**
     * Deletes expenses by date range.
     *
     * @param startDate the start date of the range
     * @param endDate the end date of the range
     */
    void deleteByDateRange(LocalDate startDate, LocalDate endDate);

    /**
     * Updates the date of an expense.
     *
     * @param id the ID of the expense to update
     * @param date the new date
     */
    void updateExpenseDate(Long id, LocalDate date);

    /**
     * Updates the user of an expense.
     *
     * @param id the ID of the expense to update
     * @param userId the ID of the new user
     */
    void updateExpenseUser(Long id, Long userId);

    /**
     * Deletes expenses by user.
     *
     * @param userId the ID of the user whose expenses to delete
     */
    void deleteByUser(Long userId);

    /**
     * Updates multiple expenses.
     *
     * @param ids the IDs of the expenses to update
     * @param amount the new amount
     * @param description the new description
     */
    void updateMultipleExpenses(List<Long> ids, Double amount, String description);

    /**
     * Deletes an expense by id.
     *
     * @param id the ID of the expense to delete
     */
    void deleteById(Long id);
}