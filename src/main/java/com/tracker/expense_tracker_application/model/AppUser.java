// File: src/main/java/com/tracker/expense_tracker_application/model/AppUser.java
package com.tracker.expense_tracker_application.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

/**
 * Represents an application user with fields for id, username, password, and email.
 * This class is marked as an Entity, meaning it is a JPA entity and will be mapped to a database table.
 */
@Entity
public class AppUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Username is mandatory")
    @Size(min = 3, max = 50, message = "Username must be between 3 and 50 characters")
    private String username;

    @NotBlank(message = "Password is mandatory")
    @Size(min = 6, max = 100, message = "Password must be between 6 and 100 characters")
    private String password;

    @NotBlank(message = "Email is mandatory")
    @Email(message = "Email should be valid")
    private String email;

    // Default constructor
    public AppUser() {}

    // Constructor with all fields
    public AppUser(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    // Getters and setters

    /**
     * Returns the ID of this user.
     * @return the ID of this user
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the ID of this user.
     * @param id the new ID of this user
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Returns the username of this user.
     * @return the username of this user
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets the username of this user.
     * @param username the new username of this user
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Returns the password of this user.
     * @return the password of this user
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the password of this user.
     * @param password the new password of this user
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Returns the email of this user.
     * @return the email of this user
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the email of this user.
     * @param email the new email of this user
     */
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "AppUser{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AppUser appUser = (AppUser) o;

        return id != null ? id.equals(appUser.id) : appUser.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
