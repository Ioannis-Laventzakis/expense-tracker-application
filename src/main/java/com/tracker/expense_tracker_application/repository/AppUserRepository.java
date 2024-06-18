package com.tracker.expense_tracker_application.repository;

import com.tracker.expense_tracker_application.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppUserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
