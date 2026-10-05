package com.josealrocmun.dictionarysystem;

import java.util.Scanner;

/**
 * Console dictionary demo using parallel arrays (OOP coursework basics).
 *
 * Menu:
 *   A List all words
 *   B Search a word definition
 *   C Dictionary details (counts / lengths)
 *   S Exit
 *
 * Quick test:
 *   B → water → Meaning: colorless and odorless liquid substance
 *   A → list of 10 words
 *   C → Number of words: 10
 *   S → End of Program v1.1
 *
 * @author José Alberto Rocha Munguía
 */
public class DictionarySystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] words = {
                "water", "boot", "song", "disk", "effective",
                "party", "cat", "hour", "island", "swear"
        };
        String[] meanings = {
                "colorless and odorless liquid substance",
                "water-resistant footwear",
                "musical composition",
                "storage device",
                "efficient and capable",
                "festive celebration or gathering",
                "domestic animal",
                "unit of time",
                "portion of land surrounded by water",
                "to affirm with an oath"
        };

        char option;

        do {
            System.out.println("----- Dictionary -----");
            System.out.println("A. List all words in the dictionary");
            System.out.println("B. Search for a word definition");
            System.out.println("C. Dictionary details");
            System.out.println("S. Exit program");
            System.out.print("Choose an option: ");

            option = scanner.next().toUpperCase().charAt(0);

            switch (option) {
                case 'A' -> listWords(words);
                case 'B' -> searchWord(scanner, words, meanings);
                case 'C' -> dictionaryDetails(words, meanings);
                case 'S' -> { /* exit loop */ }
                default -> System.out.println("Invalid option. Please try again.");
            }

        } while (option != 'S');

        System.out.println("----- End of Program v1.1 -----");
        scanner.close();
    }

    private static void listWords(String[] words) {
        System.out.println("\nWords in dictionary:");
        for (int i = 0; i < words.length; i++) {
            System.out.println((i + 1) + ". " + words[i]);
        }
        System.out.println();
    }

    private static void searchWord(Scanner scanner, String[] words, String[] meanings) {
        System.out.print("\nEnter the word to see its meaning: ");
        // next() matches the menu scanner style (avoids leftover-newline issues)
        String searchedWord = scanner.next().toLowerCase();

        int index = -1;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equalsIgnoreCase(searchedWord)) {
                index = i;
                break;
            }
        }

        if (index != -1) {
            System.out.println("Meaning: " + meanings[index] + "\n");
        } else {
            System.out.println("The word does not exist in the dictionary.\n");
        }
    }

    private static void dictionaryDetails(String[] words, String[] meanings) {
        System.out.println("\nNumber of words in dictionary: " + words.length);
        System.out.println("Words with their character lengths:");
        for (int i = 0; i < words.length; i++) {
            System.out.println((i + 1) + ". " + words[i]
                    + " - Word Length: " + words[i].length()
                    + ", Meaning Length: " + meanings[i].length());
        }
        System.out.println();
    }
}
