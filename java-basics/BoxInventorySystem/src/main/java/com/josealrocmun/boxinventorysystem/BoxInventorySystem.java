package com.josealrocmun.boxinventorysystem;

import java.util.Scanner;

/**
 * Console box store demo (OOP coursework basics).
 *
 * Menu loop:
 *   1 Buy boxes at $5 each
 *   2 Sell boxes at $3 each
 *   3 Print report (operations, sales, purchases, cash)
 *   4 Exit
 *
 * Note: each loop asks for username/password but does not validate them
 * (original coursework behavior).
 *
 * Quick test:
 *   any / any → 1 → 2
 *   any / any → 2 → 4
 *   any / any → 3
 *   any / any → 4
 * Expected after buy 2 + sell 4: purchases $10, sales $12, cash balance $2
 *
 * @author José Alberto Rocha Munguía
 */
public class BoxInventorySystem {

    public static void main(String[] args) {
        Scanner sn = new Scanner(System.in);
        boolean exit = false;
        String username;
        String password;
        int option;
        int boxes;
        double price;

        int totalOperations = 0;
        int totalSales = 0;
        int totalPurchases = 0;
        double salesRevenue = 0;
        double purchaseExpenses = 0;
        double cashBalance = 0;

        do {
            System.out.println("Welcome to the Box Store");
            System.out.println("Username:");
            username = sn.next();
            System.out.println("Password:");
            password = sn.next();

            System.out.println("");
            System.out.println("1- Buy paper boxes");
            System.out.println("2- Sell paper boxes");
            System.out.println("3- Report");
            System.out.println("4- Exit");
            option = sn.nextInt();

            switch (option) {
                case 1 -> {
                    System.out.println("Buying paper boxes");
                    System.out.println("Quantity of boxes to buy:");
                    boxes = sn.nextInt();
                    System.out.println("The price per box is $5");
                    price = boxes * 5;
                    System.out.println("The purchase of #" + boxes + " boxes at $5 each is $" + price);
                    totalOperations++;
                    totalPurchases += boxes;
                    purchaseExpenses += price;
                    cashBalance -= price;
                }
                case 2 -> {
                    System.out.println("Selling paper boxes");
                    System.out.println("Quantity of boxes to sell:");
                    boxes = sn.nextInt();
                    System.out.println("The selling price per box is $3");
                    price = boxes * 3;
                    System.out.println("The sale of #" + boxes + " boxes at $3 each is $" + price);
                    totalOperations++;
                    totalSales += boxes;
                    salesRevenue += price;
                    cashBalance += price;
                }
                case 3 -> {
                    System.out.println("Report:");
                    System.out.println("Total operations performed: " + totalOperations);
                    System.out.println("Total quantity of sales: " + totalSales);
                    System.out.println("Total quantity of purchases: " + totalPurchases);
                    System.out.println("Revenue generated from sales: $" + salesRevenue);
                    System.out.println("Expenses generated from purchases: $" + purchaseExpenses);
                    System.out.println("Cash balance: $" + cashBalance);
                }
                case 4 -> {
                    System.out.println("Thank you for using the Box Store system");
                    exit = true;
                }
                default -> System.out.println("Invalid option. Please choose a valid option.");
            }
        } while (!exit);
    }
}
