package com.tracker.expense_tracker_application.repository;

import com.tracker.expense_tracker_application.model.VerificationToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * This is a repository interface for the VerificationToken entity.
 * It extends JpaRepository to provide CRUD operations on the VerificationToken entity.
 * It also includes a custom method for finding a verification token by its token string.
 */
@Repository
public interface VerificationTokenRepository extends JpaRepository<VerificationToken, Long> {

    /**
     * This method finds a verification token by its token string.
     *
     * @param token the token string of the verification token to find
     * @return the verification token with the given token string
     */
    VerificationToken findByToken(String token);
}