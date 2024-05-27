// File: src/main/java/com/tracker/expense_tracker_application/service/AppUserService.java
package com.tracker.expense_tracker_application.service;

import com.tracker.expense_tracker_application.model.AppUser;
import com.tracker.expense_tracker_application.repository.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Service class for handling operations related to AppUser entities.
 * This class is marked as a Service, meaning it is a Spring component that holds business logic.
 */
@Service
@Transactional
public class AppUserService {

    private final AppUserRepository appUserRepository;

    @Autowired
    public AppUserService(AppUserRepository appUserRepository) {
        this.appUserRepository = appUserRepository;
    }

    /**
     * Fetches all AppUser entities from the database.
     * @return a list of all AppUser entities
     */
    public List<AppUser> findAllUsers() {
        return appUserRepository.findAll();
    }

    /**
     * Fetches an AppUser entity by its ID.
     * @param id the ID of the AppUser entity to fetch
     * @return an Optional containing the AppUser entity if found, or empty if not found
     */
    public Optional<AppUser> findUserById(Long id) {
        return appUserRepository.findById(id);
    }

    /**
     * Saves an AppUser entity to the database.
     * If the AppUser entity already exists, it will be updated; otherwise, a new entity will be created.
     * @param user the AppUser entity to save
     * @return the saved AppUser entity
     */
    public AppUser saveUser(AppUser user) {
        return appUserRepository.save(user);
    }

    /**
     * Deletes an AppUser entity by its ID.
     * @param id the ID of the AppUser entity to delete
     */
    public void deleteUserById(Long id) {
        appUserRepository.deleteById(id);
    }
}
