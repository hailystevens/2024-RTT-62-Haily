package com.example.springboot.controller;

import com.example.springboot.database.dao.PaymentDAO;
import com.example.springboot.database.entity.Payment;
import com.example.springboot.form.CreatePaymentFormBean;
import com.example.springboot.service.PaymentService;
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
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private PaymentDAO paymentDAO;

    @Autowired
    private PaymentService paymentService;

    // List all payments
    @GetMapping("/list")
    public ModelAndView listAll() {
        ModelAndView response = new ModelAndView("payment/list");
        List<Payment> payments = paymentDAO.findAll();
        response.addObject("paymentsKey", payments);
        return response;
    }

    // View payment details
    @GetMapping("/{id}")
    public ModelAndView detail(@PathVariable Integer id) {
        ModelAndView response = new ModelAndView("payment/detail");
        log.debug("The user wants the payment with id: " + id);

        Optional<Payment> paymentOpt = paymentDAO.findById(id);
        if (paymentOpt.isPresent()) {
            Payment payment = paymentOpt.get();
            response.addObject("paymentKey", payment);
        } else {
            response.addObject("message", "Payment not found");
        }

        return response;
    }

    // List payments by customer ID
    @GetMapping("/list-by-customer")
    public ModelAndView listByCustomerId(@RequestParam Integer customerId) {
        ModelAndView response = new ModelAndView("payment/list-by-customer");
        log.debug("The user wants the payments for customer id: " + customerId);

        List<Payment> payments = paymentDAO.findByCustomerId(customerId);
        response.addObject("paymentsKey", payments);

        return response;
    }

    // Show create.jsp payment form
    @GetMapping("/create")
    public ModelAndView create() {
        return new ModelAndView("payment/create.jsp");
    }

    // Handle payment creation
    @PostMapping("/createSubmit")
    public ModelAndView createSubmit(@Valid CreatePaymentFormBean form, BindingResult bindingResult) {
        ModelAndView response = new ModelAndView();
        log.debug(form.toString());

        if (bindingResult.hasErrors()) {
            for (ObjectError error : bindingResult.getAllErrors()) {
                log.debug("Validation error: " + ((FieldError) error).getField() + " = " + error.getDefaultMessage());
            }
            response.addObject("bindingResult", bindingResult);
            response.setViewName("payment/create.jsp");
            response.addObject("form", form);
            return response;
        } else {
            Payment payment = paymentService.createPayment(form);
            response.setViewName("redirect:/payment/" + payment.getId());
            return response;
        }
    }

    // Show edit payment form
    @GetMapping("/edit")
    public ModelAndView edit(@RequestParam(required = false) Integer id) {
        ModelAndView response = new ModelAndView("payment/create.jsp");

        if (id != null) {
            Optional<Payment> paymentOpt = paymentDAO.findById(id);
            if (paymentOpt.isPresent()) {
                Payment payment = paymentOpt.get();
                CreatePaymentFormBean form = new CreatePaymentFormBean();
                form.setId(payment.getId());
                form.setCheckNumber(payment.getCheckNumber());
                form.setPaymentDate(payment.getPaymentDate());
                form.setAmount(payment.getAmount());
                response.addObject("form", form);
            } else {
                response.addObject("message", "The payment was not found in the database.");
            }
        }

        return response;
    }
}
