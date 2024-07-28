package com.example.springboot.database.dao;

import com.example.springboot.database.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface EmployeeDAO extends JpaRepository<Employee, Integer> {
    Optional<Employee> findById(Integer id);

    Employee findByEmailIgnoreCase(String email);

    @Query("select e from Employee e where e.firstname like concat('%', :name, '%') or e.lastname like concat('%', :name, '%')")
    List<Employee> findByName(String name);
}
