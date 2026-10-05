/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

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
 * Examples of Java Collections:
 * 4.1 Sets (HashSet, LinkedHashSet)
 * 4.2 Lists (ArrayList, LinkedList)
 * 4.3 Maps (HashMap, LinkedHashMap)
 * * @author José Alberto Rocha Munguía
 */
public class CollectionsDemo {
    public static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        System.out.println("Select the desired Collection type: \n" +
                "1. HashSet\n" +
                "2. LinkedHashSet\n" +
                "3. ArrayList\n" +
                "4. LinkedList\n" +
                "5. HashMap\n" +
                "6. LinkedHashMap");

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
        // Instances of the Product class
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

        // Sets do not allow duplicate elements
        grocerySet.add(p5);
        grocerySet.add(p5);
        grocerySet.add(p5);

        // Note: HashSet order is unpredictable
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

        // LinkedHashSet maintains insertion order
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

        // Lists allow duplicates and index manipulation
        groceryList.add(0, p5); // Insert at the beginning
        groceryList.add(p5);    // Duplicate allowed

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
        
        groceryList.addFirst(p5); // LinkedList specific: efficient at head/tail
        
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
        
        // Maps use Key-Value pairs. Keys must be unique.
        groceryMap.put("ME", p5);
        groceryMap.put("ME_ALT", p5); // Same value, different key is OK

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

        // Respects insertion order
        System.out.println("Grocery map size: " + groceryMap.size() + " (Insertion order preserved)");

        for (Object x : groceryMap.values()) {
            Product prod = (Product) x;
            System.out.println(prod.name + " : " + prod.quantity);
        }
    }
}
