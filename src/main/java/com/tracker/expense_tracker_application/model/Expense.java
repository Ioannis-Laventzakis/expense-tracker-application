package com.tracker.expense_tracker_application.model;

import jakarta.persistence.*;

import java.time.LocalDate;

/**
 * Entity class representing an expense in the application.
 */
@Entity
public class Expense {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double amount;

    private String category;

    private String description;

    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    /**
     * Default constructor for Expense.
     */
    public Expense() {
    }

    /**
     * Constructor for Expense.
     *
     * @param amount the amount of the expense
     * @param category the category of the expense
     * @param description the description of the expense
     * @param date the date of the expense
     * @param user the user who made the expense
     */
    public Expense(Double amount, String category, String description, LocalDate date, User user) {
        this.amount = amount;
        this.category = category;
        this.description = description;
        this.date = date;
        this.user = user;
    }

    /**
     * Constructor for Expense.
     *
     * @param id the id of the expense
     * @param amount the amount of the expense
     * @param category the category of the expense
     * @param description the description of the expense
     * @param date the date of the expense
     * @param user the user who made the expense
     */
    public Expense(Long id, Double amount, String category, String description, LocalDate date, User user) {
        this.id = id;
        this.amount = amount;
        this.category = category;
        this.description = description;
        this.date = date;
        this.user = user;
    }

    /**
     * Sets the id of the expense.
     *
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Gets the id of the expense.
     *
     * @return the id of the expense
     */
    public Long getId() {
        return id;
    }

    /**
     * Gets the amount of the expense.
     *
     * @return the amount of the expense
     */
    public Double getAmount() {
        return amount;
    }

    /**
     * Sets the amount of the expense.
     *
     * @param amount the amount to set
     */
    public void setAmount(Double amount) {
        this.amount = amount;
    }

    /**
     * Gets the category of the expense.
     *
     * @return the category of the expense
     */
    public String getCategory() {
        return category;
    }

    /**
     * Sets the category of the expense.
     *
     * @param category the category to set
     */
    public void setCategory(String category) {
        this.category = category;
    }

    /**
     * Gets the description of the expense.
     *
     * @return the description of the expense
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the description of the expense.
     *
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Gets the date of the expense.
     *
     * @return the date of the expense
     */
    public LocalDate getDate() {
        return date;
    }

    /**
     * Sets the date of the expense.
     *
     * @param date the date to set
     */
    public void setDate(LocalDate date) {
        this.date = date;
    }

    /**
     * Gets the user who made the expense.
     *
     * @return the user who made the expense
     */
    public User getUser() {
        return user;
    }

    /**
     * Sets the user who made the expense.
     *
     * @param user the user to set
     */
    public void setUser(User user) {
        this.user = user;
    }
}