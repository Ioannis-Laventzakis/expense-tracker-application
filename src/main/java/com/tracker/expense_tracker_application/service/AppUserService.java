// File: src/main/java/com/tracker/expense_tracker_application/service/AppUserService.java
package com.tracker.expense_tracker_application.service;

import com.tracker.expense_tracker_application.model.AppUser;
import com.tracker.expense_tracker_application.repository.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class AppUserService {

    @Autowired
    private AppUserRepository appUserRepository;

    public List<AppUser> findAllUsers() {
        return appUserRepository.findAll();
    }

    public Optional<AppUser> findUserById(Long id) {
        return appUserRepository.findById(id);
    }

    public AppUser saveUser(AppUser user) {
        return appUserRepository.save(user);
    }

    public void deleteUserById(Long id) {
        appUserRepository.deleteById(id);
    }
}
