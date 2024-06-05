package org.example.database.dao;

import jakarta.persistence.TypedQuery;
import org.example.database.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import java.util.List;
import java.util.Scanner;

class CustomerDAO {
    public void insert(Customer customer) {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        session.getTransaction().begin();
        session.save(customer);
        session.getTransaction().commit();
        session.close();
    }

    void update(Customer customer) {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        session.getTransaction().begin();
        session.merge(customer);
        session.getTransaction().commit();
        session.close();
    }

    void delete(Customer customer) {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        session.getTransaction().begin();
        session.delete(customer);
        session.getTransaction().commit();
        session.close();
    }

    public List<Customer> findByCustomerName(String customerName) {
        System.out.println("-------- MySQL JDBC Connection Demo ------------");
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        String hql = "SELECT c FROM Customer c WHERE c.customerName = :customerName";
        try {
            TypedQuery<Customer> query = session.createQuery(hql, Customer.class);
            query.setParameter("customerName", customerName);
            List<Customer> result = query.getResultList();
            return result;
        } catch (Exception e) {
            return null;
        } finally {
            session.close();
        }
    }

    List<Customer> findByContactFirstName(String firstName) {
        System.out.println("-------- MySQL JDBC Connection Demo ------------");
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        String hql = "SELECT c FROM Customer c WHERE c.contactFirstname = :contactFirstName and c.salesRepEmployeeId IS NOT null";
        TypedQuery<Customer> query = session.createQuery(hql, Customer.class);
        query.setParameter("contactFirstName", firstName);
        List<Customer> result = query.getResultList();
        session.close();
        return result;
    }

    void findCustomerById() {
        System.out.println("-------- MySQL JDBC Connection Demo ------------");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Customer ID: ");
        Integer customerId = scanner.nextInt();
        System.out.println("Enter New Contact's First Name: ");
        String firstName = scanner.next();
        System.out.println("Enter New Contact's Last Name: ");
        String lastName = scanner.next();
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        String hql = "SELECT c FROM Customer c WHERE c.id = :id and c.salesRepEmployeeId IS NOT null";

        TypedQuery<Customer> query = session.createQuery(hql, Customer.class);
        query.setParameter("id", customerId);
        Customer result = query.getSingleResult();
        result.setContactFirstname(firstName);
        result.setContactLastname(lastName);
        update(result);
        System.out.println("Done! Contact updated to: " + result.getContactFirstname() + " " + result.getContactLastname());
        session.close();
    }
}