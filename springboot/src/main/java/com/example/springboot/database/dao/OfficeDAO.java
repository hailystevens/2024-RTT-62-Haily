package com.example.springboot.database.dao;

import com.example.springboot.database.entity.Office;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OfficeDAO extends JpaRepository<Office, Integer> {
}
