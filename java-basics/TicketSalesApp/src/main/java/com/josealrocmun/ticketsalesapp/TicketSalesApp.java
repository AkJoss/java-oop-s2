package com.josealrocmun.ticketsalesapp;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Console ticket sales demo (OOP coursework basics).
 *
 * Menu:
 *   A Process a ticket sale ($10 each; buyer + optional passengers)
 *   B Display passenger list and accumulated sales
 *   S Exit
 *
 * Quick test:
 *   A → Jose → 1 → Ana
 *   Expect ticket qty 2, sale total $20.0
 *   B → Jose, Ana; Total passengers 2; Total accumulated sales $20.0
 *   S → End of Program v1.1
 *
 * @author José Alberto Rocha Munguía
 */
public class TicketSalesApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TicketManager ticketManager = new TicketManager();

        while (true) {
            System.out.println("\n--- Sales Registration System ---");
            System.out.println("A. Process ticket sale");
            System.out.println("B. Display sales list data");
            System.out.println("S. Exit program");
            System.out.print("Choose an option: ");

            char option = scanner.next().toUpperCase().charAt(0);
            scanner.nextLine(); // consume rest of the menu line

            switch (option) {
                case 'A' -> ticketManager.processSale(scanner);
                case 'B' -> ticketManager.displaySalesData();
                case 'S' -> {
                    System.out.println("------- End of Program v1.1 -----------");
                    System.exit(0);
                }
                default -> System.out.println("Invalid option. Please try again.");
            }
        }
    }
}

/**
 * Tracks passengers and ticket totals for the session.
 *
 * @author José Alberto Rocha Munguía
 */
class TicketManager {
    private List<String> allPassengers = new ArrayList<>();
    private int totalTicketsSold = 0;
    private final double TICKET_PRICE = 10.0;

    public void processSale(Scanner scanner) {
        System.out.println("-----------------------------------------");
        System.out.print("Enter buyer's name: ");
        String buyerName = scanner.nextLine();

        System.out.print("Enter number of additional passengers: ");
        int additionalPassengersCount = scanner.nextInt();
        scanner.nextLine(); // consume leftover newline after the number

        allPassengers.add(buyerName);
        String[] currentAdditionalPassengers = new String[additionalPassengersCount];

        for (int i = 0; i < additionalPassengersCount; i++) {
            System.out.print("Enter name of additional passenger " + (i + 1) + ": ");
            currentAdditionalPassengers[i] = scanner.nextLine();
            allPassengers.add(currentAdditionalPassengers[i]);
        }

        int currentSaleTotal = additionalPassengersCount + 1;
        totalTicketsSold += currentSaleTotal;

        System.out.println("\n----------- Sales Ticket --------------");
        System.out.println("Tickets quantity: " + currentSaleTotal);
        System.out.println("Sale total amount: $" + (currentSaleTotal * TICKET_PRICE));
        System.out.println("Buyer name: " + buyerName);
        if (additionalPassengersCount > 0) {
            System.out.println("Additional passengers: " + String.join(", ", currentAdditionalPassengers));
        }
        System.out.println("-----------------------------------------");
    }

    public void displaySalesData() {
        System.out.println("\n----------- Passenger List ---------------");
        if (allPassengers.isEmpty()) {
            System.out.println("No sales recorded yet.");
        } else {
            for (int i = 0; i < allPassengers.size(); i++) {
                System.out.println((i + 1) + ". " + allPassengers.get(i));
            }
        }
        System.out.println("Total passengers registered: " + allPassengers.size());
        System.out.println("Total accumulated sales: $" + (totalTicketsSold * TICKET_PRICE));
        System.out.println("----------------------------------------------");
    }
}
