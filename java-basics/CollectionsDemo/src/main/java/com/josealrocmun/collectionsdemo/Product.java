/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.josealrocmun.collectionsdemo;

/**
 * Class representing a product that can be compared by name.
 * @author José Alberto Rocha Munguía
 */
public class Product implements Comparable<Object> {

    public String name;
    public int quantity;

    public Product(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return ("Name: " + name + " | Quantity: " + quantity);
    }

    @Override
    public int compareTo(Object object) {
        // This method determines how products are sorted (alphabetically by name)
        // Returns:
        // +1 if 'this' name is greater than 'object' name
        // -1 if 'this' name is less than 'object' name
        //  0 if they are equal
        
        Product otherProduct = (Product) object;
        String otherName = otherProduct.name.toLowerCase();
        String thisName = this.name.toLowerCase();

        return (thisName.compareTo(otherName));
    }
}
