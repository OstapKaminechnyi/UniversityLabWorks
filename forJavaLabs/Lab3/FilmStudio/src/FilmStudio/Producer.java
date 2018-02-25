package FilmStudio;

import model.enums.FilmGenre;

public class Producer extends Worker {
	
	public Producer (double moneyAmount, String occupationName, String firstName, String lastName, int age, int salaryPerHour,
		     FilmGenre genre, int yearExperience)  {
		super(occupationName, firstName, lastName, age, salaryPerHour, genre, yearExperience);
		this.moneyAmount = moneyAmount;

	}	
	

public double moneyAmount;

public Producer() {
}

public double getMoneyAmount() {
	return moneyAmount;
}

public void setMoneyAmount(double moneyAmount) {
	this.moneyAmount = moneyAmount;
}

}
