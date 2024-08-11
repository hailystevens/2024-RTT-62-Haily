package com.example.springboot.controller;

import com.example.springboot.database.dao.ProductDAO;
import com.example.springboot.database.entity.Product;
import com.example.springboot.form.CreateProductFormBean;
import jakarta.validation.Valid; // Requirement: Form bean with 2 different validation annotations
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult; // Requirement: Use @Valid with BindingResult (not on registration page)
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.security.access.prepost.PreAuthorize;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Slf4j
@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductDAO productDAO;

    @GetMapping("/list") // Requirement: Have one GET controller method
    public String showProductList(Model model) {
        List<Product> products = productDAO.findAll(); // Retrieve all products from the database
        model.addAttribute("products", products); // Pass the products list to the view
        return "product/list"; // Maps to product/list.jsp
    }

    @GetMapping("/detail") // Requirement: Have one GET controller method
    public String showDetailPage(@RequestParam("id") Integer id, Model model) {
        Optional<Product> productOpt = productDAO.findById(id);
        if (productOpt.isPresent()) {
            model.addAttribute("product", productOpt.get()); // Pass the product to the view
            return "product/detail"; // Maps to product/detail.jsp
        } else {
            return "redirect:/product/list"; // Redirect to product list if product not found
        }
    }

    @GetMapping("/search") // Requirement: Use @RequestParam
    public ModelAndView search(@RequestParam("query") String query) {
        List<Product> products = productDAO.findByNameOrCategory(query); // Search products by name or category
        ModelAndView response = new ModelAndView("product/search-results"); // Maps to product/search-results.jsp
        response.addObject("products", products); // Pass the search results to the view
        return response;
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/create")
    public ModelAndView showCreatePage() {
        ModelAndView response = new ModelAndView("product/create"); // Maps to product/create.jsp
        response.addObject("form", new CreateProductFormBean()); // Add an empty form bean to the view
        return response;
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/create") // Requirement: Have one POST controller method
    public String createProductSubmit(@Valid @ModelAttribute("form") CreateProductFormBean form,
                                      BindingResult bindingResult, @RequestParam("imageFile") MultipartFile imageFile) {

        if (imageFile.isEmpty()) {
            bindingResult.addError(new FieldError("form", "imageFile", "The image file is required"));
        }

        if (bindingResult.hasErrors()) { // Validate form inputs
            return "product/create"; // Return to create page if validation fails
        }

        Product product = new Product();
        product.setName(form.getName());
        product.setBrand(form.getBrand());
        product.setCategory(form.getCategory());
        product.setDescription(form.getDescription());
        product.setPrice(form.getPrice());
        product.setCreatedAt(new Date());

        // Save image file
        Date createdAt = new Date();
        String storageFileName = createdAt.getTime() + "_" + imageFile.getOriginalFilename();

        try {
            String uploadDir = "src/main/webapp/pub/imgs/";
            Path uploadPath = Paths.get(uploadDir);

            if (!Files.exists(uploadPath)) {
                Files.createDirectories(uploadPath); // Create the directory if it doesn't exist
            }

            try (InputStream inputStream = imageFile.getInputStream()) {
                Files.copy(inputStream, uploadPath.resolve(storageFileName), StandardCopyOption.REPLACE_EXISTING); // Save the image file
            }
        } catch (Exception ex) {
            log.error("Error saving image file", ex);
        }

        product.setImageFileName(storageFileName); // Set the image file name in the product entity

        productDAO.save(product); // Save the product to the database

        return "redirect:/product/list"; // Redirect to the product list page
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/edit") // Requirement: Create and Edit page for at least one table
    public ModelAndView showEditPage(@RequestParam("id") Integer id) {
        ModelAndView response = new ModelAndView("product/edit"); // Maps to product/edit.jsp
        Optional<Product> productOpt = productDAO.findById(id);
        if (productOpt.isPresent()) {
            CreateProductFormBean form = new CreateProductFormBean();
            Product product = productOpt.get();
            form.setId(product.getId());
            form.setName(product.getName());
            form.setBrand(product.getBrand());
            form.setCategory(product.getCategory());
            form.setDescription(product.getDescription());
            form.setPrice(product.getPrice());
            form.setImageFile(product.getImageFile());
            response.addObject("form", form); // Add the form bean with existing product data to the view
        } else {
            return new ModelAndView("redirect:/product/list"); // Redirect to product list if product not found
        }
        return response;
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/edit") // Requirement: Create and Edit page for at least one table
    public String editProductSubmit(@Valid @ModelAttribute("form") CreateProductFormBean form,
                                    BindingResult result, @RequestParam("imageFile") MultipartFile imageFile) {

        if (imageFile.isEmpty() && (form.getImageFile() == null || form.getImageFile().isEmpty())) {
            result.addError(new FieldError("form", "imageFile", "The image file is required"));
        }

        if (result.hasErrors()) { // Validate form inputs
            return "product/edit"; // Return to edit page if validation fails
        }

        Product product = productDAO.findById(form.getId()).orElse(new Product());
        product.setName(form.getName());
        product.setBrand(form.getBrand());
        product.setCategory(form.getCategory());
        product.setDescription(form.getDescription());
        product.setPrice(form.getPrice());

        // Save image file
        if (!imageFile.isEmpty()) {
            Date createdAt = new Date();
            String storageFileName = createdAt.getTime() + "_" + imageFile.getOriginalFilename();

            try {
                String uploadDir = "src/main/webapp/pub/imgs/";
                Path uploadPath = Paths.get(uploadDir);

                if (!Files.exists(uploadPath)) {
                    Files.createDirectories(uploadPath); // Create the directory if it doesn't exist
                }

                try (InputStream inputStream = imageFile.getInputStream()) {
                    Files.copy(inputStream, uploadPath.resolve(storageFileName), StandardCopyOption.REPLACE_EXISTING); // Save the image file
                }
            } catch (Exception ex) {
                log.error("Error saving image file", ex);
            }

            product.setImageFileName(storageFileName); // Set the image file name in the product entity
        }

        productDAO.save(product); // Save the updated product to the database

        return "redirect:/product/list"; // Redirect to the product list page
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/delete")
    public String deleteProduct(@RequestParam("id") Integer id) {
        Optional<Product> productOpt = productDAO.findById(id);
        if (productOpt.isPresent()) {
            productDAO.delete(productOpt.get()); // Delete the product from the database
            return "redirect:/product/list"; // Redirect to the product list page
        } else {
            return "redirect:/product/list"; // Redirect to product list if product not found
        }
    }
}
