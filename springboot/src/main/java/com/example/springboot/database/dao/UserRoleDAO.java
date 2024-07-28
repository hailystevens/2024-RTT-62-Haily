

package com.example.springboot.database.dao;

import com.example.springboot.database.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRoleDAO extends JpaRepository<UserRole, Long> {
    UserRole findById(Integer id);

}
