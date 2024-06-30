package com.tracker.expense_tracker_application.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * This is a configuration class that defines a bean for password encoding.
 * The bean is of type BCryptPasswordEncoder, which is a password encoder that uses the BCrypt strong hashing function.
 * When matched up against a log-in request, BCryptPasswordEncoder's matches method will handle salt extraction and password encoding.
 */
@Configuration
public class EncoderConfig {

    /**
     * This method defines a BCryptPasswordEncoder bean.
     * BCryptPasswordEncoder implements PasswordEncoder interface and is provided by Spring Security.
     * It uses the BCrypt strong hashing function to encode passwords.
     *
     * @return a BCryptPasswordEncoder instance
     */
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}