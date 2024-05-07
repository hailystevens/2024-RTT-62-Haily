package org.example.coffeeshop;

import java.util.ArrayList;
import java.util.List;

public class CoffeeShop {

    private List<Products> products = new ArrayList<>();

    // building the menu of products for sale at the coffee shop
    public void initProducts() {
        Products p1 = new Products();
        p1.setPrice(5.46);
        p1.setName("Small Coffee");
        p1.setBeverage(true);
        products.add(p1);

        Products largeCoffee = new Products();
        largeCoffee.setPrice(9.46);
        largeCoffee.setName("Large Coffee");
        largeCoffee.setBeverage(true);
        products.add(largeCoffee);

        Products cakePop = new Products();
        cakePop.setPrice(4.89);
        cakePop.setName("Cake Pop");
        cakePop.setBeverage(false);
        products.add(cakePop);

        Products eggSandwich = new Products(7.89, "Egg Sandwich", false, 50);
        products.add(eggSandwich);
    }

    // print the list of products available for sale
    public void printProducts() {
        for (int pos = 0; pos < products.size(); pos++) {
            Products product = products.get(pos);
            System.out.println((pos + 1) + ") " + product.getName() + "\t" + product.getPrice());
        }
    }
}