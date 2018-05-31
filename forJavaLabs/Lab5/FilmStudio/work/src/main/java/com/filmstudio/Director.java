package com.filmstudio;

import com.enums.FilmGenre;

public class Director extends Worker {
    private String scenario;

    public Director(final Integer id, final String pScenario, final String occupationName, final String firstName,
                    final String lastName, final int age, final int salaryPerHour,
                    final FilmGenre genre, final int yearExperience) {
        super(id, occupationName, firstName, lastName, age, salaryPerHour, genre, yearExperience);
        this.scenario = pScenario;
    }


    public Director(String first_man, String director, String michael, String bay, int i, int i1, FilmGenre adventurefilms, int i2) {
    }

    public final String getHeaders() {
        return super.getHeaders() + ", scenario";
    }
    public final String toCSV() {
        return super.toCSV() + ", " + getScenario();}
    public final String getScenario() {
        return scenario;
    }

    public final void setScenario(final String pScenario) {
        this.scenario = pScenario;
    }

}
