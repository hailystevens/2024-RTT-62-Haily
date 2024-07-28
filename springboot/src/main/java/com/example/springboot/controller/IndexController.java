package com.example.springboot.controller;

import com.example.springboot.database.dao.ProductDAO;
import com.example.springboot.database.entity.Product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Slf4j
@Controller
public class IndexController {

    @Autowired
    private ProductDAO productDAO;

    @GetMapping("/")
    public ModelAndView index() {
        ModelAndView response = new ModelAndView("index");
        response.addObject("message", "Hello World!");
        return response;
    }

    @GetMapping("/search")
    public ModelAndView searchProducts(@RequestParam(required = false) String search) {
        ModelAndView response = new ModelAndView("searchProducts");

        List<Product> products;
        if (search != null && !search.isEmpty()) {
            products = productDAO.findByProductNameContainingIgnoreCase(search);
        } else {
            products = productDAO.findAll();
        }

        response.addObject("search", search);
        response.addObject("products", products);

        return response;
    }
}
