// File: src/main/java/com/tracker/expense_tracker_application/ExpenseTrackerApplication.java
package com.tracker.expense_tracker_application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main class for the Expense Tracker application.
 * This class is marked with the @SpringBootApplication annotation, indicating it is a Spring Boot application.
 * The main method in this class serves as the entry point for the application.
 */
@SpringBootApplication
public class ExpenseTrackerApplication {

    /**
     * Main method which serves as the entry point for the application.
     * This method calls the run method from the SpringApplication class, passing in the ExpenseTrackerApplication class
     * and the command line arguments.
     * @param args command line arguments
     */
    public static void main(String[] args) {
        SpringApplication.run(ExpenseTrackerApplication.class, args);
    }

}