// File: src/main/java/com/tracker/expense_tracker_application/repository/ExpenseRepository.java
package com.tracker.expense_tracker_application.repository;

import com.tracker.expense_tracker_application.model.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

/**
 * Repository interface for Expense entities.
 * This interface extends JpaRepository, allowing for the use of JpaRepository methods
 * for CRUD operations on Expense entities.
 */
@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Long> {

    /**
     * Update the amount of an expense by its ID.
     * @param amount the new amount
     * @param id the ID of the expense to update
     */
    @Modifying
    @Transactional
    @Query("UPDATE Expense e SET e.amount = :amount WHERE e.id = :id")
    void updateAmountById(Double amount, Long id);

    /**
     * Delete all expenses of a specific category.
     * @param category the category of expenses to delete
     */
    @Modifying
    @Transactional
    @Query("DELETE FROM Expense e WHERE e.category = :category")
    void deleteByCategory(String category);

    // Add other custom methods as needed, following the same pattern

    /**
     * Find all expenses by a specific user.
     * @param userId the ID of the user
     * @return a list of expenses
     */
    @Query("SELECT e FROM Expense e WHERE e.user.id = :userId")
    List<Expense> findByUserId(Long userId);

    /**
     * Find all expenses within a specific date range.
     * @param startDate the start date
     * @param endDate the end date
     * @return a list of expenses
     */
    @Query("SELECT e FROM Expense e WHERE e.date BETWEEN :startDate AND :endDate")
    List<Expense> findByDateRange(LocalDate startDate, LocalDate endDate);
}
