from Studio.Worker import Worker


class Actor(Worker):
    __character_first_name = ""
    __character_last_name = ""

    def __init__(self, occupation_name, first_name, last_name, age, salary_per_hour, year_experience, film_genre,
                 character_first_name, character_last_name):
        Worker.__init__(self, occupation_name, first_name, last_name, age, salary_per_hour, year_experience, film_genre)
        self.__character_first_name = character_first_name
        self.__character_last_name = character_last_name

    def reset_values(self, occupation_name, first_name, last_name, age, salary_per_hour, year_experience,
                     film_genre, character_first_name=" ", character_last_name=" "):
        Worker.reset_values(self, occupation_name, first_name, last_name, age, salary_per_hour,
                            year_experience, film_genre)
        self.__character_first_name = character_first_name
        self.__character_last_name = character_last_name

    def to_string(self):
        print("Occupation name: " + self.occupation_name + ", first name " + self.first_name +
              ", last name: " + self.last_name + ", age: " + str(self.age)
              + ", salary per hour: " + str(self.salary_per_hour) + ", year experience: " + str(self.year_experience)
              + ", Film Genre"
              + str(self.film_genre)
              + ", character first name: " + self.__character_first_name + ", character last name: "
              + self.__character_last_name)
