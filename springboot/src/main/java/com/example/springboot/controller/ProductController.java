package com.example.springboot.controller;

import com.example.springboot.database.dao.ProductDAO;
import com.example.springboot.database.entity.Product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Slf4j
@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductDAO productDAO;

    @GetMapping("/list")
    public ModelAndView productList(@RequestParam(required = false) String search) {
        ModelAndView response = new ModelAndView("productList");

        List<Product> products = productDAO.findByProductNameContainingIgnoreCase(search);
        response.addObject("products", products);
        response.addObject("search", search);

        return response;
    }

    @GetMapping("/detail")
    public ModelAndView productDetail(@RequestParam Integer id) {
        ModelAndView response = new ModelAndView("productDetail");

        Optional<Product> productOpt = productDAO.findById(id);
        if (productOpt.isPresent()) {
            response.addObject("product", productOpt.get());
        } else {
            response.setViewName("error/404");
        }

        return response;
    }
}
