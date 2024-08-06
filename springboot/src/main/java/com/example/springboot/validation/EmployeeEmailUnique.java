package com.example.springboot.validation;

public interface EmployeeEmailUnique {


}
//package com.example.springboot.validation;
//
//import jakarta.validation.Constraint;
//import jakarta.validation.Payload;
//
//import java.lang.annotation.ElementType;
//import java.lang.annotation.Retention;
//import java.lang.annotation.RetentionPolicy;
//import java.lang.annotation.Target;
//
//@Constraint(validatedBy = EmployeeEmailUniqueValidator.class)
//@Target({ ElementType.FIELD })
//@Retention(RetentionPolicy.RUNTIME)
//public @interface EmployeeEmailUnique {
//
//    String message() default "Email is already in use.";
//
//    Class<?>[] groups() default {};
//
//    Class<? extends Payload>[] payload() default {};
//}package com.example.springboot.validation;
//
//import com.example.springboot.database.dao.EmployeeDAO;
//import com.example.springboot.database.entity.Employee;
//import jakarta.validation.ConstraintValidator;
//import jakarta.validation.ConstraintValidatorContext;
//import org.springframework.beans.factory.annotation.Autowired;
//
//public class EmployeeEmailUniqueValidator implements ConstraintValidator<EmployeeEmailUnique, String> {
//
//    @Autowired
//    private EmployeeDAO employeeDAO;
//
//    @Override
//    public void initialize(EmployeeEmailUnique constraintAnnotation) {
//        // Initialization code if needed
//    }
//
//    @Override
//    public boolean isValid(String email, ConstraintValidatorContext context) {
//        if (email == null || email.isEmpty()) {
//            return true; // Skip validation if email is not provided
//        }
//
//        Employee employee = employeeDAO.findByEmail(email);
//        return employee == null; // Valid if no employee with this email exists
//    }
//}package com.example.springboot.database.dao;
//
//import com.example.springboot.database.entity.Employee;
//import org.springframework.data.jpa.repository.JpaRepository;
//
//public interface EmployeeDAO extends JpaRepository<Employee, Long> {
//    Employee findByEmail(String email);
//}
//package com.example.springboot.form;
//
//import com.example.springboot.validation.EmployeeEmailUnique;
//import lombok.Getter;
//import lombok.Setter;
//import lombok.ToString;
//import org.hibernate.validator.constraints.Length;
//import jakarta.validation.constraints.NotEmpty;
//
//@Getter
//@Setter
//@ToString
//public class CreateEmployeeFormBean {
//
//    private Integer id;
//
//    @Length(max = 100, message = "Email must be less than 100 characters")
//    @NotEmpty(message = "Email is required.")
//    @EmployeeEmailUnique
//    private String email;
//
//    @Length(max = 50, message = "Last Name must be less than 50 characters")
//    @NotEmpty(message = "Last Name is required.")
//    private String lastName;
//
//    @Length(max = 50, message = "First Name must be less than 50 characters")
//    @NotEmpty(message = "First Name is required.")
//    private String firstName;
//
//    private String extension;
//    private String jobTitle;
//    private Integer vacationHours;
//    private String profileImageUrl;
//    private Integer officeId;
//    private Integer reportsTo;
//
//    // other fields and methods...
//}