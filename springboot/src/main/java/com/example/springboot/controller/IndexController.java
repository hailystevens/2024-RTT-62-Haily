package com.example.springboot.controller;

import com.example.springboot.database.dao.ProductDAO;
import com.example.springboot.database.entity.Product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable; // Requirement: Use @PathVariable
import org.springframework.web.bind.annotation.PostMapping; // Requirement: Have one POST controller method
import org.springframework.web.bind.annotation.RequestParam; // Requirement: Use @RequestParam
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
    private ProductDAO productDao;

    @GetMapping("/") // Requirement: Have one GET controller method
    public ModelAndView index(@RequestParam(required = false) Integer id) throws Exception {
        ModelAndView response = new ModelAndView("index"); // Maps to index.jsp

        if (id != null) {
            Product product = productDao.findById(id).orElse(null); // Retrieve product by ID
            response.addObject("productKey", product); // Add product to the view
        }

        List<Product> products = productDao.findAll(); // Retrieve all products
        response.addObject("products", products); // Pass the product list to the view

        // Logging various levels for debugging
        log.debug("Debug level");
        log.info("Info level");
        log.warn("Warn level");
        log.error("Error level");

        response.addObject("message", "Welcome to the Store!"); // Add a welcome message

        return response;
    }

    @GetMapping("/index/{id}") // Requirement: Use @PathVariable
    public ModelAndView indexPathVar(@PathVariable(name = "id") Integer productId) {
        ModelAndView response = new ModelAndView("index");

        Product product = productDao.findById(productId).orElse(null);
        response.addObject("productKey", product); // Add product to the view using PathVariable

        return response;
    }

    @GetMapping("/search") // Requirement: Use @RequestParam
    public ModelAndView search(@RequestParam(required = false) String search) {
        ModelAndView response = new ModelAndView("search");

        log.debug("The user searched for the term: " + search); // Log the search term
        response.addObject("search", search); // Pass the search term to the view

        List<Product> products = productDao.findByNameOrCategory(search); // Search products by name or category

        // Requirement: Use a Java stream to iterate a list
        log.debug("=================================== stream ===============================");
        products.stream().forEach(product -> {
            log.debug("Product: " + product.getName());
        });

        log.debug("=================================== for loop ===============================");
        for (Product product : products) {
            log.debug("Product: " + product.getName()); // Iterate products using a traditional for loop
        }

        response.addObject("products", products); // Add the search results to the view
        return response;
    }

    @GetMapping("/file-upload")
    public ModelAndView fileUpload(@RequestParam Integer productId) {
        ModelAndView response = new ModelAndView("file-upload"); // Maps to file-upload.jsp
        response.addObject("productId", productId); // Pass productId to the view
        return response;
    }

    @PostMapping("/file-upload") // Requirement: Have one POST controller method
    public ModelAndView fileUploadSubmit(@RequestParam MultipartFile file, @RequestParam Integer productId) {
        ModelAndView modelAndView = new ModelAndView("redirect:/product/detail?id=" + productId); // Redirect after file upload

        log.debug("The file name is: " + file.getOriginalFilename()); // Log file information
        log.debug("The file size is: " + file.getSize());
        log.debug("The file content type is: " + file.getContentType());

        String saveFilename = "./src/main/webapp/pub/images/" + file.getOriginalFilename(); // Define the file save path

        try {
            Files.copy(file.getInputStream(), Paths.get(saveFilename), StandardCopyOption.REPLACE_EXISTING); // Save the file
        } catch (Exception e) {
            log.error("Unable to finish reading file", e); // Log any errors during file upload
        }

        Product product = productDao.findById(productId).orElse(null); // Find the product by ID

        if (product != null) {
            String url = "/pub/images/" + file.getOriginalFilename(); // Generate the URL for the uploaded file
            product.setImageFileName(url); // Set the image URL in the product entity
            productDao.save(product); // Save the product with the new image
        }

        return modelAndView; // Redirect to the product detail page
    }
}