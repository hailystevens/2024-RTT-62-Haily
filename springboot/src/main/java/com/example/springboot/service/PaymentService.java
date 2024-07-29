package com.example.springboot.service;

import com.example.springboot.database.dao.PaymentDAO;
import com.example.springboot.database.entity.Payment;
import com.example.springboot.form.CreatePaymentFormBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;

@Slf4j
@Service
public class PaymentService {

    @Autowired
    private PaymentDAO paymentDAO;

    public Payment createPayment(CreatePaymentFormBean form) {
        Payment payment = new Payment();
        payment.setId(form.getCustomerId());
        payment.setCheckNumber(form.getCheckNumber());

        // Convert String to Date
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            payment.setPaymentDate(dateFormat.parse(form.getPaymentDate()));
        } catch (ParseException e) {
            log.error("Error parsing payment date: " + form.getPaymentDate(), e);
        }

        payment.setAmount(form.getAmount());
        return paymentDAO.save(payment);
    }
}
