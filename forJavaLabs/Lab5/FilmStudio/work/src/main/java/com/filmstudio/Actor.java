package com.filmstudio;

import com.enums.FilmGenre;

public final class Actor extends Worker {
    private String characterFirstName;
    private String characterLastName;

    public Actor(final Integer id, final String pCharacterFirstName, final String pCharacterLastName,
                 final String occupationName, final String firstName,
                 final String lastName, final int age, final int salaryPerHour,
                 final FilmGenre genre, final int yearExperience) {
        super(id,occupationName, firstName, lastName, age, salaryPerHour,
                genre, yearExperience);
        this.characterFirstName = pCharacterFirstName;
        this.characterLastName = pCharacterLastName;
    }

    public Actor(String neil, String armstrong, String actor, String ryan, String gosling, int i, int i1, FilmGenre comedyfilms, int i2) {

    }

    public final String toCSV() {
        return super.toCSV() + ", " + getCharacterFirstName() + ", " + getCharacterLastName();
    }

    public final String getHeaders() {
        return super.getHeaders() + ",characterFirstName,characterLastName ";
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
