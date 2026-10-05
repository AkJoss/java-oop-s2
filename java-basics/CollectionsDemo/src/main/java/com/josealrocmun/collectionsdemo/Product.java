package com.josealrocmun.collectionsdemo;

/**
 * Simple grocery product (name + quantity). Comparable by name (case-insensitive).
 *
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
        Product otherProduct = (Product) object;
        String otherName = otherProduct.name.toLowerCase();
        String thisName = this.name.toLowerCase();
        return thisName.compareTo(otherName);
    }
}
