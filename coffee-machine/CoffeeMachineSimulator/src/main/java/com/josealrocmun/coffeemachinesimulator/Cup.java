package com.josealrocmun.coffeemachinesimulator;

/**
 * One drink option: recipe (water/coffee/sugar) + price.
 * Edit the Cup(...) lines in {@link CoffeeMachineMain} to change the menu.
 *
 * @author José Alberto Rocha Munguía
 */
public class Cup {
    private String name;
    private int water;
    private int coffee;
    private int sugar;
    private double price;

    public Cup(String name, int water, int coffee, int sugar, double price) {
        this.name = name;
        this.water = water;
        this.coffee = coffee;
        this.sugar = sugar;
        this.price = price;
    }

    public Cup() {
    }

    public String getName() {
        return name;
    }

    public int getWater() {
        return water;
    }

    public int getCoffee() {
        return coffee;
    }

    public int getSugar() {
        return sugar;
    }

    public double getPrice() {
        return price;
    }
}
