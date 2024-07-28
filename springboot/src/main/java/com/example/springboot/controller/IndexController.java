
package com.example.springboot.controller;

import com.example.springboot.database.dao.EmployeeDAO;
import com.example.springboot.database.dao.ProductDAO;
import com.example.springboot.database.entity.Employee;
import com.example.springboot.database.entity.Product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

@Slf4j
@Controller
public class IndexController {
    @Autowired
    private ProductDAO productDAO;
    @Autowired
    private EmployeeDAO employeeDAO;

    @GetMapping("/")
    public ModelAndView index(@RequestParam(required = false) Integer id) { // http://localhost:8080/?id=2
        ModelAndView response = new ModelAndView("index");
        Product product = productDAO.findById(id);
        response.addObject("message", "Hello World!");
        response.addObject("product", product);

        return response;
    }

    @GetMapping("/index/{id}")
//    public ModelAndView indexPathVar(@PathVariable Integer id) { // http://localhost:8080/index/1
    public ModelAndView indexPathVar(@PathVariable(name = "id") Integer productId) { // http://localhost:8080/index/1
        ModelAndView response = new ModelAndView("index");
        Product product = productDAO.findById(productId);
        response.addObject("message", "Hello World!");
        response.addObject("product", product);

        log.debug("Debug level");
        log.info("Info level");
        log.warn("Warn level");
        log.error("Error level");
        return response;
    }

    @GetMapping("/another-page-url")
    public ModelAndView anotherPage() {
        ModelAndView response = new ModelAndView("another-page");
        return response;
    }

    @GetMapping("/search")
    public ModelAndView search(@RequestParam(required = false) String search) {

        log.info("Search term is: " + search);
        ModelAndView response = new ModelAndView("search");
        List<Product> products = productDAO.findByName(search);
        response.addObject("search", search);
        response.addObject("products", products);
        return response;
    }

    @GetMapping("/file-upload")
    public ModelAndView fileUpload(@RequestParam Integer employeeId) {
        ModelAndView response = new ModelAndView("fileUpload");
        response.addObject("employeeId", employeeId);
        return response;
    }

    @PostMapping("/file-upload")
    public ModelAndView fileUploadSubmit(@RequestParam MultipartFile file, @RequestParam Integer employeeId) {
        // this page is for another page of the website which is express as "/page-url"
        ModelAndView modelAndView = new ModelAndView("redirect:/employee/detail?employeeId=" + employeeId);

        log.debug("The file name is: " + file.getOriginalFilename());
        log.debug("The file size is: " + file.getSize());
        log.debug("The file content type is: " + file.getContentType());

        // Homework
        // use the original file name and get a substring of the last index of . to the end of the string
        // then restrict based on "jpg" or "png"
        // use the model to put an error message on the page

        String saveFilename = "./src/main/webapp/assets/img/" + file.getOriginalFilename();

        // this Files.copy is a utility that will read the stream one chunk at a time and write it to a file.
        // first arg is the input stream to read from the uploaded file
        // 2nd is the filename where we want to write the file
        // 3rd says to overwrite if existing.
        try {
            Files.copy(file.getInputStream(), Paths.get(saveFilename), StandardCopyOption.REPLACE_EXISTING);
        } catch (Exception e) {
            log.error("Unable to finish reading file", e);
        }

        // we can load the record from the database based on the incoming employeeId
        Employee employee = employeeDAO.findById(employeeId);

        // this is the URL to get the image
        String url = "/assets/img/" + file.getOriginalFilename();
        employee.setProfileImageUrl(url);

        employeeDAO.save(employee);

        return modelAndView;
    }
}
