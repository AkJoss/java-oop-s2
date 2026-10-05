package com.josealrocmun.musicinheritanceapp;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;

/**
 * Inheritance + polymorphism demo with music genres (OOP coursework).
 *
 * Runs three demos with no user input:
 *   1) Direct subclass calls ({@link Kpop}, {@link Pop}, {@link Rock}, {@link Jpop})
 *   2) Polymorphic {@link Music} references
 *   3) Playlist average popularity via streams
 *
 * Also in this package (not used by {@code main}): {@link Person}, {@link Athlete},
 * {@link Engineer} — extra inheritance examples from the same coursework set.
 *
 * @author José Alberto Rocha Munguía
 */
public class MusicInheritanceApp {

    public static void main(String[] args) {
        System.out.println("========================================");
        System.out.println("           BASIC LEVEL (Direct)         ");
        System.out.println("========================================");

        Kpop kpop = new Kpop("ITZY WANNABE", 3, 2);
        Pop pop = new Pop("New Jeans OMG", 7, 3);
        Rock rock = new Rock("DAY6 Sweet Chaos", 6, 1);
        Jpop jpop = new Jpop("Nishimura NightDancer", 7, 3);

        System.out.println("Popularity Level: " + kpop.getPopularity());
        System.out.println("Popularity Level: " + pop.getPopularity());
        System.out.println("Popularity Level: " + rock.getPopularity());
        System.out.println("Popularity Level: " + jpop.getPopularity());

        kpop.printDevelopment();
        pop.printPopLevel();
        rock.printRockLevel();
        jpop.printJpopLevel();

        System.out.println("\n========================================");
        System.out.println("        ADVANCED LEVEL (Polymorphism)   ");
        System.out.println("========================================");

        Music song1 = new Kpop("ITZY 2nd", 3, 2);
        Music song2 = new Pop("NewJeans 2nd", 7, 3);
        Music song3 = new Rock("DAY6 2nd", 6, 1);
        Music song4 = new Jpop("Nishimura 2nd", 7, 3);

        System.out.println("Song 1 Popularity: " + song1.getPopularity());
        System.out.println("Song 2 Popularity: " + song2.getPopularity());
        // song3 / song4 created to show polymorphic typing; printed levels above cover the pattern

        System.out.println("\n========================================");
        System.out.println("        SENIOR LEVEL (Multi-Fandom)     ");
        System.out.println("========================================");

        List<Music> playlist = Arrays.asList(
                new Kpop("TXT", 1),
                new Pop("Stray Kids", 2),
                new Rock("XH", 3),
                new Jpop("And T", 1)
        );

        OptionalDouble average = calculateAveragePopularity(playlist);

        if (average.isPresent()) {
            System.out.printf("The average popularity level of the playlist is: %.2f\n", average.getAsDouble());
        }

        System.out.println("========================================");
    }

    /** Average of {@link Music#getPopularity()} across a polymorphic list. */
    public static OptionalDouble calculateAveragePopularity(List<Music> list) {
        return list.stream()
                .mapToDouble(Music::getPopularity)
                .average();
    }
}
