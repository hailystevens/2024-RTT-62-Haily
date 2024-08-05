package com.example.springboot.controller;

import com.example.springboot.database.dao.EmployeeDAO;
import com.example.springboot.database.entity.Employee;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Controller
public class IndexController {

    @Autowired
    private EmployeeDAO employeeDAO;

    @GetMapping("/")
    public ModelAndView index() {
        ModelAndView response = new ModelAndView("index");

        log.info("Accessing home page");

        response.addObject("message", "We sell model cars, boats, and other items.");
        return response;
    }

    @GetMapping("/about")
    public ModelAndView about() {
        ModelAndView response = new ModelAndView("about");
        log.info("Accessing about page");
        return response;
    }

    @GetMapping("/homework")
    public ModelAndView homework(@RequestParam(required = false) String topic) {
        ModelAndView response = new ModelAndView("homework");
        response.addObject("message", topic);
        log.info("Accessing homework page with topic: {}", topic);
        return response;
    }

    @GetMapping("/file-upload")
    public ModelAndView fileUpload(@RequestParam Integer employeeId) {
        ModelAndView response = new ModelAndView("file-upload");
        response.addObject("employeeIdKey", employeeId);
        log.info("Accessing file upload page for employee ID: {}", employeeId);
        return response;
    }

    @PostMapping("/file-upload")
    public ModelAndView fileUploadSubmit(@RequestParam MultipartFile file, @RequestParam Integer employeeId) {
        ModelAndView modelAndView = new ModelAndView("redirect:/employee/" + employeeId);

        log.info("Received file upload request for employee ID: {}", employeeId);
        log.debug("File name: {}", file.getOriginalFilename());
        log.debug("File size: {}", file.getSize());
        log.debug("File content type: {}", file.getContentType());

        String fileName = file.getOriginalFilename();
        if (fileName != null && (fileName.endsWith(".jpg") || fileName.endsWith(".png"))) {
            String saveFilename = "./src/main/webapp/pub/images/" + fileName;
            try {
                Files.copy(file.getInputStream(), Paths.get(saveFilename), StandardCopyOption.REPLACE_EXISTING);
                log.info("File saved successfully: {}", saveFilename);
            } catch (Exception e) {
                log.error("Unable to finish reading file", e);
            }

            Employee employee = employeeDAO.findById(employeeId);
            if (employee != null) {
                String url = "/pub/images/" + fileName;
                employee.setProfileImageUrl(url);
                employeeDAO.save(employee);
                log.info("Updated employee profile image URL: {}", url);
            } else {
                log.error("Employee not found for ID: {}", employeeId);
                modelAndView.addObject("errorMessage", "Employee not found");
            }
        } else {
            log.error("Invalid file type. Only JPG and PNG are allowed.");
            modelAndView.addObject("errorMessage", "Invalid file type. Only JPG and PNG are allowed.");
        }

        return modelAndView;
    }
}
