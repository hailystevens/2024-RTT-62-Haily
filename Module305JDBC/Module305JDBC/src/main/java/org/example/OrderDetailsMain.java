package org.example;

import org.example.database.dao.OrderDetailsDAO;
import org.example.database.dao.ProductDAO;
import org.example.database.entity.OrderDetails;
import org.example.database.entity.Product;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class OrderDetailsMain {

    private OrderDetailsDAO orderDetailsDAO = new OrderDetailsDAO();
    private ProductDAO productDAO = new ProductDAO();
    private Scanner scanner = new Scanner(System.in);

    public void run() {
        while (true) {
            // 1) Prompt the user to enter an order ID
            Integer orderId = promptForOrderId();

            // 2) Fetch the order details for the specified order ID
            List<OrderDetails> orderDetailList = orderDetailsDAO.findByOrderId(orderId);
            printOrderDetails(orderDetailList);

            if (!orderDetailList.isEmpty()) {
                // 3) Prompt the user to enter a product ID
                Integer productId = promptForProductId();

                // Fetch the product by ID
                Product product = productDAO.findById(productId);

                if (product != null) {
                    // 4) Check if the product is already part of the order
                    OrderDetails orderDetail = orderDetailsDAO.findByProductIdAndOrderId(productId, orderId);

                    if (orderDetail == null) {
                        // If not, create a new order detail
                        orderDetail = new OrderDetails();
                        orderDetail.setOrder(orderDetailList.get(0).getOrder());
                        orderDetail.setProduct(product);
                        orderDetail.setQuantityOrdered(1); // Set initial quantity to 1
                    } else {
                        // If so, increment the quantity ordered
                        int quantity = orderDetail.getQuantityOrdered();
                        orderDetail.setQuantityOrdered(quantity + 1);
                    }

                    // 5) Save the order details (insert or update)
                    orderDetailsDAO.save(orderDetail);
                    System.out.println("Order details updated successfully!");
                } else {
                    System.out.println("Product not found.");
                }
            }

            // Check if the user wants to continue
            System.out.println("Would you like to modify another order's details? (yes/no)");
            String continueSearch = scanner.nextLine().trim().toLowerCase();
            if (!continueSearch.equals("yes")) {
                break;
            }
        }
    }

    // Prompt the user to enter an order ID
    private Integer promptForOrderId() {
        while (true) {
            try {
                System.out.print("Enter an order ID: ");
                int orderId = scanner.nextInt();
                scanner.nextLine(); // Clear the newline character
                return orderId;
            } catch (InputMismatchException e) {
                System.out.println("Please enter a valid number.");
                scanner.nextLine(); // Clear the invalid input
            }
        }
    }

    // Print the order details for the given order ID
    private void printOrderDetails(List<OrderDetails> orderDetailList) {
        if (orderDetailList == null || orderDetailList.isEmpty()) {
            System.out.println("No order details found for the given order ID.");
            return;
        }

        System.out.println("Order Details ID | Product ID | Product Name | Quantity Ordered | Price Each | Order Line Number");
        System.out.println("===============================================================================================");
        for (OrderDetails orderDetail : orderDetailList) {
            System.out.printf("%d | %d | %s | %d | %.2f | %d%n",
                    orderDetail.getId(),
                    orderDetail.getProduct().getId(),
                    orderDetail.getProduct().getProductName(),
                    orderDetail.getQuantityOrdered(),
                    orderDetail.getPriceEach(),
                    orderDetail.getOrderLineNumber());
        }
        System.out.println("\n");
    }

    // Prompt the user to enter a product ID
    private Integer promptForProductId() {
        while (true) {
            try {
                System.out.print("Enter the product ID: ");
                int productId = scanner.nextInt();
                scanner.nextLine(); // Clear the newline character
                return productId;
            } catch (InputMismatchException e) {
                System.out.println("Please enter a valid number.");
                scanner.nextLine(); // Clear the invalid input
            }
        }
    }

    public static void main(String[] args) {
        OrderDetailsMain odm = new OrderDetailsMain();
        odm.run();
    }
}
