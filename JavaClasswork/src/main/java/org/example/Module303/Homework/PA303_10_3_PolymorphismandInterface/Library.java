package org.example.Module303.Homework.PA303_10_3_PolymorphismandInterface;

public interface Library {
    //methods
    void registerAccount(int age);

    void requestBook(String bookType);

    int getAge();

    void setAge(int age);

    void setBookType(String bookType);

    Object getBookType();

}