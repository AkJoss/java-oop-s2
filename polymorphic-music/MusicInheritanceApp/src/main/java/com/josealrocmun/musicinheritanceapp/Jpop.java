package com.josealrocmun.musicinheritanceapp;

/**
 * J-pop genre. Popularity metric = awards count.
 *
 * @author José Alberto Rocha Munguía
 */
public class Jpop extends Music {

    public Jpop(String name, int beat, int awards) {
        super(name, beat, awards);
    }

    public Jpop(String name, int awards) {
        super(name, awards);
    }

    @Override
    public int getPopularity() {
        String name = getName();
        int awards = getAwards();

        if (awards == 1) {
            System.out.println(name + ": Huge in Japan, but still niche in the international market.");
        } else if (awards == 2) {
            System.out.println(name + ": An established name in Japan with a growing global fanbase.");
        } else {
            System.out.println(name + ": Chart-topper! This artist has massive global popularity.");
        }

        return awards;
    }

    public void printJpopLevel() {
        String name = getName();
        int awards = getAwards();

        if (awards == 1) {
            System.out.println(name + ": You are a Local Idol.");
        } else if (awards == 2) {
            System.out.println(name + ": You are a J-pop Sensation.");
        } else {
            System.out.println(name + ": Wow! You are a Global Artist.");
        }
    }
}
