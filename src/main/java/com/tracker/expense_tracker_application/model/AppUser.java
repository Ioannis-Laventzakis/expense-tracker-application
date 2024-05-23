// File: src/main/java/com/tracker/expense_tracker_application/model/AppUser.java
package com.tracker.expense_tracker_application.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 * Represents an application user with fields for id, username, password, and email.
 * This class is marked as an Entity, meaning it is a JPA entity and will be mapped to a database table.
 */
@Entity
public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    private String email;

    // Getters and setters

    /**
     * Returns the ID of this user.
     * @return the ID of this user
     */
    public Long getId() { return id; }

    /**
     * Sets the ID of this user.
     * @param id the new ID of this user
     */
    public void setId(Long id) { this.id = id; }

    /**
     * Returns the username of this user.
     * @return the username of this user
     */
    public String getUsername() { return username; }

    /**
     * Sets the username of this user.
     * @param username the new username of this user
     */
    public void setUsername(String username) { this.username = username; }

    /**
     * Returns the password of this user.
     * @return the password of this user
     */
    public String getPassword() { return password; }

    /**
     * Sets the password of this user.
     * @param password the new password of this user
     */
    public void setPassword(String password) { this.password = password; }

    /**
     * Returns the email of this user.
     * @return the email of this user
     */
    public String getEmail() { return email; }

    /**
     * Sets the email of this user.
     * @param email the new email of this user
     */
    public void setEmail(String email) { this.email = email; }
}