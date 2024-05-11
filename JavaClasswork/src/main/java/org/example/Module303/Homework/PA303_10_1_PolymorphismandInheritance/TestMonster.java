package org.example.Module303.Homework.PA303_10_1_PolymorphismandInheritance;


public class TestMonster {
    public static void main(String[] args) {
        // Program at the "interface" defined in the superclass.
        // Declare instances of the superclass, substituted by subclasses.
        Monster m1 = new FireMonster("r2u2"); //upcast?
        Monster m2 = new WaterMonster("u2r2"); //upcast?
        Monster m3 = new StoneMonster("r2r2"); //upcast?

        // Invoke the actual implementation
        System.out.println(m1.attack()); //Attack with fire!
        System.out.println(m2.attack()); //Attack with water!
        System.out.println(m3.attack()); //Attack with stones!

        //m1 dies, generate new instance and reassign to m1
        m1 = new StoneMonster("a2b2");
        System.out.println(m1.attack());

        //We have a problem!
        //Monster m4 = new Monster("u2u2"); //Cannot make a Monster object because the Monster class is abstract
        //System.out.println(m4.attack()); //!^_&^$@+%$* I don't know how to attack!

        System.out.println("Cannot make a Monster object because the Monster class is abstract");
    }
}
