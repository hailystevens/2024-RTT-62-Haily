package com.example.springboot.controller;

import com.example.springboot.database.dao.ProductDAO;
import com.example.springboot.database.entity.Product;
import com.example.springboot.form.CreateProductFormBean;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

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

    @GetMapping("/list")
    public String showProductList(Model model) {
        List<Product> products = productDAO.findAll();
        model.addAttribute("products", products);
        return "product/list";
    }

    @GetMapping("/create")
    public ModelAndView showCreatePage() {
        ModelAndView response = new ModelAndView("product/create");
        response.addObject("form", new CreateProductFormBean());
        return response;
    }

    @PostMapping("/create")
    public String createProductSubmit(@Valid @ModelAttribute("form") CreateProductFormBean form,
                                      BindingResult bindingResult, @RequestParam("imageFile") MultipartFile imageFile) {

        if (imageFile.isEmpty()) {
            bindingResult.addError(new FieldError("form", "imageFile", "The image file is required"));
        }

        if (bindingResult.hasErrors()) {
            return "product/create";
        }

        Product product = new Product();
        product.setName(form.getName());
        product.setBrand(form.getBrand());
        product.setCategory(form.getCategory());
        product.setDescription(form.getDescription());
        product.setPrice(form.getPrice());
        product.setCreatedAt(new Date());

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

        product.setImageFileName(storageFileName);

        productDAO.save(product);

        return "redirect:/product/list";
    }

    @GetMapping("/edit")
    public String showEditPage(@RequestParam("id") Integer id, Model model) {
        Optional<Product> productOpt = productDAO.findById(id);
        if (productOpt.isPresent()) {
            model.addAttribute("form", productOpt.get());
            return "product/edit";
        } else {
            return "redirect:/product/list";
        }
    }

    @PostMapping("/edit")
    public String editProduct(@Valid @ModelAttribute("form") CreateProductFormBean form,
                              BindingResult result, @RequestParam("imageFile") MultipartFile imageFile) {

        if (imageFile.isEmpty() && (form.getImageFile() == null || form.getImageFile().isEmpty())) {
            result.addError(new FieldError("form", "imageFile", "The image file is required"));
        }

        if (result.hasErrors()) {
            return "product/edit";
        }

        Product product = productDAO.findById(form.getId()).orElse(new Product());
        product.setName(form.getName());
        product.setBrand(form.getBrand());
        product.setCategory(form.getCategory());
        product.setDescription(form.getDescription());
        product.setPrice(form.getPrice());

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

    @GetMapping("/delete")
    public String deleteProduct(@RequestParam("id") Integer id) {
        Optional<Product> productOpt = productDAO.findById(id);
        if (productOpt.isPresent()) {
            productDAO.delete(productOpt.get());
            return "redirect:/product/list";
        } else {
            return "redirect:/product/list";
        }
    }
}
