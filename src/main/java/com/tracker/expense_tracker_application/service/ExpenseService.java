package com.tracker.expense_tracker_application.service;

import com.tracker.expense_tracker_application.model.Expense;
import com.tracker.expense_tracker_application.repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

/**
 * Service class for handling operations related to the Expense entity.
 * This class implements the ExpenseService interface and provides methods for CRUD operations and custom operations
 * such as updating specific fields of an expense, deleting expenses by category or date range, etc.
 */
@Service
public abstract class ExpenseService implements ExpenseService {

    private final ExpenseRepository expenseRepository;

    /**
     * Constructor for ExpenseServiceImpl.
     *
     *
     * @param expenseRepository the repository to be used
     */
    @Autowired
    public ExpenseService(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }

    /**
     * Retrieves all expenses.
     *
     * @return a list of all expenses
     */
    @Override
    public List<Expense> getAllExpenses() {
        return expenseRepository.findAll();
    }

    public abstract List<Expense> getAllExpenses();

    /**
     * Retrieves an expense by its ID.
     *
     * @param id the ID of the expense to retrieve
     * @return the expense with the given ID
     */
    @Override
    public Expense getExpenseById(Long id) {
        return expenseRepository.findById(id).orElse(null);
    }

    /**
     * Creates a new expense.
     *
     * @param expense the expense to create
     * @return the created expense
     */
    @Override
    public Expense createExpense(Expense expense) {
        return expenseRepository.save(expense);
    }

    /**
     * Updates an existing expense.
     *
     * @param id the ID of the expense to update
     * @param expenseDetails the expense data to update
     * @return the updated expense
     */
    @Override
    public Expense updateExpense(Long id, Expense expenseDetails) {
        Expense expense = expenseRepository.findById(id).orElse(null);
        if (expense != null) {
            expense.setAmount(expenseDetails.getAmount());
            expense.setCategory(expenseDetails.getCategory());
            expense.setDescription(expenseDetails.getDescription());
            expense.setDate(expenseDetails.getDate());
            expense.setUser(expenseDetails.getUser());
            return expenseRepository.save(expense);
        }
        return null;
    }

    /**
     * Deletes an expense by its ID.
     *
     * @param id the ID of the expense to delete
     */
    @Override
    public void deleteExpense(Long id) {
        expenseRepository.deleteById(id);
    }

    // Custom Operations

    /**
     * Updates the amount of an expense.
     *
     * @param id the ID of the expense to update
     * @param amount the new amount
     */
    @Override
    public void updateExpenseAmount(Long id, Double amount) {

    }

    /**
     * Deletes expenses by category.
     *
     * @param category the category of the expenses to delete
     */
    @Override
    public void deleteByCategory(String category) {

    }

    /**
     * Updates the description of an expense.
     *
     * @param id the ID of the expense to update
     * @param description the new description
     */
    @Override
    public void updateExpenseDescription(Long id, String description) {

    }

    /**
     * Updates the category of an expense.
     *
     * @param id the ID of the expense to update
     * @param category the new category
     */
    @Override
    public void updateExpenseCategory(Long id, String category) {

    }

    /**
     * Deletes expenses by date range.
     *
     * @param startDate the start date of the range
     * @param endDate the end date of the range
     */
    @Override
    public void deleteByDateRange(LocalDate startDate, LocalDate endDate) {

    }

    /**
     * Updates the date of an expense.
     *
     * @param id the ID of the expense to update
     * @param date the new date
     */
    @Override
    public void updateExpenseDate(Long id, LocalDate date) {

    }

    /**
     * Updates the user of an expense.
     *
     * @param id the ID of the expense to update
     * @param userId the ID of the new user
     */
    @Override
    public void updateExpenseUser(Long id, Long userId) {

    }

    /**
     * Deletes expenses by user.
     *
     * @param userId the ID of the user whose expenses to delete
     */
    @Override
    public void deleteByUser(Long userId) {

    }

    /**
     * Updates multiple expenses.
     *
     * @param ids the IDs of the expenses to update
     * @param amount the new amount
     * @param description the new description
     */
    @Override
    public void updateMultipleExpenses(List<Long> ids, Double amount, String description) {

    }

    /**
     * Deletes an expense by id.
     *
     * @param id the ID of the expense to delete
     */
    @Override
    public void deleteById(Long id) {

    }
}