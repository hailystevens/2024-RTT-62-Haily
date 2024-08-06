package com.example.springboot.controller;

import com.example.springboot.database.entity.Product;
import com.example.springboot.database.dao.ProductDAO;
import com.example.springboot.form.CreateProductFormBean;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductDAO productDAO;

    @GetMapping("/list")
    public ModelAndView listAll() {
        ModelAndView response = new ModelAndView("product/list");
        List<Product> products = productDAO.findAll();
        response.addObject("productsKey", products);
        return response;
    }

    @GetMapping("/{id}")
    public ModelAndView showDetail(@PathVariable Integer id) {
        ModelAndView response = new ModelAndView("product/detail");
        Product product = productDAO.findById(id);
        response.addObject("productKey", product);
        return response;
    }

    @GetMapping("/search")
    public ModelAndView searchByNameOrCode(@RequestParam(required = false) String search) {
        ModelAndView response = new ModelAndView("product/search");
        log.debug("The user searched for the term: " + search);
        response.addObject("search", search);
        List<Product> products = productDAO.findByNameOrCode(search);
        response.addObject("productsKey", products);
        return response;
    }

    @GetMapping("/create")
    public ModelAndView create() {
        ModelAndView response = new ModelAndView("product/create");
        return response;
    }

    @PostMapping("/createSubmit")
    public ModelAndView createSubmit(@Valid CreateProductFormBean form, BindingResult bindingResult) {
        ModelAndView response = new ModelAndView();
        log.debug(form.toString());

        if (bindingResult.hasErrors()) {
            for (ObjectError error : bindingResult.getAllErrors()) {
                log.debug("Validation error: " + ((FieldError) error).getField() + " = " + error.getDefaultMessage());
            }
            response.addObject("bindingResult", bindingResult);
            response.addObject("form", form);
            response.setViewName("product/create");
            return response;
        } else {
            Product product = productDAO.findById(form.getId());
            if (product == null) {
                product = new Product();
            }

            product.setProductName(form.getProductName());
            product.setProductCode(form.getProductCode());
            product.setProductDescription(form.getProductDescription());
            product.setBuyPrice(form.getBuyPrice());
            product.setMsrp(form.getMsrp());
            product.setProductLineId(form.getProductLineId());
            product.setProductScale(form.getProductScale());
            product.setProductVendor(form.getProductVendor());
            product.setQuantityInStock(form.getQuantityInStock());

            product = productDAO.save(product);
            response.setViewName("redirect:/product/" + product.getId());
            return response;
        }
    }

    @GetMapping("/edit")
    public ModelAndView edit(@RequestParam(required = false) Integer id) {
        ModelAndView response = new ModelAndView("product/create");
        if (id != null) {
            Product product = productDAO.findById(id);
            if (product != null) {
                CreateProductFormBean form = new CreateProductFormBean();
                form.setId(product.getId());
                form.setProductCode(product.getProductCode());
                form.setProductDescription(product.getProductDescription());
                form.setProductName(product.getProductName());
                form.setBuyPrice(product.getBuyPrice());
                form.setMsrp(product.getMsrp());
                form.setProductLineId(product.getProductLineId());
                form.setProductVendor(product.getProductVendor());
                form.setProductScale(product.getProductScale());
                form.setQuantityInStock(product.getQuantityInStock());
                response.addObject("form", form);
            }
        } else {
            response.addObject("messageKey", "The product was not found in the database.");
        }
        return response;
    }
}
