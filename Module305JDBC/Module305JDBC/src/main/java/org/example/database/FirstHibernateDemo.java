package org.example.database;

import org.example.database.dao.CustomerDAO;
import org.example.database.dao.EmployeeDAO;
import org.example.database.entity.Employee;

import java.util.List;

public class FirstHibernateDemo {

    public static void main(String[] args) {
        EmployeeDAO employeeDAO = new EmployeeDAO();
        CustomerDAO customerDAO = new CustomerDAO();

        Employee employee = employeeDAO.findById(1056);
        System.out.println(employee);

        employee = employeeDAO.findById(1);
        System.out.println(employee);
    }
}