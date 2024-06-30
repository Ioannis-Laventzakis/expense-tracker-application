package com.tracker.expense_tracker_application.repository;

import com.tracker.expense_tracker_application.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * This is a repository interface for the User entity.
 * It extends JpaRepository to provide CRUD operations on the User entity.
 * It also includes a custom method for finding a user by its username.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    /**
     * This method finds a user by its username.
     *
     * @param username the username of the user to find
     * @return the user with the given username
     */
    User findByUsername(String username);
}