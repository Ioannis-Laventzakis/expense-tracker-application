package com.tracker.expense_tracker_application.repository;

import com.tracker.expense_tracker_application.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * This is a repository interface for the Role entity.
 * It extends JpaRepository to provide CRUD operations on the Role entity.
 * It also includes a custom method for finding a role by its name.
 */
@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    /**
     * This method finds a role by its name.
     *
     * @param name the name of the role to find
     * @return the role with the given name
     */
    Role findByName(String name);
}