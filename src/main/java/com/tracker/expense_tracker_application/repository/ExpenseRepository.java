// File: src/main/java/com/tracker/expense_tracker_application/repository/ExpenseRepository.java
package com.tracker.expense_tracker_application.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.tracker.expense_tracker_application.model.Expense;

/**
 * Repository interface for Expense entities.
 * This interface extends JpaRepository, allowing for the use of JpaRepository methods
 * for CRUD operations on Expense entities without the need for custom method definitions.
 */
@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Long> {
}