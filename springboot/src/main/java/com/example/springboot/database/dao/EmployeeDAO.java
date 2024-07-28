
package com.example.springboot.database.dao;

import com.example.springboot.database.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeeDAO extends JpaRepository<Employee, Long> {
    Employee findById(Integer id);

    Employee findByEmailIgnoreCase(String email);

    // this is a JPA query just like we did in the hibernate module
    @Query("select e from Employee e where e.firstname like concat('%', :name, '%') or e.lastname like concat('%', :name, '%')")
    List<Employee> findByName(String name);
}
