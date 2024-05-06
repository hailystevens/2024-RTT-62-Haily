package org.example.Module303.Homework.PA303_9_1_InheritanceAndOverloading;

import java.io.*;

public class JavaMethodOverriding2 {

    class BiCycle {
        String define_me() {
            return "a vehicle with pedals.";
        }
    }

    class MotorCycle extends BiCycle {
        String define_me() {
            return "a cycle with an engine.";
        }

        MotorCycle() {
            System.out.println("Hello I am a motorcycle, I am " + define_me());

            String temp = super.define_me();

            System.out.println("My ancestor is a cycle who is " + temp);
        }

    }

    class Solution {
        public static void main(String[] args) {
            JavaMethodOverriding2 M = new JavaMethodOverriding2();
        }
    }

}
