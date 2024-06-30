package com.tracker.expense_tracker_application.model;

import jakarta.persistence.*;

import java.time.LocalDate;

/**
 * This is an entity class for the Expense.
 * It represents the "expenses" table in the database.
 * It contains fields for the expense's ID, user, amount, description, category, and date.
 * It also contains getter and setter methods for these fields.
 */
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

    /**
     * This is a no-args constructor for the Expense class.
     */
    public Expense() {
    }

    /**
     * This is a constructor for the Expense class.
     * It initializes the id, user, amount, description, category, and date fields.
     *
     * @param id the ID of the expense
     * @param user the user who made the expense
     * @param amount the amount of the expense
     * @param description the description of the expense
     * @param category the category of the expense
     * @param date the date of the expense
     */
    public Expense(Long id, User user, Double amount, String description, String category,
                   LocalDate date) {
        this.id = id;
        this.user = user;
        this.amount = amount;
        this.description = description;
        this.category = category;
        this.date = date;
    }

    /**
     * This is a constructor for the Expense class.
     * It initializes the user, amount, description, category, and date fields.
     *
     * @param user the user who made the expense
     * @param amount the amount of the expense
     * @param description the description of the expense
     * @param category the category of the expense
     * @param date the date of the expense
     */
    public Expense(User user, Double amount, String description, String category,
                   LocalDate date) {
        this.user = user;
        this.amount = amount;
        this.description = description;
        this.category = category;
        this.date = date;
    }

    /**
     * This method returns the user who made the expense.
     *
     * @return the user who made the expense
     */
    public User getUser() {
        return user;
    }

    /**
     * This method sets the user who made the expense.
     *
     * @param user the user who made the expense
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * This method returns the ID of the expense.
     *
     * @return the ID of the expense
     */
    public Long getId() {
        return id;
    }

    /**
     * This method sets the ID of the expense.
     *
     * @param id the ID of the expense
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method returns the amount of the expense.
     *
     * @return the amount of the expense
     */
    public Double getAmount() {
        return amount;
    }

    /**
     * This method sets the amount of the expense.
     *
     * @param amount the amount of the expense
     */
    public void setAmount(Double amount) {
        this.amount = amount;
    }

    /**
     * This method returns the description of the expense.
     *
     * @return the description of the expense
     */
    public String getDescription() {
        return description;
    }

    /**
     * This method sets the description of the expense.
     *
     * @param description the description of the expense
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * This method returns the category of the expense.
     *
     * @return the category of the expense
     */
    public String getCategory() {
        return category;
    }

    /**
     * This method sets the category of the expense.
     *
     * @param category the category of the expense
     */
    public void setCategory(String category) {
        this.category = category;
    }

    /**
     * This method returns the date of the expense.
     *
     * @return the date of the expense
     */
    public LocalDate getDate() {
        return date;
    }

    /**
     * This method sets the date of the expense.
     *
     * @param date the date of the expense
     */
    public void setDate(LocalDate date) {
        this.date = date;
    }
}