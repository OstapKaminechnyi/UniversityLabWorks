package com.filmstudio;

import com.enums.FilmGenre;

public class Cameraman extends Worker {
    private int camerasAmount;

    public Cameraman(final Integer id, final int pCamerasAmount, final String occupationName, final String firstName,
                     final String lastName, final int age, final int salaryPerHour,
                     final FilmGenre genre, final int yearExperience) {
        super(id, occupationName, firstName, lastName, age, salaryPerHour,
                genre, yearExperience);
        this.camerasAmount = pCamerasAmount;
    }


    public Cameraman(int i, String cameraman, String robert, String elswit, int i1, int i2, FilmGenre documentaryfilms, int i3) {
    }

    public final String getHeaders() {
        return super.getHeaders() + ",camerasAmount";
    }
    public final String toCSV() {
        return super.toCSV() + ", " + getCamerasAmount ();}
    public final int getCamerasAmount() {
        return camerasAmount;
    }

    public final void setCamerasAmount(final int pCamerasAmount) {
        this.camerasAmount = pCamerasAmount;
    }


}
