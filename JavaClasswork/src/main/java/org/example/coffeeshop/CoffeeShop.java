package org.example.coffeeshop;

import java.util.ArrayList;
import java.util.List;

public class CoffeeShop {

    List<Products> products = new ArrayList<>();

    public void initProducts() {

        Products coffee = new Products();
        coffee.setPrice(5.45);
        coffee.setName("Small coffee");
        coffee.setBeverage(true);
        products.add(coffee);

        Products largeCoffee = new Products();
        largeCoffee.setPrice(9.45);
        largeCoffee.setName("Large coffee");
        largeCoffee.setBeverage(true);
        products.add(largeCoffee);

        Products cakePop = new Products();
        cakePop.setPrice(3.89);
        cakePop.setName("Cake Pop");
        cakePop.setBeverage(false);
        products.add(cakePop);

        Products eggSandwich = new Products(7.89, "Egg Sandwich", false);
        products.add(eggSandwich); // Add eggSandwich to the products list
    }

    public void printProducts() {
        for (int pos = 0; pos < products.size(); pos++) {
            Products product = products.get(pos); // Rename local variable to avoid naming conflict
            System.out.println((pos + 1)+ ") " + product.getName() + "\t" + product.getPrice());
        }
    }
}

