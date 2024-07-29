package com.example.springboot.service;

import com.example.springboot.database.dao.ProductDAO;
import com.example.springboot.database.entity.Product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class ProductService {

    @Autowired
    private ProductDAO productDAO;

    public Product createProduct(Product product) {
        return productDAO.save(product);
    }

    public Product getProductById(Integer id) {
        return productDAO.findById(id).orElse(null);
    }

    public List<Product> getAllProducts() {
        return productDAO.findAll();
    }

    public void deleteProductById(Integer id) {
        productDAO.deleteById(id);
    }
}
