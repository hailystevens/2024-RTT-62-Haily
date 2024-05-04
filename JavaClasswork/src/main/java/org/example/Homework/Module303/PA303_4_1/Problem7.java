package org.example.Homework.Module303.PA303_4_1;

import java.util.Scanner;
//7. Create a program that lets the users input their filing status and income.
// Display how much tax the user would have to pay according to status and income.
//The U.S. federal personal income tax is calculated based on the filing status and taxable income.
//There are four filing statuses: Single, Married Filing Jointly, Married Filing Separately, and Head of Household.
//The tax rates for 2009 are shown below.
//https://docs.google.com/document/d/1TqZT1IbtSN7pbgNwZxYdeIPJ8rQMwarKbd-QGrqMVqk/edit

public class Problem7 {
    public static void main(String[] args) {
        double taxA = 0.10, taxB = 0.15, taxC = 0.25, taxD = 0.28, taxE = 0.33, taxF = 0.35;
        int incomeSB = 8351, incomeSC = 33951, incomeSD = 82251, incomeSE = 171551,
                incomeSF = 372951;
        int incomeMJB = 16701, incomeMJC = 67901, incomeMJD = 137051, incomeMJE = 208851,
                incomeMJF = 372951;
        int incomeMSB = 8351, incomeMSC = 33951, incomeMSD = 68526, incomeMSE = 104426,
                incomeMSF = 186476;
        int incomeHHB = 16701, incomeHHC = 67901, incomeHHD = 137051, incomeHHE = 208851,
                incomeHHF = 372951;

        double taxPayment = 0;
        Scanner input = new Scanner(System.in);
        System.out.println("Choose the filing status below: ");
        System.out.println("A. Single\nB. Married Filing Jointly");
        System.out.println("C. Married Filing Separately\nD. Head of the Household");
        char filingStatus = Character.toUpperCase(input.next().charAt(0));
        System.out.println("Enter your income: ");
        double income = input.nextDouble();
        input.close();
        switch (filingStatus) {
            case 'A':
                if (income < 0) {
                    System.out.println("Income must be greater than 0");
                } else {
                    if (income >= incomeSF) {
                        taxPayment = taxF * income;
                    } else if (income >= incomeSE) {
                        taxPayment = taxE * income;
                    } else if (income >= incomeSD) {
                        taxPayment = taxD * income;
                    } else if (income >= incomeSC) {
                        taxPayment = taxC * income;
                    } else if (income >= incomeSB) {
                        taxPayment = taxB * income;
                    } else {
                        taxPayment = taxA * income;
                    }
                    System.out.printf("Tax amount: %.2f", taxPayment);
                }
                break;
            case 'B':
                if (income < 0) {
                    System.out.println("Income must be greater than 0");
                } else {
                    if (income >= incomeMJF) {
                        taxPayment = taxF * income;
                    } else if (income >= incomeMJE) {
                        taxPayment = taxE * income;
                    } else if (income >= incomeMJD) {
                        taxPayment = taxD * income;
                    } else if (income >= incomeMJC) {
                        taxPayment = taxC * income;
                    } else if (income >= incomeMJB) {
                        taxPayment = taxB * income;
                    } else {
                        taxPayment = taxA * income;
                    }
                    System.out.printf("Tax amount: %.2f", taxPayment);
                }
                break;
            case 'C':
                if (income < 0) {
                    System.out.println("Income must be greater than 0");
                } else {
                    if (income >= incomeMSF) {
                        taxPayment = taxF * income;
                    } else if (income >= incomeMSE) {
                        taxPayment = taxE * income;
                    } else if (income >= incomeMSD) {
                        taxPayment = taxD * income;
                    } else if (income >= incomeMSC) {
                        taxPayment = taxC * income;
                    } else if (income >= incomeMSB) {
                        taxPayment = taxB * income;
                    } else {
                        taxPayment = taxA * income;
                    }
                    System.out.printf("Tax amount: %.2f", taxPayment);
                }
                break;
            case 'D':
                if (income < 0) {
                    System.out.println("Income must be greater than 0");
                } else {
                    if (income >= incomeHHF) {
                        taxPayment = taxF * income;
                    } else if (income >= incomeHHE) {
                        taxPayment = taxE * income;
                    } else if (income >= incomeHHD) {
                        taxPayment = taxD * income;
                    } else if (income >= incomeHHC) {
                        taxPayment = taxC * income;
                    } else if (income >= incomeHHB) {
                        taxPayment = taxB * income;
                    } else {
                        taxPayment = taxA * income;
                    }
                    System.out.printf("Tax amount: %.2f", taxPayment);
                }
                break;
            default:
                System.out.println("Invalid choice.");
        }
    }
}

//code was heavily influenced by google