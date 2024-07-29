package com.example.springboot.database.dao;

import com.example.springboot.database.entity.NewUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface NewUserDAO extends JpaRepository<NewUser, Integer> {

    Optional<NewUser> findByEmail(String email);
}
