package com.filmstudio;

import model.enums.FilmGenre;

public class Producer extends Worker {

    public Producer(final double pMoneyAmount, final String occupationName, final String firstName,
                    final String lastName, final int age, final int salaryPerHour,
                    final FilmGenre genre, final int yearExperience) {
        super(occupationName, firstName, lastName, age, salaryPerHour, genre, yearExperience);
        this.moneyAmount = pMoneyAmount;

    }


    private double moneyAmount;

    public Producer() {
    }

    public final double getMoneyAmount() {
        return moneyAmount;
    }

    public final void setMoneyAmount(final double pMoneyAmount) {
        this.moneyAmount = pMoneyAmount;
    }

}
