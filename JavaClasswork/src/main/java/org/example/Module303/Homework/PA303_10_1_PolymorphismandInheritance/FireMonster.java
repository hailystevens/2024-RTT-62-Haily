package org.example.Module303.Homework.PA303_10_1_PolymorphismandInheritance;


public class FireMonster extends Monster {

    public FireMonster(String name) {
        super(name);
    }

    @Override
    public String attack() {
        return "Attack with fire!";
    }
}

