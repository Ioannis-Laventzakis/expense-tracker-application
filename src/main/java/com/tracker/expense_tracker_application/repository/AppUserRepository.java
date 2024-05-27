package com.tracker.expense_tracker_application.repository;

import com.tracker.expense_tracker_application.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AppUserRepository extends JpaRepository<AppUser, Long> {

    /**
     * Finds an AppUser by their username.
     * @param username the username of the user
     * @return an Optional containing the found user, or empty if no user is found
     */
    Optional<AppUser> findByUsername(String username);
}
