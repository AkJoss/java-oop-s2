package com.josealrocmun.musicinheritanceapp;

/**
 * Abstract person. Base for {@link Engineer} and {@link Athlete}
 * (extra inheritance demo; not used by {@link MusicInheritanceApp#main}).
 *
 * @author José Alberto Rocha Munguía
 */
public abstract class Person {

    private String name;
    private int age;
    private int level;

    public Person(String name, int age, int level) {
        this.name = name;
        this.age = age;
        this.level = level;
    }

    /** Overloaded constructor when age is not needed. */
    public Person(String name, int level) {
        this.name = name;
        this.level = level;
    }

    public abstract int runningLevel();

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getLevel() {
        return level;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
