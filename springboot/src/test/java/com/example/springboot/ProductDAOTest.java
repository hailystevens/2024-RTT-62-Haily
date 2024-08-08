package com.example.springboot;

import com.example.springboot.database.dao.ProductDAO;
import com.example.springboot.database.entity.Product;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ProductDAOTest {

    @Autowired
    private ProductDAO productDAO;

    private static Integer productId;

    @Test
    @Order(1)
    public void testCreateProduct() {
        Product product = new Product();
        product.setName("Test Product");
        product.setCategory("Test Category");
        product.setDescription("Test Description");
        product.setBrand("Test Brand"); // Ensure brand is not null
        product.setImageFileName("test_image.jpg");

        productDAO.save(product);
        productId = product.getId();

        assertNotNull(product.getId());
    }

    @Test
    @Order(2)
    public void testReadProduct() {
        Optional<Product> productOptional = productDAO.findById(productId);
        assertTrue(productOptional.isPresent());
        Product product = productOptional.get();
        assertEquals("Test Product", product.getName());
    }

    @Test
    @Order(3)
    public void testUpdateProduct() {
        Optional<Product> productOptional = productDAO.findById(productId);
        assertTrue(productOptional.isPresent());
        Product product = productOptional.get();
        product.setName("Updated Product");
        productDAO.save(product);

        Optional<Product> updatedProductOptional = productDAO.findById(productId);
        assertTrue(updatedProductOptional.isPresent());
        Product updatedProduct = updatedProductOptional.get();
        assertEquals("Updated Product", updatedProduct.getName());
    }

    @Test
    @Order(4)
    public void testDeleteProduct() {
        productDAO.deleteById(productId);
        Optional<Product> productOptional = productDAO.findById(productId);
        assertFalse(productOptional.isPresent());
    }
}
