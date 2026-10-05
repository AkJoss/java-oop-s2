package com.josealrocmun.pharmacyinventoryapp;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 * One medication entry: names, public price, form, and computed sales price.
 *
 * Sales markup by pharmaceutical form:
 *   solid → +9%, semi-solid → +12%, liquid → +13%
 *
 * @author José Alberto Rocha Munguía
 */
class Medication {
    private String chemicalName;
    private String genericName;
    private String registeredName;
    private double publicPrice;
    private double salesPrice;
    private String pharmaceuticalForm;

    public Medication(String chemicalName, String genericName, String registeredName,
                      double publicPrice, String pharmaceuticalForm) {
        this.chemicalName = chemicalName;
        this.genericName = genericName;
        this.registeredName = registeredName;
        this.publicPrice = publicPrice;
        this.pharmaceuticalForm = pharmaceuticalForm.toLowerCase();
        calculateSalesPrice();
    }

    private void calculateSalesPrice() {
        salesPrice = switch (pharmaceuticalForm) {
            case "solid" -> publicPrice * 1.09;
            case "semi-solid" -> publicPrice * 1.12;
            case "liquid" -> publicPrice * 1.13;
            default -> publicPrice;
        };
    }

    public String getChemicalName() {
        return chemicalName;
    }

    public String getGenericName() {
        return genericName;
    }

    public String getRegisteredName() {
        return registeredName;
    }

    public double getPublicPrice() {
        return publicPrice;
    }

    public double getSalesPrice() {
        return salesPrice;
    }

    public String getPharmaceuticalForm() {
        return pharmaceuticalForm;
    }
}

/**
 * Console pharmacy inventory demo (OOP coursework).
 *
 * Flow:
 *   1) Login with demo credentials
 *   2) Register one or more medications
 *   3) Print inventory report with sales prices
 *
 * Demo login (coursework only — not a real account):
 *   username: josea
 *   password: ramb3rt0
 *
 * Quick test after login:
 *   Paracetamol / Acetaminophen / Tylenol / 100 / solid / no
 *   Expected sales price: $109.00
 *
 * @author José Alberto Rocha Munguía
 */
public class PharmacyInventoryApp {
    private static final String USERNAME = "josea";
    private static final String PASSWORD = "ramb3rt0";
    private static ArrayList<Medication> medicationList = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        authenticateUser();
        registerMedications();
        generateReport();
    }

    private static void authenticateUser() {
        System.out.println("--- Medication Registry System Login ---");
        String inputUser;
        String inputPass;

        do {
            System.out.print("Username: ");
            inputUser = scanner.nextLine();
            System.out.print("Password: ");
            inputPass = scanner.nextLine();

            if (!inputUser.equals(USERNAME) || !inputPass.equals(PASSWORD)) {
                System.out.println("Invalid credentials. Please try again.");
            }
        } while (!inputUser.equals(USERNAME) || !inputPass.equals(PASSWORD));

        System.out.println("Login successful!\n");
    }

    private static void registerMedications() {
        String option;
        do {
            System.out.println("Enter medication details:");
            System.out.print("Chemical Name: ");
            String chemical = scanner.nextLine();

            System.out.print("Generic Name: ");
            String generic = scanner.nextLine();

            System.out.print("Registered Name (Brand): ");
            String brand = scanner.nextLine();

            System.out.print("Public Price: ");
            double price = scanner.nextDouble();
            scanner.nextLine(); // consume leftover newline after the number

            System.out.print("Pharmaceutical Form (solid/semi-solid/liquid): ");
            String form = scanner.nextLine();

            medicationList.add(new Medication(chemical, generic, brand, price, form));

            System.out.print("Would you like to register another medication? (yes/no): ");
            option = scanner.nextLine();
        } while (!option.equalsIgnoreCase("no"));
    }

    private static void generateReport() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String generationDate = sdf.format(new Date());

        System.out.println("\n==========================================");
        System.out.println("        MEDICATION INVENTORY REPORT       ");
        System.out.println("==========================================");
        System.out.println("Report Date: " + generationDate);
        System.out.println("Total Products: " + medicationList.size());
        System.out.println("------------------------------------------");

        for (Medication med : medicationList) {
            System.out.println("Chemical Name: " + med.getChemicalName());
            System.out.println("Generic Name: " + med.getGenericName());
            System.out.println("Brand Name: " + med.getRegisteredName());
            System.out.printf("Public Price: $%.2f\n", med.getPublicPrice());
            System.out.printf("Final Sales Price: $%.2f\n", med.getSalesPrice());
            System.out.println("Form: " + med.getPharmaceuticalForm());
            System.out.println("------------------------------------------");
        }
        System.out.println("--- End of Report ---");
    }
}
