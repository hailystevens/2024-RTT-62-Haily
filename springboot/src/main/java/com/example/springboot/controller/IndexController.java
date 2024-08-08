package com.example.springboot.controller;

import com.example.springboot.database.dao.ProductDAO;
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
    private ProductDAO productDao;

    @GetMapping("/")
    public ModelAndView index(@RequestParam(required = false) Integer id) throws Exception {
        ModelAndView response = new ModelAndView("index");

        if (id != null) {
            Product product = productDao.findById(id).orElse(null);
            response.addObject("productKey", product);
        }

        List<Product> products = productDao.findAll();
        response.addObject("products", products);

        log.debug("Debug level");
        log.info("Info level");
        log.warn("Warn level");
        log.error("Error level");

        response.addObject("message", "Welcome to the Store!");

        return response;
    }

    @GetMapping("/index/{id}")
    public ModelAndView indexPathVar(@PathVariable(name = "id") Integer productId) {
        ModelAndView response = new ModelAndView("index");

        Product product = productDao.findById(productId).orElse(null);
        response.addObject("productKey", product);

        response.addObject("message", "Hello World!");

        return response;
    }

    @GetMapping("/page-url")
    public ModelAndView pageUrl() {
        ModelAndView response = new ModelAndView("another-page");
        return response;
    }

    @GetMapping("/search")
    public ModelAndView search(@RequestParam(required = false) String search) {
        ModelAndView response = new ModelAndView("search");

        log.debug("The user searched for the term: " + search);
        response.addObject("search", search);

        List<Product> products = productDao.findByNameOrCategory(search);

        log.debug("=================================== stream ===============================");
        products.stream().forEach(product -> {
            log.debug("Product: " + product.getName());
        });

        log.debug("=================================== for loop ===============================");
        for (Product product : products) {
            log.debug("Product: " + product.getName());
        }

        response.addObject("products", products);
        return response;
    }

    @GetMapping("/file-upload")
    public ModelAndView fileUpload(@RequestParam Integer productId) {
        ModelAndView response = new ModelAndView("file-upload");
        response.addObject("productId", productId);
        return response;
    }

    @PostMapping("/file-upload")
    public ModelAndView fileUploadSubmit(@RequestParam MultipartFile file, @RequestParam Integer productId) {
        ModelAndView modelAndView = new ModelAndView("redirect:/product/detail?id=" + productId);

        log.debug("The file name is: " + file.getOriginalFilename());
        log.debug("The file size is: " + file.getSize());
        log.debug("The file content type is: " + file.getContentType());

        String saveFilename = "./src/main/webapp/pub/images/" + file.getOriginalFilename();

        try {
            Files.copy(file.getInputStream(), Paths.get(saveFilename), StandardCopyOption.REPLACE_EXISTING);
        } catch (Exception e) {
            log.error("Unable to finish reading file", e);
        }

        Product product = productDao.findById(productId).orElse(null);

        if (product != null) {
            String url = "/pub/images/" + file.getOriginalFilename();
            product.setImageFileName(url);
            productDao.save(product);
        }

        return modelAndView;
    }
}
