package org.example.Module303.Classwork.SBA2Q2;


import java.text.DecimalFormat;
import java.util.ArrayList;

public class Cricket implements Sport{

    //an array starts with pos 0 - this is called 0 based

    private int[] playerIDs;

    public Cricket() {
        playerIDs = new int[12];
        for(int pos = 1; pos < playerIDs.length; pos++) {
            playerIDs[pos] = 1;
        }
        System.out.println("A new cricket team has been formed");

    }

    @Override
    public void calculateAvgAge(int[] age) {

        double sum = 0;
        for (int a : age) {
            sum = sum + a;
        }

        double avgAge = sum / age.length;
        DecimalFormat df = new DecimalFormat("0.00");
        System.out.println("The average age of the team is " + df.format(avgAge));

    }

    @Override
    public void retirePlayer(int id) {


        if (playerIDs[id] == -1) {
            System.out.println("Player has already retired");
        } else {
            playerIDs[id] = -1;
            System.out.println("Player with id: " + id + " has already retired");
        }



    }

    public static void main(String[] args) {

        Cricket c = new Cricket();

        int[] ages = {1, 4};
        c.calculateAvgAge(ages);

        c.retirePlayer(3);
        c.retirePlayer(3);

    }
}