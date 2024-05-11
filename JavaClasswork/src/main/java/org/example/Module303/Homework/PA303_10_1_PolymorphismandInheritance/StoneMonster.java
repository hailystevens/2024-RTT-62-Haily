package org.example.Module303.Homework.PA303_10_1_PolymorphismandInheritance;


public class StoneMonster extends Monster {
    public StoneMonster(String name) {
        super(name);
    }

    @Override
    public String attack() {
        return "Attack with stones!";
    }
}

