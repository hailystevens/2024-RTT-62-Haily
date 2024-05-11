package org.example.Module303.Homework.PA303_10_1_PolymorphismandInheritance;

public abstract class Monster {
    //instance variable
    private String name;

    //constructor
    public Monster(String name) {
        this.name = name;
    }

    //methods
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    //abstract Method?
    public abstract String attack(); //subclasses need to implement this method

//    public String attack() {
//        return "!^_&^$@+%$* I don't know how to attack!";
//    }
}

