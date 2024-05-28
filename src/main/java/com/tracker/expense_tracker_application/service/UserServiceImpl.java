package com.tracker.expense_tracker_application.service;

import com.tracker.expense_tracker_application.model.AppUser;
import com.tracker.expense_tracker_application.repository.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service class for handling operations related to the AppUser entity.
 * This class implements the UserService interface and provides methods for CRUD operations.
 */
@Service
public class UserServiceImpl implements UserService {

    /**
     * The repository to be used for CRUD operations.
     */
    @Autowired
    private AppUserRepository userRepository;

    /**
     * Retrieves all users.
     *
     * @return a list of all users
     */
    @Override
    public List<AppUser> getAllUsers() {
        return userRepository.findAll();
    }

    /**
     * Retrieves a user by its ID.
     *
     * @param id the ID of the user to retrieve
     * @return the user with the given ID or null if no such user exists
     */
    @Override
    public AppUser getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    /**
     * Creates a new user.
     *
     * @param user the user to create
     * @return the created user
     */
    @Override
    public AppUser createUser(AppUser user) {
        return userRepository.save(user);
    }

    /**
     * Updates an existing user.
     *
     * @param id the ID of the user to update
     * @param user the user data to update
     * @return the updated user or null if no such user exists
     * @throws IllegalArgumentException if the provided id is null
     */
    @Override
    public AppUser updateUser(Long id, AppUser user) {
        if (id == null) {
            throw new IllegalArgumentException("id must not be null");
        }
        AppUser existingUser = userRepository.findById(id).orElse(null);
        if (existingUser != null) {
            existingUser.setUsername(user.getUsername());
            existingUser.setPassword(user.getPassword());
            existingUser.setEmail(user.getEmail());
            return userRepository.save(existingUser);
        }
        return null;
    }

    /**
     * Deletes a user by its ID.
     *
     * @param id the ID of the user to delete
     */
    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}