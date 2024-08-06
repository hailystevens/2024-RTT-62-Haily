package com.example.springboot.database.dao;

import com.example.springboot.database.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRoleDAO extends JpaRepository<UserRole, Long> {
    List<UserRole> findByUserId(Integer userId);
}
