package com.filmstudio;

import model.enums.FilmGenre;

public class Cameraman extends Worker {
    private int camerasAmount;

    public Cameraman(final int pCamerasAmount, final String occupationName, final String firstName,
                     final String lastName, final int age, final int salaryPerHour,
                     final FilmGenre genre, final int yearExperience) {
        super(occupationName, firstName, lastName, age, salaryPerHour,
                genre, yearExperience);
        this.camerasAmount = pCamerasAmount;
    }


    public Cameraman() {
    }

    public final int getCamerasAmount() {
        return camerasAmount;
    }

    public final void setCamerasAmount(final int pCamerasAmount) {
        this.camerasAmount = pCamerasAmount;
    }


}
