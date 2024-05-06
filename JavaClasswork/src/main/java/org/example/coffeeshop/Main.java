package org.example.coffeeshop;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private CoffeeShop coffeeShop = new CoffeeShop();
    private Scanner scanner= new Scanner(System.in);

    public void printMenu() {
        System.out.println("0) Exit");
        System.out.println("1) Print the list of products");
        System.out.println("2) Order a product");
        System.out.println("3) Checkout");

    }

    public void runCoffeeShop() {
        coffeeShop = new CoffeeShop();
        coffeeShop.initProducts();
        coffeeShop.printProducts();
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.runCoffeeShop();
    }
}
