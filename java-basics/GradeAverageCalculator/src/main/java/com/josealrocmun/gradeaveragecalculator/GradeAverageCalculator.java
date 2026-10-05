/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.josealrocmun.gradeaveragecalculator;

/**
 *
 * @author José Alberto Rocha Munguía
 */
import java.util.Scanner;

public class GradeAverageCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Enter the grades
        System.out.println("Enter the number of grades to capture: ");
        int gradeCount = scanner.nextInt();
        // Sum them up
        double totalSum = 0;
        // Save them
        for (int i = 1; i <= gradeCount; i++) {
            System.out.println("Enter grade " + i + ": ");
            double grade = scanner.nextDouble();
            totalSum += grade;
        }
        // Calculate the average
        double average = totalSum / gradeCount;
        // Result
        System.out.println("The average of the grades is: " + average);
        scanner.close();
    }
}