package com.example.springboot.controller;

import com.example.springboot.database.entity.Product;
import com.example.springboot.form.CreateProductFormBean;
import com.example.springboot.service.ProductService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Slf4j
@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    // List all products
    @GetMapping("/list")
    public ModelAndView list() {
        ModelAndView response = new ModelAndView("product/list");
        List<Product> products = productService.getAllProducts();
        response.addObject("productsKey", products);
        return response;
    }

    // View product details
    @GetMapping("/{id}")
    public ModelAndView detail(@PathVariable Integer id) {
        ModelAndView response = new ModelAndView("product/detail");
        Product product = productService.getProductById(id);
        if (product != null) {
            response.addObject("productKey", product);
        } else {
            response.addObject("message", "Product not found");
        }
        return response;
    }

    // Show create product form
    @GetMapping("/create")
    public ModelAndView create() {
        return new ModelAndView("product/create");
    }

    // Handle product creation
    @PostMapping("/createSubmit")
    public ModelAndView createSubmit(@Valid CreateProductFormBean form, BindingResult bindingResult) {
        ModelAndView response = new ModelAndView();
        if (bindingResult.hasErrors()) {
            response.addObject("bindingResult", bindingResult);
            response.setViewName("product/create");
            response.addObject("form", form);
            return response;
        } else {
            Product product = new Product();
            product.setProductName(form.getProductName());
            product.setProductCode(form.getProductCode());
            product.setProductLine(form.getProductlineId());
            product.setProductScale(form.getProductScale());
            product.setProductVendor(form.getProductVendor());
            product.setProductDescription(form.getProductDescription());
            product.setQuantityInStock(form.getQuantityInStock());
            product.setBuyPrice(form.getBuyPrice());
            product.setMsrp(form.getMsrp());
            productService.createProduct(product);
            response.setViewName("redirect:/product/" + product.getId());
            return response;
        }
    }

    // Show edit product form
    @GetMapping("/edit")
    public ModelAndView edit(@RequestParam(required = false) Integer id) {
        ModelAndView response = new ModelAndView("product/create");
        if (id != null) {
            Product product = productService.getProductById(id);
            if (product != null) {
                CreateProductFormBean form = new CreateProductFormBean();
                form.setId(product.getId());
                form.setProductName(product.getProductName());
                form.setProductCode(product.getProductCode());
                form.setProductLineId(product.getProductLine());
                form.setProductScale(product.getProductScale());
                form.setProductVendor(product.getProductVendor());
                form.setProductDescription(product.getProductDescription());
                form.setQuantityInStock(product.getQuantityInStock());
                form.setBuyPrice(product.getBuyPrice());
                form.setMsrp(product.getMsrp());
                response.addObject("form", form);
            } else {
                response.addObject("messageKey", "The product was not found in the database.");
            }
        }
        return response;
    }
}
