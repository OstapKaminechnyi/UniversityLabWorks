package FilmStudio;

import model.enums.FilmGenre;

public class Actor extends Worker {
	public String characterFirstName ;
	public String characterLastName;
	
	public Actor(String characterFirstName, String characterLastName, String occupationName, String firstName, String lastName, int age, int salaryPerHour,
		     FilmGenre genre, int yearExperience)  {
		super(occupationName, firstName, lastName, age, salaryPerHour, genre, yearExperience);
		    this.characterFirstName = characterFirstName;
		    this.characterLastName = characterLastName;
		  }
	
	public Actor() {
		
	}
	public String getCharacterFirstName() {
		return characterFirstName;
	}
	public void setCharacterFirstName(String characterFirstName) {
		this.characterFirstName = characterFirstName;
	}
	public String getCharacterLastName() {
		return characterLastName;
	}
	public void setCharacterLastName(String characterLastName) {
		this.characterLastName = characterLastName;
	}
	
 
}
