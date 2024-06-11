package org.example;

import org.example.database.dao.EmployeeDAO;
import org.example.database.entity.Employee;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class EmployeeMain {

    private static EmployeeDAO employeeDAO = new EmployeeDAO();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        EmployeeMain main = new EmployeeMain();
        main.run();
    }

    public void run() {
        while (true) {
            System.out.println("1. Find Employee by ID");
            System.out.println("2. Find Employees by First Name");
            System.out.println("3. Insert New Employee");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (option) {
                case 1:
                    findEmployeeById();
                    break;
                case 2:
                    findEmployeesByFirstName();
                    break;
                case 3:
                    insertEmployee();
                    break;
                case 4:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private void findEmployeeById() {
        System.out.print("Enter Employee ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        Employee employee = employeeDAO.findById(id);
        if (employee != null) {
            System.out.println("Employee Found: " + employee.getFirstname() + " " + employee.getLastname());
        } else {
            System.out.println("Employee not found.");
        }
    }

    private void findEmployeesByFirstName() {
        System.out.print("Enter Employee First Name: ");
        String firstName = scanner.nextLine();
        List<Employee> employees = employeeDAO.findByFirstName(firstName);
        if (!employees.isEmpty()) {
            for (Employee employee : employees) {
                System.out.println("Employee: " + employee.getFirstname() + " " + employee.getLastname());
            }
        } else {
            System.out.println("No employees found with the given first name.");
        }
    }

    private void insertEmployee() {
        Employee employee = new Employee();
        System.out.print("Enter First Name: ");
        employee.setFirstname(scanner.nextLine());
        System.out.print("Enter Last Name: ");
        employee.setLastname(scanner.nextLine());
        System.out.print("Enter Email: ");
        employee.setEmail(scanner.nextLine());
        System.out.print("Enter Job Title: ");
        employee.setJobTitle(scanner.nextLine());

        employeeDAO.insert(employee);
        System.out.println("Employee inserted successfully.");
    }
}



