package org.example;

import org.example.database.dao.ProductLineDAO;
import org.example.database.entity.ProductLine;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class ProductLineMain {

    private ProductLineDAO productLineDAO = new ProductLineDAO();
    private Scanner scanner = new Scanner(System.in);

    public void run() {
        while (true) {
            System.out.println("1. Create ProductLine");
            System.out.println("2. Read ProductLines");
            System.out.println("3. Update ProductLine");
            System.out.println("4. Delete ProductLine");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    createProductLine();
                    break;
                case 2:
                    readProductLines();
                    break;
                case 3:
                    updateProductLine();
                    break;
                case 4:
                    deleteProductLine();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void createProductLine() {
        System.out.print("Enter product line: ");
        String productLine = scanner.nextLine();
        System.out.print("Enter description: ");
        String description = scanner.nextLine();

        ProductLine newProductLine = new ProductLine();
        newProductLine.setProductLine(productLine);
        newProductLine.setDescription(description);

        productLineDAO.insert(newProductLine);
        System.out.println("ProductLine created successfully.");
    }

    private void readProductLines() {
        List<ProductLine> productLines = productLineDAO.findAll();
        if (productLines.isEmpty()) {
            System.out.println("No product lines found.");
        } else {
            for (ProductLine productLine : productLines) {
                System.out.println(productLine);
            }
        }
    }

    private void updateProductLine() {
        System.out.print("Enter product line ID to update: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        ProductLine productLine = productLineDAO.findById(id);
        if (productLine == null) {
            System.out.println("ProductLine not found.");
            return;
        }

        System.out.print("Enter new product line: ");
        String newProductLine = scanner.nextLine();
        System.out.print("Enter new description: ");
        String newDescription = scanner.nextLine();

        productLine.setProductLine(newProductLine);
        productLine.setDescription(newDescription);

        productLineDAO.update(productLine);
        System.out.println("ProductLine updated successfully.");
    }

    private void deleteProductLine() {
        System.out.print("Enter product line ID to delete: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        ProductLine productLine = productLineDAO.findById(id);
        if (productLine == null) {
            System.out.println("ProductLine not found.");
            return;
        }

        productLineDAO.delete(productLine);
        System.out.println("ProductLine deleted successfully.");
    }

    public static void main(String[] args) {
        ProductLineMain productLineMain = new ProductLineMain();
        productLineMain.run();
    }
}
