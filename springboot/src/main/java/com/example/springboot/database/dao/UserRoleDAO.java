package com.example.springboot.database.dao;

import com.example.springboot.database.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRoleDAO extends JpaRepository<UserRole, Integer> {

    // Method to find user roles by user id
    List<UserRole> findByUserId(Integer userId);
}
