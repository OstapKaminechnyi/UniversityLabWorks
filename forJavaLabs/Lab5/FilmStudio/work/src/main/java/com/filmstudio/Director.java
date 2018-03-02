package com.filmstudio;

import model.enums.FilmGenre;

public class Director extends Worker {
    private String scenario;

    Director(final String pScenario, final String occupationName, final String firstName,
             final String lastName, final int age, final int salaryPerHour,
             final FilmGenre genre, final int yearExperience) {
        super(occupationName, firstName, lastName, age, salaryPerHour, genre, yearExperience);
        this.scenario = pScenario;
    }


    public Director() {
    }

    public final String getScenario() {
        return scenario;
    }

    public final void setScenario(final String pScenario) {
        this.scenario = pScenario;
    }

}
