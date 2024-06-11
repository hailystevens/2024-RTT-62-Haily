package org.example.database.dao;

import jakarta.persistence.TypedQuery;
import org.example.database.entity.OrderDetails;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class OrderDetailsDAO {
    private static SessionFactory sessionFactory;

    static {
        try {
            sessionFactory = new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    // Insert a new OrderDetails entry
    public void insert(OrderDetails orderDetails) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(orderDetails);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Update an existing OrderDetails entry
    public void update(OrderDetails orderDetails) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.merge(orderDetails);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Save (insert or update) an OrderDetails entry
    public void save(OrderDetails orderDetails) {
        if (orderDetails.getId() == null) {
            insert(orderDetails);
        } else {
            update(orderDetails);
        }
    }

    // Find an OrderDetails entry by its ID
    public OrderDetails findById(Integer id) {
        try (Session session = sessionFactory.openSession()) {
            String hql = "SELECT od FROM OrderDetails od JOIN FETCH od.product WHERE od.id = :id";
            TypedQuery<OrderDetails> query = session.createQuery(hql, OrderDetails.class);
            query.setParameter("id", id);
            return query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // Find OrderDetails entries by order ID
    public List<OrderDetails> findByOrderId(Integer orderId) {
        try (Session session = sessionFactory.openSession()) {
            String hql = "SELECT od FROM OrderDetails od JOIN FETCH od.product WHERE od.order.id = :orderId";
            TypedQuery<OrderDetails> query = session.createQuery(hql, OrderDetails.class);
            query.setParameter("orderId", orderId);
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // Find an OrderDetails entry by product ID and order ID
    public OrderDetails findByProductIdAndOrderId(Integer productId, Integer orderId) {
        try (Session session = sessionFactory.openSession()) {
            String hql = "SELECT od FROM OrderDetails od WHERE od.product.id = :productId AND od.order.id = :orderId";
            TypedQuery<OrderDetails> query = session.createQuery(hql, OrderDetails.class);
            query.setParameter("productId", productId);
            query.setParameter("orderId", orderId);
            return query.getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }
}
