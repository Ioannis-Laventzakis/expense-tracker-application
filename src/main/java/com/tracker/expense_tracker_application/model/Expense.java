package com.tracker.expense_tracker_application.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "expenses")
public class Expense {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;


    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private Double amount;
    private String description;
    private String category;
    private LocalDate date;

    public Expense() {
    }

    public Expense(Long id, User user, Double amount, String description, String category,
                   LocalDate date) {
        this.id = id;
        this.user = user;
        this.amount = amount;
        this.description = description;
        this.category = category;
        this.date = date;
    }

    public Expense(User user, Double amount, String description, String category,
                   LocalDate date) {
        this.user = user;
        this.amount = amount;
        this.description = description;
        this.category = category;
        this.date = date;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}