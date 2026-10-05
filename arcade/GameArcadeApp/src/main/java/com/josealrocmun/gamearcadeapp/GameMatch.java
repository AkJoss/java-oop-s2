package com.josealrocmun.gamearcadeapp;

/**
 * One play session: customer data + which game they chose.
 * Stored in a list for the daily sales report.
 *
 * @author José Alberto Rocha Munguía
 */
class GameMatch {
    String customerName;
    String customerEmail;
    String customerPhone;
    String birthDate;
    String gameType;
    String result;

    public GameMatch(
            String customerName,
            String customerEmail,
            String customerPhone,
            String birthDate,
            String gameType,
            String result) {
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.customerPhone = customerPhone;
        this.birthDate = birthDate;
        this.gameType = gameType;
        this.result = result;
    }
}
