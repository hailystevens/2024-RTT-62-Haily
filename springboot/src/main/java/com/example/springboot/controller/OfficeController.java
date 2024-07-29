package com.example.springboot.controller;

import com.example.springboot.database.entity.Office;
import com.example.springboot.form.CreateOfficeFormBean;
import com.example.springboot.service.OfficeService;
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
@RequestMapping("/office")
public class OfficeController {

    @Autowired
    private OfficeService officeService;

    // List all offices
    @GetMapping("/list")
    public ModelAndView list() {
        ModelAndView response = new ModelAndView("office/list");
        List<Office> offices = officeService.getAllOffices();
        response.addObject("officesKey", offices);
        return response;
    }

    // View office details
    @GetMapping("/{id}")
    public ModelAndView detail(@PathVariable Integer id) {
        ModelAndView response = new ModelAndView("office/detail");
        Office office = officeService.getOfficeById(id);
        if (office != null) {
            response.addObject("officeKey", office);
        } else {
            response.addObject("message", "Office not found");
        }
        return response;
    }

    // Show create office form
    @GetMapping("/create")
    public ModelAndView create() {
        return new ModelAndView("office/create");
    }

    // Handle office creation
    @PostMapping("/createSubmit")
    public ModelAndView createSubmit(@Valid CreateOfficeFormBean form, BindingResult bindingResult) {
        ModelAndView response = new ModelAndView();
        if (bindingResult.hasErrors()) {
            response.addObject("bindingResult", bindingResult);
            response.setViewName("office/create");
            response.addObject("form", form);
            return response;
        } else {
            Office office = new Office();
            office.setCity(form.getCity());
            office.setPhone(form.getPhone());
            office.setAddressLine1(form.getAddressLine1());
            office.setAddressLine2(form.getAddressLine2());
            office.setState(form.getState());
            office.setCountry(form.getCountry());
            office.setPostalCode(form.getPostalCode());
            office.setTerritory(form.getTerritory());
            officeService.createOffice(office);
            response.setViewName("redirect:/office/" + office.getId());
            return response;
        }
    }

    // Show edit office form
    @GetMapping("/edit")
    public ModelAndView edit(@RequestParam(required = false) Integer id) {
        ModelAndView response = new ModelAndView("office/create");
        if (id != null) {
            Office office = officeService.getOfficeById(id);
            if (office != null) {
                CreateOfficeFormBean form = new CreateOfficeFormBean();
                form.setId(office.getId());
                form.setCity(office.getCity());
                form.setPhone(office.getPhone());
                form.setAddressLine1(office.getAddressLine1());
                form.setAddressLine2(office.getAddressLine2());
                form.setState(office.getState());
                form.setCountry(office.getCountry());
                form.setPostalCode(office.getPostalCode());
                form.setTerritory(office.getTerritory());
                response.addObject("form", form);
            } else {
                response.addObject("messageKey", "The office was not found in the database.");
            }
        }
        return response;
    }
}
