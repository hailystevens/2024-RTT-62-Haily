package org.example.Module303.Homework.PA303_10_3_PolymorphismandInterface;

public class AdultUser implements Library {
    private int age;
    private String bookType;

    @Override
    public void registerAccount(int age) {
        this.setAge(age);
        if (this.getAge() >= 12) {
            System.out.println("You have successfully registered under an Adult Account.");
        } else if (this.getAge() <= 11) {
            System.out.println("Sorry, age must be greater than 12 to register as an adult.");
        }
    }

    @Override
    public void requestBook(String bookType) {
        this.setBookType(bookType);
        if (this.getBookType().equals("Fiction")) {
            System.out.println("Book Issued successfully, please return the book within 7 days.");
        } else {
            System.out.println("Oops, you are allowed to take only adult Fiction books.");
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
