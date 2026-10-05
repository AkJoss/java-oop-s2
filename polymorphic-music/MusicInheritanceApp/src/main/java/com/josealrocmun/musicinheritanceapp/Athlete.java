package com.josealrocmun.musicinheritanceapp;

/**
 * Athlete subclass of {@link Person}. Level: 1 beginner, 2 intermediate, 3 expert.
 *
 * @author José Alberto Rocha Munguía
 */
public class Athlete extends Person {

    public Athlete(String name, int age, int level) {
        super(name, age, level);
    }

    public Athlete(String name, int level) {
        super(name, level);
    }

    @Override
    public int runningLevel() {
        String name = getName();
        int level = getLevel();
        int currentRunningLevel;

        if (level == 1) {
            currentRunningLevel = 3;
            System.out.println(name + ": You are young, but you need to develop your physical condition.");
        } else if (level == 2) {
            currentRunningLevel = 6;
            System.out.println(name + ": Keep improving your physical condition.");
        } else {
            currentRunningLevel = 9;
            System.out.println(name + ": Wow! You are an expert runner, you will surely win Olympic gold!");
        }
        return currentRunningLevel;
    }

    public void printSportsLevel() {
        String name = getName();
        int level = getLevel();

        if (level == 1) {
            System.out.println(name + ": You are an amateur athlete.");
        } else if (level == 2) {
            System.out.println(name + ": You are a national team member.");
        } else {
            System.out.println(name + ": Wow! You are an Olympic medalist.");
        }
    }
}
