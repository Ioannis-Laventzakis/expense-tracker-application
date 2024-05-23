
package com.tracker.expense_tracker_application.repository;

import com.tracker.expense_tracker_application.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserRepository extends JpaRepository<AppUser, Long> {}
