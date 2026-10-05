package com.josealrocmun.hrmanagementapp;

import java.time.LocalDate;

/**
 * Personal data for an employee (name, phone, birth date).
 *
 * @author José Alberto Rocha Munguía
 */
public class Person {

    private String personName;
    private String phoneNumber;
    private LocalDate birthDate;

    public Person(String name, String phone, LocalDate birthDate) {
        this.personName = name;
        this.phoneNumber = phone;
        this.birthDate = birthDate;
    }

    /** Alternate constructor when phone is not captured. */
    public Person(String name, LocalDate birthDate) {
        this.personName = name;
        this.birthDate = birthDate;
    }

    public String getPersonName() {
        return personName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }
}
