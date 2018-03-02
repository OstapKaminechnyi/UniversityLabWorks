package com.filmstudio;

import model.enums.FilmGenre;

public final class Actor extends Worker {
    private String characterFirstName;
    private String characterLastName;

    Actor(final String pCharacterFirstName, final String pCharacterLastName,
          final String occupationName, final String firstName,
          final String lastName, final int age, final int salaryPerHour,
          final FilmGenre genre, final int yearExperience) {
        super(occupationName, firstName, lastName, age, salaryPerHour,
                genre, yearExperience);
        this.characterFirstName = pCharacterFirstName;
        this.characterLastName = pCharacterLastName;
    }

    public Actor() {

    }

    public final String getCharacterFirstName() {
        return characterFirstName;
    }

    public final void setCharacterFirstName(final String pCharacterFirstName) {
        this.characterFirstName = pCharacterFirstName;
    }

    public final String getCharacterLastName() {
        return characterLastName;
    }

    public final void setCharacterLastName(final String pCharacterLastName) {
        this.characterLastName = pCharacterLastName;
    }


}
