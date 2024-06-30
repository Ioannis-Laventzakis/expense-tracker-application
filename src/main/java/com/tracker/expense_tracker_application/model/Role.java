package com.tracker.expense_tracker_application.model;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

/**
 * This is an entity class for the Role.
 * It represents the "roles" table in the database.
 * It contains fields for the role's ID, name, and associated users.
 * It also contains getter and setter methods for these fields.
 */
@Entity
@Table(name = "roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(unique = true, nullable = false)
    private String name;

    @ManyToMany(mappedBy ="roles")
    private Set<User>users = new HashSet<>();

    /**
     * This is a no-args constructor for the Role class.
     */
    public Role(){

    }

    /**
     * This method returns the ID of the role.
     *
     * @return the ID of the role
     */
    public Long getId() {
        return id;
    }

    /**
     * This method sets the ID of the role.
     *
     * @param id the ID of the role
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method returns the name of the role.
     *
     * @return the name of the role
     */
    public String getName() {
        return name;
    }

    /**
     * This method sets the name of the role.
     *
     * @param name the name of the role
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * This method returns the users associated with the role.
     *
     * @return the users associated with the role
     */
    public Set<User> getUsers() {
        return users;
    }

    /**
     * This method sets the users associated with the role.
     *
     * @param users the users associated with the role
     */
    public void setUsers(Set<User> users) {
        this.users = users;
    }
}