
package com.example.springboot.database.dao;

import com.example.springboot.database.entity.Office;
import org.springframework.data.jpa.repository.JpaRepository;


public interface OfficeDAO extends JpaRepository<Office, Long> {
    Office findById(Integer id);
}
