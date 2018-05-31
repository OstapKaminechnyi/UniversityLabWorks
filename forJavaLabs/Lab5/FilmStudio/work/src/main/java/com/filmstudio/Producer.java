package com.filmstudio;

import com.enums.FilmGenre;

public class Producer extends Worker {

    public Producer(final Integer id, final double pMoneyAmount, final String occupationName, final String firstName,
                    final String lastName, final int age, final int salaryPerHour,
                    final FilmGenre genre, final int yearExperience) {
        super(id, occupationName, firstName, lastName, age, salaryPerHour, genre, yearExperience);
        this.moneyAmount = pMoneyAmount;

    }

    public final String getHeaders() {
        return super.getHeaders() + ",moneyAmount";
    }
    public final String toCSV() {
        return super.toCSV() + ", " + getMoneyAmount ();}
    private double moneyAmount;

    public Producer(double v, String producer, String lauren, String greenfield, int i, int i1, FilmGenre documentaryfilms, int i2) {
    }

    public final double getMoneyAmount() {
        return moneyAmount;
    }

    public final void setMoneyAmount(final double pMoneyAmount) {
        this.moneyAmount = pMoneyAmount;
    }

}
