package com.example.springboot.service;

import com.example.springboot.database.dao.CustomerDAO;
import com.example.springboot.database.entity.Customer;
import com.example.springboot.form.CreateCustomerFormBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class CustomerService {

    @Autowired
    private CustomerDAO customerDAO;

    public Customer createCustomer(CreateCustomerFormBean form) {
        log.debug(form.toString());

        Customer customer = new Customer();
        customer.setCustomerName(form.getCustomerName());
        customer.setContactLastName(form.getContactLastName());
        customer.setContactFirstName(form.getContactFirstName());
        customer.setPhone(form.getPhone());
        customer.setAddressLine1(form.getAddressLine1());
        customer.setAddressLine2(form.getAddressLine2());
        customer.setCity(form.getCity());
        customer.setState(form.getState());
        customer.setPostalCode(form.getPostalCode());
        customer.setCountry(form.getCountry());
        customer.setCreditLimit(form.getCreditLimit());
        // Set the sales rep employee if applicable

        return customerDAO.save(customer);
    }
}
