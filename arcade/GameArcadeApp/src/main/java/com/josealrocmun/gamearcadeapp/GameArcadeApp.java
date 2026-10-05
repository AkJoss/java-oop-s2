package com.josealrocmun.gamearcadeapp;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Arcade console app: pick a minigame, register a customer, print a daily report.
 *
 * OOP focus: abstract {@link Game} + subclasses (GuessTheNumber, FindTheEmoji, FlipACard).
 * The three minigames are still stubs (they only print "Starting...").
 *
 * Change ACTIVATIONS below to run fewer loops while testing.
 *   ACTIVATIONS = 1  → quick test
 *   ACTIVATIONS = 10 → original coursework length
 *
 * Quick test input (one activation):
 *   1
 *   Jose
 *   jose@mail.com
 *   5551234567
 *   01/01/2000
 *
 * @author José Alberto Rocha Munguía
 */
public class GameArcadeApp {

    // try: 1 for a short test, 10 for the full daily report
    private static final int ACTIVATIONS = 1;

    public static void main(String[] args) {
        ArrayList<GameMatch> history = new ArrayList<>();
        Scanner inputScanner = new Scanner(System.in);

        for (int i = 0; i < ACTIVATIONS; i++) {
            System.out.println("\n--- Activation " + (i + 1) + " ---");

            Game game = selectGame(inputScanner);
            game.play();

            System.out.println("\n[Customer Registration]");
            System.out.print("Name: ");
            String name = inputScanner.nextLine();

            System.out.print("Email: ");
            String email = inputScanner.nextLine();

            System.out.print("Phone: ");
            String phone = inputScanner.nextLine();

            System.out.print("Birth Date (DD/MM/YYYY): ");
            String birthDate = inputScanner.nextLine();

            history.add(new GameMatch(name, email, phone, birthDate, game.name, "Completed"));
        }

        System.out.println("\n=====================================");
        System.out.println("           DAILY SALES REPORT        ");
        System.out.println("=====================================");

        for (GameMatch match : history) {
            System.out.println("Customer: " + match.customerName);
            System.out.println("Email: " + match.customerEmail);
            System.out.println("Phone: " + match.customerPhone);
            System.out.println("Birth Date: " + match.birthDate);
            System.out.println("Game Played: " + match.gameType);
            System.out.println("Result: " + match.result);
            System.out.println("-------------------------------------");
        }
    }

    public static Game selectGame(Scanner scanner) {
        Game game = null;

        while (game == null) {
            System.out.println("\nChoose a game to play:");
            System.out.println("1. Guess the Number");
            System.out.println("2. Find the Emoji");
            System.out.println("3. Flip a Card");
            System.out.print("Selection: ");

            int option = scanner.nextInt();
            scanner.nextLine(); // consume leftover newline before customer fields

            switch (option) {
                case 1 -> {
                    game = new GuessTheNumber();
                    game.name = "Guess the Number";
                }
                case 2 -> {
                    game = new FindTheEmoji();
                    game.name = "Find the Emoji";
                }
                case 3 -> {
                    game = new FlipACard();
                    game.name = "Flip a Card";
                }
                default -> System.out.println("Invalid option, please try again.");
            }
        }
        return game;
    }
}
