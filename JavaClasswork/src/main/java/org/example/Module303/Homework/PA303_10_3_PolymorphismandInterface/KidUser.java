package org.example.Module303.Homework.PA303_10_3_PolymorphismandInterface;

public class KidUser implements Library {
    //instance variables
    private int age;
    private String bookType;

    @Override
    public void registerAccount(int age) {
        this.age = age;
        if (this.age <= 11) {
            System.out.println("You have successfully registered under a Kids Account");
        } else if (this.getAge() > 11) {
            System.out.println("Sorry, age must be less than 12 to register as a kid.");
        }
    }

    @Override
    public void requestBook(String bookType) {
        this.bookType = bookType;
        if (this.bookType.equals("Kids")) {
            System.out.println("Book issued successfully, please return the book within 10 days.");
        } else {
            System.out.println("Oops, you are allowed to take only kids books.");
        }
    }

    @Override
    public int getAge() {
        return 0;
    }

    @Override
    public void setAge(int age) {

    }

    @Override
    public void setBookType(String bookType) {

    }

    @Override
    public Object getBookType() {
        return null;
    }
}
