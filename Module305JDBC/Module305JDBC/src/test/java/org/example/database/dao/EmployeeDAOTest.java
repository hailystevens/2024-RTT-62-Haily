package org.example.database.dao;

import org.example.database.entity.Employee;
import org.junit.jupiter.api.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class EmployeeDAOTest {

    private static EmployeeDAO employeeDAO;
    private static Employee testEmployee;

    @BeforeAll
    public static void setup() {
        employeeDAO = new EmployeeDAO();
        // Creating a test employee to be used in tests
        testEmployee = new Employee();
        testEmployee.setFirstname("TestFirstName");
        testEmployee.setLastname("TestLastName");
        testEmployee.setEmail("test@example.com");
        testEmployee.setJobTitle("Test Job");
        testEmployee.setOfficeId(1); // Ensure this matches a valid office ID in your database
        employeeDAO.insert(testEmployee);
    }

    @AfterAll
    public static void tearDown() {
        if (testEmployee != null && testEmployee.getId() != null) {
            employeeDAO.delete(testEmployee);
        }
    }

    @Test
    @Order(1)
    public void testFindById() {
        Employee foundEmployee = employeeDAO.findById(testEmployee.getId());
        assertNotNull(foundEmployee);
        assertEquals(testEmployee.getFirstname(), foundEmployee.getFirstname());
    }

    @Test
    @Order(2)
    public void testFindByIdNotFound() {
        Employee foundEmployee = employeeDAO.findById(-1); // Using an ID that doesn't exist
        assertNull(foundEmployee);
    }

    @Test
    @Order(3)
    public void testFindByFirstName() {
        List<Employee> employees = employeeDAO.findByFirstName("TestFirstName");
        assertNotNull(employees);
        assertFalse(employees.isEmpty());
        assertEquals(testEmployee.getFirstname(), employees.get(0).getFirstname());
    }

    @Test
    @Order(4)
    public void testFindByFirstNameNotFound() {
        List<Employee> employees = employeeDAO.findByFirstName("NonExistentFirstName");
        assertNotNull(employees);
        assertTrue(employees.isEmpty());
    }

    @Test
    @Order(5)
    public void testInsertAndDeleteEmployee() {
        Employee employee = new Employee();
        employee.setFirstname("TempFirstName");
        employee.setLastname("TempLastName");
        employee.setEmail("temp@example.com");
        employee.setJobTitle("Temp Job");
        employee.setOfficeId(1); // Ensure this matches a valid office ID in your database

        // Insert employee
        employeeDAO.insert(employee);
        assertNotNull(employee.getId());

        // Query back the record
        Employee foundEmployee = employeeDAO.findById(employee.getId());
        assertNotNull(foundEmployee);
        assertEquals(employee.getFirstname(), foundEmployee.getFirstname());

        // Delete the record
        employeeDAO.delete(foundEmployee);
        Employee deletedEmployee = employeeDAO.findById(employee.getId());
        assertNull(deletedEmployee);
    }
}
