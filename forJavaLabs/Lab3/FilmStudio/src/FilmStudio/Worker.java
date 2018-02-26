package FilmStudio;

import model.enums.FilmGenre;



public class Worker {
private String occupationName;
private String firstName;
private String lastName;
private int age;
private int salaryPerHour;
private FilmGenre genre;
private int yearExperience;

public String getOccupationName() {
	return occupationName;
}


public void setOccupationName(String occupationName) {
	this.occupationName = occupationName;
}


public FilmGenre getGenre() {
	return genre;
}


public Worker() {
}


public Worker(String occupationName, String firstName, String lastName, int age, int salaryPerHour,
		 FilmGenre genre, int yearExperience) {
	this.firstName = firstName;
	this.lastName = lastName;
	this.age = age;
	this.salaryPerHour = salaryPerHour;
	this.genre = genre;
	this.yearExperience = yearExperience;
	this.occupationName = occupationName;
}


public String getFirstName() {
	return firstName;
}


public void setFirstName(String firstName) {
	this.firstName = firstName;
}


public String getLastName() {
	return lastName;
}


public void setLastName(String lastName) {
	this.lastName = lastName;
}


public int getAge() {
	return age;
}


public void setAge(int age) {
	this.age = age;
}


public int getSalaryPerHour() {
	return salaryPerHour;
}


public void setSalaryPerHour(int salaryPerHour) {
	this.salaryPerHour = salaryPerHour;
}


public int getYearExperience() {
	return yearExperience;
}


public void setYearExperience(int yearExperience) {
	this.yearExperience = yearExperience;
}
@Override
public String toString() {
	return "Worker [occupation = "+ occupationName  + ", first Name = " + firstName + ", last Name = " + lastName + ",age = "
			+ age + ", salary per hour = " + salaryPerHour + ",film genre can play = " + genre + ", year Experience = " + yearExperience + "]"+"\n";
}
}
