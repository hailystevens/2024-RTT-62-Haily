package org.example.Classwork.Slides_303_4;

public class EnumExample {

    enum Cars {
        BMW,
        JEEP,
        AUDI,
        VOLKSWAGON,
        NANO,
        CHEVY,
        FIAT;
    }
    public static void main(String[] args) {

        //Declaring enum variable
        Cars c;
        c = Cars.AUDI;
        //switch keyword
        switch (c) {
            case BMW:
                System.out.println("You chose BMW !");
                break;
            case JEEP:
                System.out.println("You chose JEEP !");
                break;
            case AUDI:
                System.out.println("You chose AUDI !");
                break;
            case VOLKSWAGON:
                System.out.println("You chose VOLKSWAGON !");
                break;
            case NANO:
                System.out.println("You chose NANO !");
                break;
            case CHEVY:
                System.out.println("You chose CHEVY !");
                break;
            case FIAT:
                System.out.println("You chose FIAT !");
                break;
            default:
                System.out.println("Unrecognized car selection.");
                break;
        }
    }
}
