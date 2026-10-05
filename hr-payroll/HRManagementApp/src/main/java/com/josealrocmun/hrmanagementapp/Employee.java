package com.josealrocmun.hrmanagementapp;

/**
 * Employee links a {@link Person} and a job {@link Category} with hours worked
 * and pay amounts for the payroll period.
 *
 * {@code hourlyWage} / {@code overtimeHourlyWage} store the period totals
 * (hours × rate), not the category hourly rates themselves.
 *
 * @author José Alberto Rocha Munguía
 */
public class Employee {

    public Person person;
    public Category category;

    int hoursWorked;
    int overtimeHoursWorked;
    Double hourlyWage;
    Double overtimeHourlyWage;

    public Employee() {
    }

    public int getHoursWorked() {
        return hoursWorked;
    }

    public int getOvertimeHoursWorked() {
        return overtimeHoursWorked;
    }

    public double getHourlyWage() {
        return hourlyWage;
    }

    public double getOvertimeHourlyWage() {
        return overtimeHourlyWage;
    }

    public void setHoursWorked(int hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    public void setOvertimeHoursWorked(int overtimeHoursWorked) {
        this.overtimeHoursWorked = overtimeHoursWorked;
    }

    public void setHourlyWage(Double hourlyWage) {
        this.hourlyWage = hourlyWage;
    }

    public void setOvertimeHourlyWage(Double overtimeHourlyWage) {
        this.overtimeHourlyWage = overtimeHourlyWage;
    }
}
