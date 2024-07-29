package com.example.springboot.service;

import com.example.springboot.database.dao.ProductLineDAO;
import com.example.springboot.database.entity.ProductLine;
import com.example.springboot.form.CreateProductLineFormBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class ProductLineService {

    @Autowired
    private ProductLineDAO productLineDAO;

    public ProductLine createProductLine(CreateProductLineFormBean form) {
        ProductLine productLine = new ProductLine();
        productLine.setProductLine(form.getProductLine());
        productLine.setDescription(form.getDescription());
        return productLineDAO.save(productLine);
    }

    public ProductLine getProductLineById(Integer id) {
        return productLineDAO.findById(id).orElse(null);
    }

    public List<ProductLine> getAllProductLines() {
        return productLineDAO.findAll();
    }

    public void deleteProductLineById(Integer id) {
        productLineDAO.deleteById(id);
    }
}
