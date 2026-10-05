package com.josealrocmun.musicinheritanceapp;

/**
 * Pop genre. Popularity metric = awards count.
 *
 * @author José Alberto Rocha Munguía
 */
public class Pop extends Music {

    public Pop(String name, int beat, int awards) {
        super(name, beat, awards);
    }

    public Pop(String name, int awards) {
        super(name, awards);
    }

    @Override
    public int getPopularity() {
        String name = getName();
        int awards = getAwards();

        if (awards == 1) {
            System.out.println(name + ": Popular in its home country but still growing abroad.");
        } else if (awards == 2) {
            System.out.println(name + ": Highly popular locally, with moderate international presence.");
        } else {
            System.out.println(name + ": Global sensation! Famous both locally and internationally.");
        }

        return awards;
    }

    public void printPopLevel() {
        String name = getName();
        int awards = getAwards();

        if (awards == 1) {
            System.out.println(name + ": You are a Rising Pop star.");
        } else if (awards == 2) {
            System.out.println(name + ": You are a Mainstream Pop icon.");
        } else {
            System.out.println(name + ": Wow! You are a Pop Legend.");
        }
    }
}
