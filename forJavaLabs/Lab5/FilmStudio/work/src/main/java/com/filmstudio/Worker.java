package com.filmstudio;

import com.enums.FilmGenre;

import javax.persistence.*;

@Entity

public class Worker {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column (name= "id")
    private Integer id;

    @Column(name = "occupation_name")

    private String occupationName ;
    @Column(name = "first_name")

    private String firstName ;
    @Column(name = "last_name")

    private String lastName ;
    @Column(name = "age")
    private int age;

    @Column(name = "salary_per_hour")
    private int salaryPerHour ;

    @Column(name = "genre")
    private FilmGenre genre;

    @Column(name = "year_experience")
    private int yearExperience ;
    public Worker( final Integer id, final String occupationName, final  String firstName,
                final    String lastName, final int age, final int salaryPerHour,
                final    FilmGenre genre, final int yearExperience) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.salaryPerHour = salaryPerHour;
        this.genre = genre;
        this.yearExperience = yearExperience;
        this.occupationName = occupationName;
        this.id = id;
    } public Worker() {
    }
    public String getHeaders() {
        return "occupationName, firstName, lastName, age, salaryPerHour, genre, yearExperience";
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public  String getOccupationName() {
        return occupationName;
    }


    public  void setOccupationName( String occupationName) {

        this.occupationName = occupationName;
    }


    public  FilmGenre getGenre() {
        return genre;
    }




    public Worker(int id) {
        this.id= id;
    }





    public String toCSV() {
        return getFirstName() + ", " + getLastName() + ", " + getAge() + ", " + getGenre() + ", " + getSalaryPerHour()
                + ", " + getYearExperience();
    }

    public final String getFirstName() {
        return firstName;
    }


    public  void setFirstName( String firstName) {
        this.firstName = firstName;
    }


    public final String getLastName() {
        return lastName;
    }


    public  void setLastName( String lastName) {
        this.lastName = lastName;
    }


    public final int getAge() {
        return age;
    }


    public  void setAge( int age) {

        this.age = age;
    }


    public  int getSalaryPerHour() {

        return salaryPerHour;
    }


    public  void setSalaryPerHour( int salaryPerHour) {

        this.salaryPerHour = salaryPerHour;
    }


    private int getYearExperience() {
        return yearExperience;
    }


    public  void setYearExperience( int yearExperience) {


        this.yearExperience = yearExperience;
    }

    @Override
    public  String toString() {
        return "Worker [occupation = " + occupationName + ", first Name = "
                + firstName + ", last Name = " + lastName + ",age = "
                + age + ", salary per hour = " + salaryPerHour
                + ",film genre can play = " + genre + ", year Experience = "
                + yearExperience + "]" + "\n";
    }
}
