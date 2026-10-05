package com.josealrocmun.hrmanagementapp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/**
 * Console HR / payroll demo (OOP coursework).
 *
 * Captures N employees (name, phone, birth date, regular hours, overtime hours,
 * job category), computes pay from category rates, then prints a payroll report
 * and summary statistics.
 *
 * Categories (hourly rates):
 *   1 Sales — regular $100, overtime $50
 *   2 Administrator — regular $180, overtime $100
 *   3 Manager — regular $250, overtime $150
 *
 * Quick test (stdin):
 *   1
 *   Ana Lopez
 *   5551234567
 *   15/03/1995
 *   40
 *   2
 *   1
 * Expected net pay: (40 * 100) + (2 * 50) = $4100.00
 *
 * @author José Alberto Rocha Munguía
 */
public class HumanResourcesMain {

    public static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int categoryOption;
        int employeesWithoutOvertime = 0;
        int employeesWithOvertime = 0;
        int totalOvertimeHours = 0;
        double totalOvertimePayment = 0;
        double totalRegularHoursPayment = 0;
        int totalRegularHoursWorked = 0;
        double totalPayroll = 0;

        String phoneNumber;
        double regularSalary = 0;
        double overtimeSalary = 0;
        int overtimeHoursWorked;
        int regularHoursWorked;
        LocalDate birthDate;
        int employeeCount;
        String employeeName;
        Category employeeCategory = null;

        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.println("Please indicate the number of employees to capture: ");
        employeeCount = Integer.parseInt(input.readLine());

        ArrayList<Employee> employees = new ArrayList<Employee>();
        ArrayList<Category> categories = new ArrayList<Category>();

        // Seed job categories used by the menu below
        Category salesData = new Category("Sales", 1, 100.00, 50.00);
        categories.add(salesData);

        Category adminData = new Category("Administrator", 2, 180.00, 100.00);
        categories.add(adminData);

        Category managerData = new Category("Manager", 3, 250.00, 150.00);
        categories.add(managerData);

        for (int i = 0; i < employeeCount; i++) {
            System.out.println("\n--- Data for Employee #" + (i + 1) + " ---");
            System.out.println("Enter name: ");
            employeeName = input.readLine();

            System.out.println("Enter phone number: ");
            phoneNumber = input.readLine();

            System.out.println("Enter birth date (dd/mm/yyyy): ");
            birthDate = LocalDate.parse(input.readLine(), fmt);

            System.out.println("Enter regular hours worked: ");
            regularHoursWorked = Integer.parseInt(input.readLine());

            System.out.println("Enter overtime hours worked: ");
            overtimeHoursWorked = Integer.parseInt(input.readLine());

            System.out.println("Select worker category: \n 1. Sales \n 2. Administrator \n 3. Manager");
            categoryOption = Integer.parseInt(input.readLine());

            // Pay totals for this employee = hours * category rate
            switch (categoryOption) {
                case 1 -> {
                    regularSalary = regularHoursWorked * salesData.getBaseSalary();
                    overtimeSalary = overtimeHoursWorked * salesData.getOvertimePay();
                    employeeCategory = salesData;
                }
                case 2 -> {
                    regularSalary = regularHoursWorked * adminData.getBaseSalary();
                    overtimeSalary = overtimeHoursWorked * adminData.getOvertimePay();
                    employeeCategory = adminData;
                }
                case 3 -> {
                    regularSalary = regularHoursWorked * managerData.getBaseSalary();
                    overtimeSalary = overtimeHoursWorked * managerData.getOvertimePay();
                    employeeCategory = managerData;
                }
            }

            Person personData = new Person(employeeName, phoneNumber, birthDate);

            Employee employee = new Employee();
            employee.person = personData;
            employee.category = employeeCategory;
            employee.setHoursWorked(regularHoursWorked);
            employee.setOvertimeHoursWorked(overtimeHoursWorked);
            // Note: these fields store pay totals for the period, not the hourly rate
            employee.setHourlyWage(regularSalary);
            employee.setOvertimeHourlyWage(overtimeSalary);

            employees.add(employee);
        }

        System.out.println("\n----- Payroll Report -----");
        System.out.println("Total Employees: " + employeeCount);

        for (int i = 0; i < employees.size(); i++) {
            Employee temp = employees.get(i);
            double netPay = temp.getHourlyWage() + temp.getOvertimeHourlyWage();

            System.out.println((i + 1) + ". " + temp.person.getPersonName()
                    + " | Base Salary: $" + temp.category.getBaseSalary()
                    + " | Reg. Hours: " + temp.getHoursWorked()
                    + " | OT Hours: " + temp.getOvertimeHoursWorked()
                    + " | Net Pay: $" + netPay);

            totalPayroll += netPay;
            totalRegularHoursPayment += temp.getHourlyWage();
            totalOvertimePayment += temp.getOvertimeHourlyWage();
            totalRegularHoursWorked += temp.getHoursWorked();
            totalOvertimeHours += temp.getOvertimeHoursWorked();

            if (temp.getOvertimeHoursWorked() == 0) {
                employeesWithoutOvertime++;
            } else {
                employeesWithOvertime++;
            }
        }

        System.out.println("\n--- Summary Statistics ---");
        System.out.printf("Total Payroll Payment: $%.2f\n", totalPayroll);
        System.out.printf("Total Regular Hours Payment: $%.2f\n", totalRegularHoursPayment);
        System.out.printf("Total Overtime Payment: $%.2f\n", totalOvertimePayment);
        System.out.println("Total Regular Hours Worked: " + totalRegularHoursWorked + " hours");
        System.out.println("Total Overtime Hours Worked: " + totalOvertimeHours + " hours");
        System.out.println("Employees with Overtime: " + employeesWithOvertime);
        System.out.println("Employees without Overtime: " + employeesWithoutOvertime);
        System.out.println("\n----- End of Program v1.1 -----");
    }
}
