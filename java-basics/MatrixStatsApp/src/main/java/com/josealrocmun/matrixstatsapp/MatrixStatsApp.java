/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.josealrocmun.matrixstatsapp;
import java.util.Random;
import java.util.Scanner;

/**
 * * @author José Alberto Rocha Munguía
 */
public class MatrixStatsApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int rows, columns;

        // Ensure the matrix is square
        do {
            System.out.print("Enter the number of rows: ");
            rows = scanner.nextInt();
            System.out.print("Enter the number of columns: ");
            columns = scanner.nextInt();

            if (rows != columns) {
                System.out.println("Error: Please enter equal values for rows and columns (Square Matrix).");
            }

        } while (rows != columns);

        int[][] matrix = new int[rows][columns];

        // Fill the matrix with random numbers between 1 and 100
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = random.nextInt(100) + 1;
            }
        }

        // Print the matrix
        System.out.println("\nGenerated Matrix:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }

        // Row Statistics (Even/Odd count)
        System.out.println("---------------------");
        for (int i = 0; i < rows; i++) {
            int evenCount = 0;
            int oddCount = 0;

            for (int j = 0; j < columns; j++) {
                if (matrix[i][j] % 2 == 0) {
                    evenCount++;
                } else {
                    oddCount++;
                }
            }

            System.out.println("Row " + (i + 1) + " -> Even: " + evenCount + ", Odd: " + oddCount);
        }

        // Column Statistics (Even/Odd count)
        System.out.println("---------------------");
        for (int j = 0; j < columns; j++) {
            int evenCount = 0;
            int oddCount = 0;

            for (int i = 0; i < rows; i++) {
                if (matrix[i][j] % 2 == 0) {
                    evenCount++;
                } else {
                    oddCount++;
                }
            }

            System.out.println("Column " + (j + 1) + " -> Even: " + evenCount + ", Odd: " + oddCount);
        }

        // Calculate Total Sum
        int totalSum = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                totalSum += matrix[i][j];
            }
        }

        System.out.println("---------------------");
        System.out.println("The total sum of all values in the matrix is: " + totalSum);

        scanner.close();
    }
}
