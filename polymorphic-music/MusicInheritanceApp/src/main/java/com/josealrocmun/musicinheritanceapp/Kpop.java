package com.josealrocmun.musicinheritanceapp;

/**
 * K-pop genre. {@link #getPopularity()} prints a message from awards and returns awards.
 *
 * @author José Alberto Rocha Munguía
 */
public class Kpop extends Music {

    public Kpop(String name, int beat, int awards) {
        super(name, beat, awards);
    }

    public Kpop(String name, int awards) {
        super(name, awards);
    }

    @Override
    public int getPopularity() {
        String name = getName();
        int awards = getAwards();

        if (awards == 1) {
            System.out.println(name + ": This group is popular in Korea but not yet abroad.");
        } else if (awards == 2) {
            System.out.println(name + ": This group is popular in Korea, but has lower international reach.");
        } else {
            System.out.println(name + ": This group has low local popularity but is very famous internationally.");
        }

        // Coursework return: awards (not an internal score)
        return awards;
    }

    public void printDevelopment() {
        String name = getName();
        int awards = getAwards();

        if (awards == 1) {
            System.out.println(name + ": Keep going!");
        } else if (awards == 2) {
            System.out.println(name + ": You can keep winning more awards!");
        } else {
            System.out.println(name + ": Wow! You are a legendary group.");
        }
    }
}
