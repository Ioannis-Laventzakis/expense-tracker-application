// File: UserService.java
package com.tracker.expense_tracker_application.service;

import com.tracker.expense_tracker_application.model.AppUser;

import java.util.List;

/**
 * Service interface for handling operations related to the AppUser entity.
 * This interface provides methods for CRUD operations.
 */
public interface UserService{

    /**
     * Retrieves all users.
     *
     * @return a list of all users
     */
    List<AppUser> getAllUsers();

    /**
     * Retrieves a user by its ID.
     *
     * @param id the ID of the user to retrieve
     * @return the user with the given ID
     */
    AppUser getUserById(Long id);

    /**
     * Creates a new user.
     *
     * @param user the user to create
     * @return the created user
     */
    AppUser createUser(AppUser user);

    /**
     * Updates an existing user.
     *
     * @param id the ID of the user to update
     * @param user the user data to update
     * @return the updated user
     */
    AppUser updateUser(Long id, AppUser user);

    /**
     * Deletes a user by its ID.
     *
     * @param id the ID of the user to delete
     */
    void deleteUser(Long id);
}