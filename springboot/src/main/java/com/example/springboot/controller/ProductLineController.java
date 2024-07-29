package com.example.springboot.controller;

import com.example.springboot.database.dao.ProductLineDAO;
import com.example.springboot.database.entity.ProductLine;
import com.example.springboot.form.CreateProductLineFormBean;
import com.example.springboot.service.ProductLineService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Slf4j
@Controller
@RequestMapping("/productline")
public class ProductLineController {

    @Autowired
    private ProductLineDAO productLineDAO;

    @Autowired
    private ProductLineService productLineService;

    // List all product lines
    @GetMapping("/list")
    public ModelAndView listAll() {
        ModelAndView response = new ModelAndView("productline/list");
        List<ProductLine> productLines = productLineDAO.findAll();
        response.addObject("productLinesKey", productLines);
        return response;
    }

    // View product line details
    @GetMapping("/{id}")
    public ModelAndView detail(@PathVariable Integer id) {
        ModelAndView response = new ModelAndView("productline/detail");
        log.debug("The user wants the product line with id: " + id);

        Optional<ProductLine> productLineOpt = productLineDAO.findById(id);
        if (productLineOpt.isPresent()) {
            ProductLine productLine = productLineOpt.get();
            response.addObject("productLineKey", productLine);
        } else {
            response.addObject("message", "Product Line not found");
        }

        return response;
    }

    // Show create.jsp product line form
    @GetMapping("/create")
    public ModelAndView create() {
        return new ModelAndView("productline/create.jsp");
    }

    // Handle product line creation
    @PostMapping("/createSubmit")
    public ModelAndView createSubmit(@Valid CreateProductLineFormBean form, BindingResult bindingResult) {
        ModelAndView response = new ModelAndView();
        log.debug(form.toString());

        if (bindingResult.hasErrors()) {
            for (ObjectError error : bindingResult.getAllErrors()) {
                log.debug("Validation error: " + ((FieldError) error).getField() + " = " + error.getDefaultMessage());
            }
            response.addObject("bindingResult", bindingResult);
            response.setViewName("productline/create.jsp");
            response.addObject("form", form);
            return response;
        } else {
            ProductLine productLine = productLineService.createProductLine(form);
            response.setViewName("redirect:/productline/" + productLine.getId());
            return response;
        }
    }

    // Show edit product line form
    @GetMapping("/edit")
    public ModelAndView edit(@RequestParam(required = false) Integer id) {
        ModelAndView response = new ModelAndView("productline/create.jsp");

        if (id != null) {
            Optional<ProductLine> productLineOpt = productLineDAO.findById(id);
            if (productLineOpt.isPresent()) {
                ProductLine productLine = productLineOpt.get();
                CreateProductLineFormBean form = new CreateProductLineFormBean();
                form.setId(productLine.getId());
                form.setProductLine(productLine.getProductLine());
                form.setDescription(productLine.getDescription());
                response.addObject("form", form);
            } else {
                response.addObject("message", "The product line was not found in the database.");
            }
        }

        return response;
    }
}
