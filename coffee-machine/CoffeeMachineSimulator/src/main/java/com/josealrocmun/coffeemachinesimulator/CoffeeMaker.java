package com.josealrocmun.coffeemachinesimulator;

/**
 * Inventory of water (ml), coffee (g) and sugar (g) inside the machine.
 * Change the constructor values in {@link CoffeeMachineMain} to start with different stock.
 *
 * @author José Alberto Rocha Munguía
 */
public class CoffeeMaker {
    private int waterCapacity;
    private int coffeeCapacity;
    private int sugarCapacity;

    public CoffeeMaker(int waterCapacity, int coffeeCapacity, int sugarCapacity) {
        this.waterCapacity = waterCapacity;
        this.coffeeCapacity = coffeeCapacity;
        this.sugarCapacity = sugarCapacity;
    }

    public CoffeeMaker() {
    }

    public int getWaterCapacity() {
        return waterCapacity;
    }

    public int getCoffeeCapacity() {
        return coffeeCapacity;
    }

    public int getSugarCapacity() {
        return sugarCapacity;
    }

    public void setWaterCapacity(int waterCapacity) {
        this.waterCapacity = waterCapacity;
    }

    public void setCoffeeCapacity(int coffeeCapacity) {
        this.coffeeCapacity = coffeeCapacity;
    }

    public void setSugarCapacity(int sugarCapacity) {
        this.sugarCapacity = sugarCapacity;
    }
}
