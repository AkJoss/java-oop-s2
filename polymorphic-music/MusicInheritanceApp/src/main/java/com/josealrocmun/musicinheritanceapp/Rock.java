package com.josealrocmun.musicinheritanceapp;

/**
 * Rock genre. Popularity metric = awards count.
 *
 * @author José Alberto Rocha Munguía
 */
public class Rock extends Music {

    public Rock(String name, int beat, int awards) {
        super(name, beat, awards);
    }

    public Rock(String name, int awards) {
        super(name, awards);
    }

    @Override
    public int getPopularity() {
        String name = getName();
        int awards = getAwards();

        if (awards == 1) {
            System.out.println(name + ": Cult classic. Strong local following but underground abroad.");
        } else if (awards == 2) {
            System.out.println(name + ": Chart-topping rock. Well known in the scene.");
        } else {
            System.out.println(name + ": Hall of Famer! Global rock legends.");
        }

        return awards;
    }

    public void printRockLevel() {
        String name = getName();
        int awards = getAwards();

        if (awards == 1) {
            System.out.println(name + ": You are a Garage Band / Indie Rocker.");
        } else if (awards == 2) {
            System.out.println(name + ": You are a Stadium Rocker.");
        } else {
            System.out.println(name + ": Wow! You are a Rock Star.");
        }
    }
}
