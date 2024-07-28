package com.example.springboot.controller;

import com.example.springboot.database.dao.OrderDetailDAO;
import com.example.springboot.database.entity.OrderDetail;
import com.example.springboot.form.OrderDetailsBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/order")
public class OrderDetailController {

    @Autowired
    private OrderDetailDAO orderDetailDAO;

    @GetMapping("/details")
    public ModelAndView orderDetails(@RequestParam Integer orderId) {
        ModelAndView response = new ModelAndView("allOrderDetails");

        List<OrderDetail> orderDetails = orderDetailDAO.findByOrderId(orderId);

        List<OrderDetailsBean> orderDetailList = new ArrayList<>();
        DecimalFormat df = new DecimalFormat("#,###.00");
        Double orderTotal = 0.00;

        for (OrderDetail od : orderDetails) {
            OrderDetailsBean orderDetailsBean = new OrderDetailsBean();
            orderDetailsBean.setOrderId(od.getOrderId());
            orderDetailsBean.setProductId(od.getProductId());
            orderDetailsBean.setQuantityOrdered(od.getQuantityOrdered());
            orderDetailsBean.setProductName(od.getProduct().getProductName());
            orderDetailsBean.setPriceEach(od.getPriceEach());

            Double total = od.getQuantityOrdered() * od.getPriceEach();
            orderDetailsBean.setTotal(df.format(total));
            orderTotal += total;

            orderDetailList.add(orderDetailsBean);
        }

        response.addObject("orderDetailList", orderDetailList);
        response.addObject("orderTotal", df.format(orderTotal));

        return response;
    }
}
