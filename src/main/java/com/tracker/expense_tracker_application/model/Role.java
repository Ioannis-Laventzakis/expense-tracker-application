package com.tracker.expense_tracker_application.model;


import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

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

    //Getter  and Setters
    public Role(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<User> getUsers() {
        return users;
        user.getRoles().add(this);
    }

    public void setUsers(Set<User> users) {
        this.users.remove(user);
        user.getRoles().remove(this);
    }
}
