package com.josealrocmun.musicinheritanceapp;

/**
 * Engineer subclass of {@link Person}. Level: 1 junior, 2 senior, 3 leader.
 *
 * @author José Alberto Rocha Munguía
 */
public class Engineer extends Person {

    public Engineer(String name, int age, int level) {
        super(name, age, level);
    }

    public Engineer(String name, int level) {
        super(name, level);
    }

    @Override
    public int runningLevel() {
        String name = getName();
        int level = getLevel();
        int currentRunningLevel;

        if (level == 1) {
            currentRunningLevel = 7;
            System.out.println(name + ": You are young and in good physical condition.");
        } else if (level == 2) {
            currentRunningLevel = 3;
            System.out.println(name + ": You are a Senior now, but please don't neglect your physical condition.");
        } else {
            currentRunningLevel = 1;
            System.out.println(name + ": You are a Leader, but you need to focus more on your physical condition.");
        }
        return currentRunningLevel;
    }

    public void printDevelopment() {
        String name = getName();
        int level = getLevel();

        if (level == 1) {
            System.out.println(name + ": You are a Junior Developer.");
        } else if (level == 2) {
            System.out.println(name + ": You are a Senior Developer.");
        } else {
            System.out.println(name + ": Wow! You are a semi-god.");
        }
    }
}
