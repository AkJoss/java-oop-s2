package com.josealrocmun.hrmanagementapp;

/**
 * Job category with key, name, regular hourly rate, and overtime hourly rate.
 *
 * @author José Alberto Rocha Munguía
 */
public class Category {

    String categoryName;
    int categoryKey;
    Double baseSalary;
    Double overtimePay;

    public Category(String categoryName, int categoryKey, Double baseSalary, Double overtimePay) {
        this.categoryName = categoryName;
        this.categoryKey = categoryKey;
        this.baseSalary = baseSalary;
        this.overtimePay = overtimePay;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public int getCategoryKey() {
        return categoryKey;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public double getOvertimePay() {
        return overtimePay;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public void setCategoryKey(int categoryKey) {
        this.categoryKey = categoryKey;
    }

    public void setBaseSalary(Double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public void setOvertimePay(Double overtimePay) {
        this.overtimePay = overtimePay;
    }
}
