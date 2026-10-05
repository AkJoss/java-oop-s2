package com.josealrocmun.gamearcadeapp;

import java.util.Scanner;

/**
 * Base type for arcade minigames (inheritance / polymorphism demo).
 * Subclasses must implement {@link #play()}.
 *
 * @author José Alberto Rocha Munguía
 */
abstract class Game {
    String name;
    String[] menuOptions = {"Guess the Number", "Find the Emoji", "Flip a Card"};
    Scanner scanner = new Scanner(System.in);

    abstract void play();

    void displayMenu() {
        System.out.println("Welcome! Please choose a game to play:");
        for (int i = 0; i < menuOptions.length; i++) {
            System.out.println((i + 1) + ". " + menuOptions[i]);
        }
    }
}
