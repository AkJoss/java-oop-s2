package com.josealrocmun.gradeaveragecalculator;

import java.util.Scanner;

/**
 * Console grade-average calculator (OOP coursework basics).
 *
 * Asks how many grades to capture, reads each one, prints the average.
 *
 * Quick test:
 *   3 → 10 → 8 → 9
 *   Expect: The average of the grades is: 9.0
 *
 * @author José Alberto Rocha Munguía
 */
public class GradeAverageCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of grades to capture: ");
        int gradeCount = scanner.nextInt();

        double totalSum = 0;
        for (int i = 1; i <= gradeCount; i++) {
            System.out.println("Enter grade " + i + ": ");
            double grade = scanner.nextDouble();
            totalSum += grade;
        }

        double average = totalSum / gradeCount;
        System.out.println("The average of the grades is: " + average);
        scanner.close();
    }
}
