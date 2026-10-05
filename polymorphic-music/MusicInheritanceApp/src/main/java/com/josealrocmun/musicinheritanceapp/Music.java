package com.josealrocmun.musicinheritanceapp;

/**
 * Abstract music track / genre entry. Base for {@link Kpop}, {@link Pop},
 * {@link Rock}, and {@link Jpop}.
 *
 * @author José Alberto Rocha Munguía
 */
public abstract class Music {

    private String name;
    private int beat;
    private int awards;

    public Music(String name, int beat, int awards) {
        this.name = name;
        this.beat = beat;
        this.awards = awards;
    }

    /** Overloaded constructor when beat is not needed. */
    public Music(String name, int awards) {
        this.name = name;
        this.awards = awards;
    }

    /** Genre-specific popularity metric (usually based on awards). */
    public abstract int getPopularity();

    public String getName() {
        return name;
    }

    public int getBeat() {
        return beat;
    }

    public int getAwards() {
        return awards;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBeat(int beat) {
        this.beat = beat;
    }

    public void setAwards(int awards) {
        this.awards = awards;
    }
}
