package com.tracker.expense_tracker_application.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.tracker.expense_tracker_application.model.Expense;


@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Long> {
}
