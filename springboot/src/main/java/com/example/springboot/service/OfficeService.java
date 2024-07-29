package com.example.springboot.service;

import com.example.springboot.database.dao.OfficeDAO;
import com.example.springboot.database.entity.Office;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class OfficeService {

    @Autowired
    private OfficeDAO officeDAO;

    public Office createOffice(Office office) {
        return officeDAO.save(office);
    }

    public Office getOfficeById(Integer id) {
        return officeDAO.findById(id).orElse(null);
    }

    public List<Office> getAllOffices() {
        return officeDAO.findAll();
    }

    public void deleteOfficeById(Integer id) {
        officeDAO.deleteById(id);
    }
}
