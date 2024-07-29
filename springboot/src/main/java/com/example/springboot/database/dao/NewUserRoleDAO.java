package com.example.springboot.database.dao;

import com.example.springboot.database.entity.NewUserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NewUserRoleDAO extends JpaRepository<NewUserRole, Integer> {

    // Method to find user roles by user id
    List<NewUserRole> findByUserId(Integer userId);
}
