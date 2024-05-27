// File: src/main/java/com/tracker/expense_tracker_application/model/Expense.java
package com.tracker.expense_tracker_application.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;

/**
 * Represents an expense with fields for id, amount, description, category, date, and user.
 * This class is marked as an Entity, meaning it is a JPA entity and will be mapped to a database table.
 */
@Entity
public class Expense {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Amount is mandatory")
    @Min(value = 0, message = "Amount should be greater than or equal to zero")
    private Double amount;

    @NotBlank(message = "Description is mandatory")
    private String description;

    @NotBlank(message = "Category is mandatory")
    private String category;

    @NotNull(message = "Date is mandatory")
    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private AppUser user;

    // Default constructor
    public Expense() {}

    // Constructor with all fields
    public Expense(Double amount, String description, String category, LocalDate date, AppUser user) {
        this.amount = amount;
        this.description = description;
        this.category = category;
        this.date = date;
        this.user = user;
    }

    // Getters and setters

    /**
     * Returns the ID of this expense.
     * @return the ID of this expense
     */
    public Long getId() { return id; }

    /**
     * Sets the ID of this expense.
     * @param id the new ID of this expense
     */
    public void setId(Long id) { this.id = id; }

    /**
     * Returns the amount of this expense.
     * @return the amount of this expense
     */
    public Double getAmount() { return amount; }

    /**
     * Sets the amount of this expense.
     * @param amount the new amount of this expense
     */
    public void setAmount(Double amount) { this.amount = amount; }

    /**
     * Returns the description of this expense.
     * @return the description of this expense
     */
    public String getDescription() { return description; }

    /**
     * Sets the description of this expense.
     * @param description the new description of this expense
     */
    public void setDescription(String description) { this.description = description; }

    /**
     * Returns the category of this expense.
     * @return the category of this expense
     */
    public String getCategory() { return category; }

    /**
     * Sets the category of this expense.
     * @param category the new category of this expense
     */
    public void setCategory(String category) { this.category = category; }

    /**
     * Returns the date of this expense.
     * @return the date of this expense
     */
    public LocalDate getDate() { return date; }

    /**
     * Sets the date of this expense.
     * @param date the new date of this expense
     */
    public void setDate(LocalDate date) { this.date = date; }

    /**
     * Returns the user who made this expense.
     * @return the user who made this expense
     */
    public AppUser getUser() { return user; }

    /**
     * Sets the user who made this expense.
     * @param user the new user who made this expense
     */
    public void setUser(AppUser user) { this.user = user; }

    @Override
    public String toString() {
        return "Expense{" +
                "id=" + id +
                ", amount=" + amount +
                ", description='" + description + '\'' +
                ", category='" + category + '\'' +
                ", date=" + date +
                ", user=" + user +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Expense expense = (Expense) o;

        return id != null ? id.equals(expense.id) : expense.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
