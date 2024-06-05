package org.example.database;

import org.example.database.entity.Employee;

import java.util.List;

import org.example.database.dao.EmployeeDAO;

public class FirstHibernateDemo {
    public static void main(String[] args) {
        EmployeeDAO employeeDAO = new EmployeeDAO();
        List<Employee> employees = employeeDAO.findByFirstName("Doe");
        for (Employee employee : employees) {
            System.out.println(employee.getId() + " | " + employee.getFirstname() + " " + employee.getLastname() + " | "
                    + employee.getEmail() + " | " + employee.getJobTitle());
        }
    }
}
