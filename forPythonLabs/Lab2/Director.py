from Worker import Worker


class Director(Worker):
    __scenario = " "

    def __init__(self, occupation_name, first_name, last_name, age, salary_per_hour, year_experience, film_genre,
                 scenario):
        Worker.__init__(self, occupation_name, first_name, last_name, age, salary_per_hour, year_experience, film_genre)
        self.__scenario = scenario

    def reset_values(self, occupation_name, first_name, last_name, age, salary_per_hour, year_experience, film_genre,
                     scenario=" "):
        Worker.reset_values(self, occupation_name, first_name, last_name, age, salary_per_hour, year_experience,
                            film_genre)
        self.__scenario = scenario

    def to_string(self):
        print("Occupation name: " + self.occupation_name + ", first name " + self.first_name +
              ", last name: " + self.last_name + ", age: " + str(self.age)
              + ", salary per hour: " + str(self.salary_per_hour) + ", year experience: "
              + str(self.year_experience) + ", Film Genre"
              + str(self.film_genre)
              + ", Scenario :" + self.__scenario)
