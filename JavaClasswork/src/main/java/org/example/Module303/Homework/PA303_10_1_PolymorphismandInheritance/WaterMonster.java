package org.example.Module303.Homework.PA303_10_1_PolymorphismandInheritance;

public class WaterMonster extends Monster{
    public WaterMonster(String name) {
        super(name);
    }

    @Override
    public String attack() {
        return "Attack with water!";
    }
}
