package com.tracker.expense_tracker_application.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

/**
 * This is a configuration class that defines a bean for sending mails.
 * The bean is of type JavaMailSender, which is an interface provided by Spring Framework.
 * It provides functions for sending simple mails as well as mails with attachments.
 */
@Configuration
public class MailConfig {

    /**
     * This method defines a JavaMailSender bean.
     * JavaMailSenderImpl is a concrete implementation of the JavaMailSender interface.
     * It supports MIME messages and is mostly used in conjunction with the MimeMessageHelper class for the creation of a MimeMessage.
     * It's configured with Simple Mail Transfer Protocol (SMTP) parameters such as host, port, username, and password.
     * It also sets JavaMail properties such as the transport protocol, SMTP authentication, and the enabling of the StartTLS command.
     *
     * @return a JavaMailSender
     */
    @Bean
    public JavaMailSender javaMailSender(){
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();

        mailSender.setHost("smtp.gmail.com");
        mailSender.setPort(587);
        mailSender.setUsername("expensetracker51@gmail.com");
        mailSender.setPassword("ijtq zaip vaac njtm");

        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.debug", "true");

        return  mailSender;
    }

}