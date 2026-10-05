package com.josealrocmun.collectionsdemo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;

/**
 * Console demos of common Java collections (OOP coursework basics).
 *
 * Menu:
 *   1 HashSet
 *   2 LinkedHashSet
 *   3 ArrayList
 *   4 LinkedList
 *   5 HashMap
 *   6 LinkedHashMap
 *
 * Quick test (option 2 — order is stable):
 *   Input: 2
 *   Expect size 5, then Bread/Milk/Apples/Broccoli/Meat in that order.
 *
 * @author José Alberto Rocha Munguía
 */
public class CollectionsDemo {
    public static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        System.out.println("Select the desired Collection type: \n"
                + "1. HashSet\n"
                + "2. LinkedHashSet\n"
                + "3. ArrayList\n"
                + "4. LinkedList\n"
                + "5. HashMap\n"
                + "6. LinkedHashMap");

        int selection = Integer.parseInt(input.readLine());

        switch (selection) {
            case 1 -> hashSetMethod();
            case 2 -> linkedHashSetMethod();
            case 3 -> arrayListMethod();
            case 4 -> linkedListMethod();
            case 5 -> hashMapMethod();
            case 6 -> linkedHashMapMethod();
            default -> System.out.print("Please insert a valid value from the list.");
        }
    }

    public static void hashSetMethod() {
        System.out.println("\n--- HashSet Example ---");
        Product p1 = new Product("Bread", 6);
        Product p2 = new Product("Milk", 2);
        Product p3 = new Product("Apples", 5);
        Product p4 = new Product("Broccoli", 2);
        Product p5 = new Product("Meat", 2);

        HashSet<Product> grocerySet = new HashSet<>();
        grocerySet.add(p1);
        grocerySet.add(p2);
        grocerySet.add(p3);
        grocerySet.add(p4);

        // Same object reference added multiple times — only one entry
        grocerySet.add(p5);
        grocerySet.add(p5);
        grocerySet.add(p5);

        // HashSet iteration order is not guaranteed
        System.out.println("Grocery list size: " + grocerySet.size() + " (Duplicates ignored)");

        for (Object x : grocerySet) {
            Product prod = (Product) x;
            System.out.println(prod.name + " : " + prod.quantity);
        }

        grocerySet.clear();
        System.out.println("Final list size after clear: " + grocerySet.size());
    }

    public static void linkedHashSetMethod() {
        System.out.println("\n--- LinkedHashSet Example ---");
        Product p1 = new Product("Bread", 6);
        Product p2 = new Product("Milk", 2);
        Product p3 = new Product("Apples", 5);
        Product p4 = new Product("Broccoli", 2);
        Product p5 = new Product("Meat", 2);

        LinkedHashSet<Product> grocerySet = new LinkedHashSet<>();
        grocerySet.add(p1);
        grocerySet.add(p2);
        grocerySet.add(p3);
        grocerySet.add(p4);
        grocerySet.add(p5);

        System.out.println("Grocery list size: " + grocerySet.size() + " (Insertion order preserved)");

        for (Object x : grocerySet) {
            Product prod = (Product) x;
            System.out.println(prod.name + " : " + prod.quantity);
        }
    }

    public static void arrayListMethod() {
        System.out.println("\n--- ArrayList Example ---");
        Product p1 = new Product("Bread", 6);
        Product p2 = new Product("Milk", 2);
        Product p3 = new Product("Apples", 5);
        Product p4 = new Product("Broccoli", 2);
        Product p5 = new Product("Meat", 2);

        ArrayList<Product> groceryList = new ArrayList<>();
        groceryList.add(p1);
        groceryList.add(p2);
        groceryList.add(p3);
        groceryList.add(p4);

        groceryList.add(0, p5); // insert Meat at index 0
        groceryList.add(p5);    // duplicate allowed → size 6

        System.out.println("Grocery list size: " + groceryList.size() + " (Duplicates allowed)");

        for (Object x : groceryList) {
            Product prod = (Product) x;
            System.out.println(prod.name + " : " + prod.quantity);
        }
    }

    public static void linkedListMethod() {
        System.out.println("\n--- LinkedList Example ---");
        Product p1 = new Product("Bread", 6);
        Product p2 = new Product("Milk", 2);
        Product p3 = new Product("Apples", 5);
        Product p4 = new Product("Broccoli", 2);
        Product p5 = new Product("Meat", 2);

        LinkedList<Product> groceryList = new LinkedList<>();
        groceryList.add(p1);
        groceryList.add(p2);
        groceryList.add(p3);
        groceryList.add(p4);

        groceryList.addFirst(p5);

        System.out.println("Grocery list size: " + groceryList.size());

        for (Object x : groceryList) {
            Product prod = (Product) x;
            System.out.println(prod.name + " : " + prod.quantity);
        }
    }

    public static void hashMapMethod() {
        System.out.println("\n--- HashMap Example ---");
        Product p1 = new Product("Bread", 6);
        Product p2 = new Product("Milk", 2);
        Product p3 = new Product("Apples", 5);
        Product p4 = new Product("Broccoli", 2);
        Product p5 = new Product("Meat", 2);

        HashMap<String, Product> groceryMap = new HashMap<>();
        groceryMap.put("B", p1);
        groceryMap.put("M", p2);
        groceryMap.put("A", p3);
        groceryMap.put("BR", p4);
        groceryMap.put("ME", p5);
        groceryMap.put("ME_ALT", p5); // same value, different key

        System.out.println("Grocery map size: " + groceryMap.size());

        for (Object x : groceryMap.values()) {
            Product prod = (Product) x;
            System.out.println(prod.name + " : " + prod.quantity);
        }
    }

    public static void linkedHashMapMethod() {
        System.out.println("\n--- LinkedHashMap Example ---");
        Product p1 = new Product("Bread", 6);
        Product p2 = new Product("Milk", 2);
        Product p3 = new Product("Apples", 5);
        Product p4 = new Product("Broccoli", 2);
        Product p5 = new Product("Meat", 2);

        LinkedHashMap<String, Product> groceryMap = new LinkedHashMap<>();
        groceryMap.put("B", p1);
        groceryMap.put("M", p2);
        groceryMap.put("A", p3);
        groceryMap.put("BR", p4);
        groceryMap.put("ME", p5);

        System.out.println("Grocery map size: " + groceryMap.size() + " (Insertion order preserved)");

        for (Object x : groceryMap.values()) {
            Product prod = (Product) x;
            System.out.println(prod.name + " : " + prod.quantity);
        }
    }
}
