package org.example.Module303.Homework.PA303_10_3_PolymorphismandInterface;

public class LibraryInterfaceDemo {
    public static void main(String[] args) {
        KidUser kid1 = new KidUser();

        System.out.println("Kid age: 10");
        kid1.registerAccount(10);
        System.out.println("Kid age: 18");
        kid1.registerAccount(18);
        kid1.setAge(10); //setting kid age back to 10

        System.out.println();

        System.out.println("Book Type: Kids");
        kid1.requestBook("Kids");
        System.out.println("Book Type: Fiction");
        kid1.requestBook("Fiction");

        System.out.println();

        AdultUser adult1 = new AdultUser();
        System.out.println("Adult age: 5");
        adult1.registerAccount(5);
        System.out.println("Adult age: 23");
        adult1.registerAccount(23);

        System.out.println();

        System.out.println("Book Type: Kids");
        adult1.requestBook("Kids");
        System.out.println("Book Type: Fiction");
        adult1.requestBook("Fiction");

    }
}
