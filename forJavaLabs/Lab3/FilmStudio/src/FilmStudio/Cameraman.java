package FilmStudio;

import model.enums.FilmGenre;

public class Cameraman extends Worker{
public int camerasAmount;

public Cameraman (int camerasAmount, String occupationName, String firstName, String lastName, int age, int salaryPerHour,
	     FilmGenre genre, int yearExperience)  {
	super(occupationName, firstName, lastName, age, salaryPerHour, genre, yearExperience);
	    	this.camerasAmount = camerasAmount;
}

public Cameraman(int camerasAmount) {
}

public Cameraman() {
}

public int getCamerasAmount() {
	return camerasAmount;
}

public void setCamerasAmount(int camerasAmount) {
	this.camerasAmount = camerasAmount;
}


}
