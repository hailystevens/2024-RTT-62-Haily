package com.example.springboot.database.dao;

import com.example.springboot.database.entity.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderDetailDAO extends JpaRepository<OrderDetail, Long> {

    // get ONE order detail ROW... by order detail id (this is a magic query in that .... Spring Data JPA is able to use the method name to generate the query)
    OrderDetail findById(Integer id);

    // get LIST of order details.... by order_id (this is a JPA query just like we did in the Hibernate module)
    @Query("select od, p.name from OrderDetail od inner join Product p " +
            " on od.id = p.id " +
            " where od.id= :id " +
            " order by od.orderLineNumber")
    List<OrderDetail> findByOrderId(Integer id);

}
