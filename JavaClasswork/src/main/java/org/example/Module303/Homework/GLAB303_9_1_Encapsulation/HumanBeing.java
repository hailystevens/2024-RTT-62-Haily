package org.example.Module303.Homework.GLAB303_9_1_Encapsulation;

//Encapsulation refers to hiding the class variable from other classes and giving access to them
// only through methods (setters and getters).
//Encapsulation in Java means binding the data (variables) with the code (methods – setters and getters).

//Class Variables (in the example: height, weight, and bmi) are declared private; hence, they are
// not visible to other classes.
//For each variable, there is a setter and getter method, which sets a value to the variable
// and gets the variable's value, respectively.
//Example: For variable height, setter method is setHeight() and getter method is getHeight().
//Setter and Getter methods are public; hence, they are visible to other classes.

public class HumanBeing {

    private float weight;
    private float height;
    private float bmi;

    public HumanBeing(float weight, float height, float bmi) {
        this.weight = weight;
        this.height = height;
        this.bmi = bmi;
    }

    public HumanBeing() {

    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public float getBmi() {
        return bmi;
    }

    public void setBmi(float bmi) {
        this.bmi = bmi;
    }
}
