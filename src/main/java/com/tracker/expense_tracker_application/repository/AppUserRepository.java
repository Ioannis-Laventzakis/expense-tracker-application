package com.tracker.expense_tracker_application.repository;

import com.tracker.expense_tracker_application.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for handling operations related to the AppUser entity.
 * This interface extends JpaRepository which provides JPA related methods
 * such as save(), findOne(), findAll(), count(), delete() etc.
 * By extending JpaRepository, we get a bunch of generic CRUD methods into
 * our type that allows saving Users, deleting them and so on.
 */
@Repository
public interface AppUserRepository extends JpaRepository<AppUser, Long> {

}