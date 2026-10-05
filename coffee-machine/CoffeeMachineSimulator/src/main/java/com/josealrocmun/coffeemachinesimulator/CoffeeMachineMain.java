package com.josealrocmun.coffeemachinesimulator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Console coffee-machine simulator (OOP coursework).
 *
 * Run from the Maven project folder (see README / agent instructions).
 *
 * Flow:
 *   1) How many cups do you want?
 *   2) For each cup: pick option 1–6 from the menu
 *   3) Pay with coins ($10, $5, $2, $1) until amount >= price
 *   4) Supplies go down; if empty you can refill coffee (max 2000 g)
 *   5) Final report: cups sold + total revenue
 *
 * Quick test: buy 1 cup → option 1 → pay 11 (change $0.50) → see report.
 *
 * @author José Alberto Rocha Munguía
 */
public class CoffeeMachineMain {
    public static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int option;
        double amountToPay;
        int extraCoffee;
        double paidAmount;
        int coffeeCupsCount;
        int suppliesOption;
        double totalRevenue = 0;

        ArrayList<Cup> cupTypes = new ArrayList<>();
        ArrayList<Cup> soldCups = new ArrayList<>();

        // Menu items: name, water ml, coffee g, sugar g, price
        Cup cup1 = new Cup("Small coffee cup without sugar (120 ml)", 120, 15, 0, 10.50);
        Cup cup2 = new Cup("Small coffee cup with sugar (120 ml)", 120, 15, 10, 14.50);
        Cup cup3 = new Cup("Medium coffee cup with sugar (220 ml)", 220, 20, 15, 24.50);
        Cup cup4 = new Cup("Medium coffee cup without sugar (220 ml)", 220, 20, 0, 34.50);
        Cup cup5 = new Cup("Large coffee cup with sugar (320 ml)", 320, 25, 20, 34.50);
        Cup cup6 = new Cup("Large coffee cup without sugar (320 ml)", 320, 25, 0, 39.50);

        cupTypes.add(cup1);
        cupTypes.add(cup2);
        cupTypes.add(cup3);
        cupTypes.add(cup4);
        cupTypes.add(cup5);
        cupTypes.add(cup6);

        // Starting stock: water ml, coffee g, sugar g
        CoffeeMaker capacities = new CoffeeMaker(3000, 2000, 2000);

        System.out.println("----- Welcome to the Coffee Machine! -----");
        System.out.print("How many cups of coffee do you wish to buy? ");
        coffeeCupsCount = Integer.parseInt(input.readLine());

        for (int i = 0; i < coffeeCupsCount; i++) {
            System.out.println("\n Please type the number of the desired option: \n 1. Small coffee cup without sugar (120 ml): $10.50\n 2. Small coffee cup with sugar (120 ml): $14.50 \n 3. Medium coffee cup with sugar (220 ml): $24.50 \n 4. Medium coffee cup without sugar (220 ml): $34.50 \n 5. Large coffee cup with sugar (320 ml): $34.50 \n 6. Large coffee cup without sugar (320 ml): $39.50 \n");
            option = Integer.parseInt(input.readLine());

            Cup selectedCup = null;
            switch (option) {
                case 1 -> selectedCup = cup1;
                case 2 -> selectedCup = cup2;
                case 3 -> selectedCup = cup3;
                case 4 -> selectedCup = cup4;
                case 5 -> selectedCup = cup5;
                case 6 -> selectedCup = cup6;
                default -> System.out.println("Invalid option.");
            }

            if (selectedCup != null) {
                System.out.println("Selected: " + selectedCup.getName());

                if ((capacities.getCoffeeCapacity() - selectedCup.getCoffee() >= 0) &&
                    (capacities.getWaterCapacity() - selectedCup.getWater() >= 0) &&
                    (capacities.getSugarCapacity() - selectedCup.getSugar() >= 0)) {

                    capacities.setCoffeeCapacity(capacities.getCoffeeCapacity() - selectedCup.getCoffee());
                    capacities.setWaterCapacity(capacities.getWaterCapacity() - selectedCup.getWater());
                    capacities.setSugarCapacity(capacities.getSugarCapacity() - selectedCup.getSugar());

                    paidAmount = 0;
                    amountToPay = selectedCup.getPrice();
                    System.out.println("The amount to pay is: $" + amountToPay);

                    do {
                        System.out.print("Insert coins ($10, $5, $2 and $1): ");
                        paidAmount += Float.parseFloat(input.readLine());
                    } while (paidAmount < amountToPay);

                    if (paidAmount == amountToPay) {
                        System.out.println("\nThank you for your purchase!\n");
                    } else {
                        System.out.println("Your change is: $" + (paidAmount - amountToPay));
                    }

                    soldCups.add(selectedCup);

                    System.out.println("Remaining Coffee: " + capacities.getCoffeeCapacity() + "g");
                    System.out.println("Remaining Sugar: " + capacities.getSugarCapacity() + "g");
                    System.out.println("Remaining Water: " + capacities.getWaterCapacity() + "ml");

                } else {
                    System.out.println("Sorry, out of supplies.");
                    System.out.println("Do you wish to add coffee? \n 1. Yes \n 2. No");
                    suppliesOption = Integer.parseInt(input.readLine());

                    if (suppliesOption == 1) {
                        System.out.print("Grams to add: ");
                        extraCoffee = Integer.parseInt(input.readLine());
                        if ((capacities.getCoffeeCapacity() + extraCoffee) <= 2000) {
                            capacities.setCoffeeCapacity(capacities.getCoffeeCapacity() + extraCoffee);
                            System.out.println("Update: Coffee capacity is now " + capacities.getCoffeeCapacity());
                        } else {
                            System.out.println("Error: Cannot exceed 2000g capacity.");
                        }
                    }
                }
            }
        }

        System.out.println("\n----- Information Report -----");
        System.out.println("Total cups sold: " + soldCups.size());
        System.out.println("Detailed breakdown: ");

        for (Cup temp : soldCups) {
            totalRevenue += temp.getPrice();
            System.out.println("\t- " + temp.getName());
        }
        System.out.println("The total sales revenue is: $" + totalRevenue);
    }
}
