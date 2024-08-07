package com.example.springboot.controller;

import com.example.springboot.database.dao.ProductDAO;
import com.example.springboot.database.entity.Product;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductDAO productDAO;

    @GetMapping("/list")
    public String showProductList(Model model) {
        List<Product> products = productDAO.findAll();
        model.addAttribute("products", products);
        return "product/list";
    }

    @GetMapping("/create")
    public String showCreatePage(Model model) {
        model.addAttribute("product", new Product());
        return "product/create";
    }

    @PostMapping("/create")
    public String createProduct(@Valid @ModelAttribute("product") Product product, BindingResult result, @RequestParam("imageFile") MultipartFile imageFile) {

        if (imageFile.isEmpty()) {
            result.addError(new FieldError("product", "imageFileName", "The image file is required"));
        }

        if (result.hasErrors()) {
            return "product/create";
        }

        // save image file
        Date createdAt = new Date();
        String storageFileName = createdAt.getTime() + "_" + imageFile.getOriginalFilename();

        try {
            String uploadDir = "src/main/webapp/pub/imgs/";
            Path uploadPath = Paths.get(uploadDir);

            if (!Files.exists(uploadPath)) {
                Files.createDirectories(uploadPath);
            }

            try (InputStream inputStream = imageFile.getInputStream()) {
                Files.copy(inputStream, uploadPath.resolve(storageFileName), StandardCopyOption.REPLACE_EXISTING);
            }
        } catch (Exception ex) {
            System.out.println("Exception: " + ex.getMessage());
        }

        product.setCreatedAt(createdAt);
        product.setImageFileName(storageFileName);

        productDAO.save(product);

        return "redirect:/product/list";
    }

    @GetMapping("/edit")
    public String showEditPage(@RequestParam("id") Integer id, Model model) {
        Optional<Product> productOpt = productDAO.findById(id);
        if (productOpt.isPresent()) {
            model.addAttribute("product", productOpt.get());
            return "product/edit";
        } else {
            return "redirect:/product/list";
        }
    }

    @PostMapping("/edit")
    public String editProduct(@Valid @ModelAttribute("product") Product product, BindingResult result, @RequestParam("imageFile") MultipartFile imageFile) {

        if (imageFile.isEmpty() && (product.getImageFileName() == null || product.getImageFileName().isEmpty())) {
            result.addError(new FieldError("product", "imageFileName", "The image file is required"));
        }

        if (result.hasErrors()) {
            return "product/edit";
        }

        // save image file
        if (!imageFile.isEmpty()) {
            Date createdAt = new Date();
            String storageFileName = createdAt.getTime() + "_" + imageFile.getOriginalFilename();

            try {
                String uploadDir = "src/main/webapp/pub/imgs/";
                Path uploadPath = Paths.get(uploadDir);

                if (!Files.exists(uploadPath)) {
                    Files.createDirectories(uploadPath);
                }

                try (InputStream inputStream = imageFile.getInputStream()) {
                    Files.copy(inputStream, uploadPath.resolve(storageFileName), StandardCopyOption.REPLACE_EXISTING);
                }
            } catch (Exception ex) {
                System.out.println("Exception: " + ex.getMessage());
            }

            product.setImageFileName(storageFileName);
        }

        productDAO.save(product);

        return "redirect:/product/list";
    }

    @GetMapping("/detail")
    public String showDetailPage(@RequestParam("id") Integer id, Model model) {
        Optional<Product> productOpt = productDAO.findById(id);
        if (productOpt.isPresent()) {
            model.addAttribute("product", productOpt.get());
            return "product/detail";
        } else {
            return "redirect:/product/list";
        }
    }

}
