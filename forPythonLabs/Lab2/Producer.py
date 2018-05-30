from Worker import Worker


class Producer(Worker):
    __money_amount = 0

    def __init__(self, occupation_name, first_name, last_name, age, salary_per_hour, year_experience, film_genre,
                 money_amount):
        Worker.__init__(self, occupation_name, first_name, last_name, age, salary_per_hour, year_experience, film_genre)
        self.__money_amount = money_amount

    def reset_values(self, occupation_name, first_name, last_name, age, salary_per_hour, year_experience, film_genre,
                     money_amount=0):
        Worker.reset_values(self, occupation_name, first_name, last_name, age, salary_per_hour, year_experience,
                            film_genre)
        self.__money_amount = money_amount

    def to_string(self):
        print("Occupation name: " + self.occupation_name + ", first name " + self.first_name +
              ", last name: " + self.last_name + ", age: " + str(self.age)
              + ", salary per hour: " + str(self.salary_per_hour) + ", year experience: "
              + str(self.year_experience) + ", Film Genre"
              + str(self.film_genre) + ", Money Amount :" + str(self.__money_amount))
