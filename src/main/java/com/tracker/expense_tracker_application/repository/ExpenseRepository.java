package com.tracker.expense_tracker_application.repository;

import com.tracker.expense_tracker_application.model.Expense;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

/**
 * Repository interface for handling operations related to the Expense entity.
 * This interface extends JpaRepository which provides JPA related methods
 * such as save(), findOne(), findAll(), count(), delete() etc.
 * By extending JpaRepository, we get a bunch of generic CRUD methods into
 * our type that allows saving Expenses, deleting them and so on.
 */
@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Long> {

    /**
     * Updates the amount of an expense.
     *
     * @param id the id of the expense to update
     * @param amount the new amount
     */
    @Modifying
    @Transactional
    @Query("UPDATE Expense e SET e.amount = :amount WHERE e.id = :id")
    void updateExpenseAmount(Long id, Double amount);

    /**
     * Deletes expenses by category.
     *
     * @param category the category of the expenses to delete
     */
    @Modifying
    @Transactional
    @Query("DELETE FROM Expense e WHERE e.category = :category")
    void deleteByCategory(String category);

    /**
     * Updates the description of an expense.
     *
     * @param id the id of the expense to update
     * @param description the new description
     */
    @Modifying
    @Transactional
    @Query("UPDATE Expense e SET e.description = :description WHERE e.id = :id")
    void updateExpenseDescription(Long id, String description);

    /**
     * Updates the category of an expense.
     *
     * @param id the id of the expense to update
     * @param category the new category
     */
    @Modifying
    @Transactional
    @Query("UPDATE Expense e SET e.category = :category WHERE e.id = :id")
    void updateExpenseCategory(Long id, String category);

    /**
     * Deletes expenses by date range.
     *
     * @param startDate the start date of the range
     * @param endDate the end date of the range
     */
    @Modifying
    @Transactional
    @Query("DELETE FROM Expense e WHERE e.date BETWEEN :startDate AND :endDate")
    void deleteByDateRange(LocalDate startDate, LocalDate endDate);

    /**
     * Updates the date of an expense.
     *
     * @param id the id of the expense to update
     * @param date the new date
     */
    @Modifying
    @Transactional
    @Query("UPDATE Expense e SET e.date = :date WHERE e.id = :id")
    void updateExpenseDate(Long id, LocalDate date);

    /**
     * Updates the user of an expense.
     *
     * @param id the id of the expense to update
     * @param userId the id of the new user
     */
    @Modifying
    @Transactional
    @Query("UPDATE Expense e SET e.user.id = :userId WHERE e.id = :id")
    void updateExpenseUser(Long id, Long userId);

    /**
     * Deletes expenses by user.
     *
     * @param userId the id of the user whose expenses to delete
     */
    @Modifying
    @Transactional
    @Query("DELETE FROM Expense e WHERE e.user.id = :userId")
    void deleteByUser(Long userId);

    /**
     * Updates multiple expenses.
     *
     * @param ids the ids of the expenses to update
     * @param amount the new amount
     * @param description the new description
     */
    @Modifying
    @Transactional
    @Query("UPDATE Expense e SET e.amount = :amount, e.description = :description WHERE e.id IN :ids")
    void updateMultipleExpenses(List<Long> ids, Double amount, String description);

    /**
     * Deletes an expense by id.
     *
     * @param id the id of the expense to delete
     */
    @Modifying
    @Transactional
    @Query("DELETE FROM Expense e WHERE e.id = :id")
    void deleteById(Long id);
}