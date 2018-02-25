package FilmStudio;

import model.enums.FilmGenre;

public class Director extends Worker {
		public String scenario;

	public Director (String scenario, String occupationName, String firstName, String lastName, int age, int salaryPerHour,
		     FilmGenre genre, int yearExperience)  {
		super(occupationName, firstName, lastName, age, salaryPerHour, genre, yearExperience);
		this.scenario = scenario;
	}


	public Director() {
	}

	public String getScenario() {
		return scenario;
	}

	public void setScenario(String scenario) {
		this.scenario = scenario;
	}

}
