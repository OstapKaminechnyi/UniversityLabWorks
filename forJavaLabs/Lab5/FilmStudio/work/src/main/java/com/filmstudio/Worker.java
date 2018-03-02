package com.filmstudio;

import model.enums.FilmGenre;


public abstract class Worker {
    private String occupationName;
    private String firstName;
    private String lastName;
    private int age;
    private int salaryPerHour;
    private FilmGenre genre;
    private int yearExperience;

    public final String getOccupationName() {
        return occupationName;
    }


    public final void setOccupationName(final String pOccupationName) {
        this.occupationName = pOccupationName;
    }


    public final FilmGenre getGenre() {
        return genre;
    }


    public Worker() {
    }


    public Worker(final String pOccupationName, final String pFirstName,
                  final String pLastName, final int pAge, final int pSalaryPerHour,
                  final FilmGenre pGenre, final int pYearExperience) {
        this.firstName = pFirstName;
        this.lastName = pLastName;
        this.age = pAge;
        this.salaryPerHour = pSalaryPerHour;
        this.genre = pGenre;
        this.yearExperience = pYearExperience;
        this.occupationName = pOccupationName;
    }


    public final String getFirstName() {
        return firstName;
    }


    public final void setFirstName(final String pFirstName) {
        this.firstName = pFirstName;
    }


    public final String getLastName() {
        return lastName;
    }


    public final void setLastName(final String pLastName) {
        this.lastName = pLastName;
    }


    public final int getAge() {
        return age;
    }


    public final void setAge(final int pAge) {
        this.age = pAge;
    }


    public final int getSalaryPerHour() {
        return salaryPerHour;
    }


    public final void setSalaryPerHour(final int pSalaryPerHour) {
        this.salaryPerHour = pSalaryPerHour;
    }


    public final int getYearExperience() {
        return yearExperience;
    }


    public final void setYearExperience(final int pYearExperience) {
        this.yearExperience = pYearExperience;
    }

    @Override
    public final String toString() {
        return "Worker [occupation = " + occupationName + ", first Name = "
                + firstName + ", last Name = " + lastName + ",age = "
                + age + ", salary per hour = " + salaryPerHour
               + ",film genre can play = " + genre + ", year Experience = "
              +  yearExperience + "]" + "\n";
    }
}
