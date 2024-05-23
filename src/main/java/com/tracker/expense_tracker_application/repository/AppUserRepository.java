// File: src/main/java/com/tracker/expense_tracker_application/repository/AppUserRepository.java
package com.tracker.expense_tracker_application.repository;

import com.tracker.expense_tracker_application.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository interface for AppUser entities.
 * This interface extends JpaRepository, allowing for the use of JpaRepository methods
 * for CRUD operations on AppUser entities without the need for custom method definitions.
 */
public interface AppUserRepository extends JpaRepository<AppUser, Long> {}