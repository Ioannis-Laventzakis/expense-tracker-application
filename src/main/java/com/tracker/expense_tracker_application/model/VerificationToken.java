package com.tracker.expense_tracker_application.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

/**
 * This is an entity class for the VerificationToken.
 * It represents the "verification-tokens" table in the database.
 * It contains fields for the token's ID, token string, associated user, and expiry date.
 * It also contains getter and setter methods for these fields.
 */
@Entity
@Table(name = "verification-tokens")
public class VerificationToken {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(nullable = false, unique = true)
    private String token;

    @OneToOne(targetEntity = User.class, fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, name = "user_id")
    private User user;

    @Column(nullable = false)
    private LocalDateTime  expiryDate;

    /**
     * This is a no-args constructor for the VerificationToken class.
     */
    public VerificationToken() {
    }

    /**
     * This is a constructor for the VerificationToken class.
     * It initializes the id, token, user, and expiryDate fields.
     *
     * @param id the ID of the verification token
     * @param token the token string
     * @param user the user associated with the token
     * @param expiryDate the expiry date of the token
     */
    public VerificationToken(Long id, String token, User user, LocalDateTime expiryDate) {
        this.id = id;
        this.token = token;
        this.user = user;
        this.expiryDate = expiryDate;
    }

    /**
     * This is a constructor for the VerificationToken class.
     * It initializes the token, user, and expiryDate fields.
     *
     * @param token the token string
     * @param user the user associated with the token
     * @param expiryDate the expiry date of the token
     */
    public VerificationToken(String token, User user, LocalDateTime expiryDate) {
        this.token = token;
        this.user = user;
        this.expiryDate = expiryDate;
    }

    /**
     * This method returns the ID of the verification token.
     *
     * @return the ID of the verification token
     */
    public Long getId() {
        return id;
    }

    /**
     * This method sets the ID of the verification token.
     *
     * @param id the ID of the verification token
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method returns the token string.
     *
     * @return the token string
     */
    public String getToken() {
        return token;
    }

    /**
     * This method sets the token string.
     *
     * @param token the token string
     */
    public void setToken(String token) {
        this.token = token;
    }

    /**
     * This method returns the user associated with the token.
     *
     * @return the user associated with the token
     */
    public User getUser() {
        return user;
    }

    /**
     * This method sets the user associated with the token.
     *
     * @param user the user associated with the token
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * This method returns the expiry date of the token.
     *
     * @return the expiry date of the token
     */
    public LocalDateTime getExpiryDate() {
        return expiryDate;
    }

    /**
     * This method sets the expiry date of the token.
     *
     * @param expiryDate the expiry date of the token
     */
    public void setExpiryDate(LocalDateTime expiryDate) {
        this.expiryDate = expiryDate;
    }
}