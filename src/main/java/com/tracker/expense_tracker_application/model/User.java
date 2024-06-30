package com.tracker.expense_tracker_application.model;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

/**
 * This is an entity class for the User.
 * It represents the "users" table in the database.
 * It contains fields for the user's ID, username, email, password, expenses, verification status, and roles.
 * It also contains getter and setter methods for these fields.
 */
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Expense> expenses;

    @Column(nullable = false)
    private boolean verified = false;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> roles = new HashSet<>();

    /**
     * This is a no-args constructor for the User class.
     */
    public User() {
    }

    /**
     * This is a constructor for the User class.
     * It initializes the id, username, email, password, expenses, verified, and roles fields.
     *
     * @param id the ID of the user
     * @param username the username of the user
     * @param email the email of the user
     * @param password the password of the user
     * @param expenses the expenses of the user
     * @param verified the verification status of the user
     * @param roles the roles of the user
     */
    public User(Long id, String username, String email, String password, Set<Expense> expenses, boolean verified, Set<Role> roles) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.expenses = expenses;
        this.verified = verified;
        this.roles = roles;
    }

    /**
     * This is a constructor for the User class.
     * It initializes the username, email, password, expenses, verified, and roles fields.
     *
     * @param username the username of the user
     * @param email the email of the user
     * @param password the password of the user
     * @param expenses the expenses of the user
     * @param verified the verification status of the user
     * @param roles the roles of the user
     */
    public User(String username, String email, String password, Set<Expense> expenses, boolean verified, Set<Role> roles) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.expenses = expenses;
        this.verified = verified;
        this.roles = roles;
    }

    /**
     * This method returns the ID of the user.
     *
     * @return the ID of the user
     */
    public Long getId() {
        return id;
    }

    /**
     * This method sets the ID of the user.
     *
     * @param id the ID of the user
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method returns the username of the user.
     *
     * @return the username of the user
     */
    public String getUsername() {
        return username;
    }

    /**
     * This method sets the username of the user.
     *
     * @param username the username of the user
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * This method returns the email of the user.
     *
     * @return the email of the user
     */
    public String getEmail() {
        return email;
    }

    /**
     * This method sets the email of the user.
     *
     * @param email the email of the user
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * This method returns the password of the user.
     *
     * @return the password of the user
     */
    public String getPassword() {
        return password;
    }

    /**
     * This method sets the password of the user.
     *
     * @param password the password of the user
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * This method returns the expenses of the user.
     *
     * @return the expenses of the user
     */
    public Set<Expense> getExpenses() {
        return expenses;
    }

    /**
     * This method sets the expenses of the user.
     *
     * @param expenses the expenses of the user
     */
    public void setExpenses(Set<Expense> expenses) {
        this.expenses = expenses;
    }

    /**
     * This method returns the verification status of the user.
     *
     * @return the verification status of the user
     */
    public boolean isVerified() {
        return verified;
    }

    /**
     * This method sets the verification status of the user.
     *
     * @param verified the verification status of the user
     */
    public void setVerified(boolean verified) {
        this.verified = verified;
    }

    /**
     * This method returns the roles of the user.
     *
     * @return the roles of the user
     */
    public Set<Role> getRoles() {
        return roles;
    }

    /**
     * This method sets the roles of the user.
     *
     * @param roles the roles of the user
     */
    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    /**
     * This method adds a role to the user.
     *
     * @param role the role to add
     */
    public void addRole(Role role) {
        this.roles.add(role);
        role.getUsers().add(this);
    }

    /**
     * This method removes a role from the user.
     *
     * @param role the role to remove
     */
    public void removeRole(Role role) {
        this.roles.remove(role);
        role.getUsers().remove(this);
    }
}