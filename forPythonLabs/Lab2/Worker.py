from enums.FilmGenre import FilmGenre


class Worker:
    occupation_name, first_name, last_name, age, salary_per_hour, year_experience, film_genre = "", "", "", 0, 0, \
                                                                                                0, None

    def __init__(self, occupation_name="", first_name="", last_name="", age=0,
                 salary_per_hour=0, year_experience=0, film_genre=FilmGenre.OTHER):
        self.first_name = first_name
        self.last_name = last_name
        self.age = age
        self.salary_per_hour = salary_per_hour
        self.year_experience = year_experience
        self.film_genre = film_genre
        self.occupation_name = occupation_name

    def reset_values(self, occupation_name, first_name, last_name, age, salary_per_hour, year_experience,
                     film_genre):
        self.occupation_name = occupation_name
        self.last_name = last_name
        self.first_name = first_name
        self.age = age
        self.salary_per_hour = salary_per_hour
        self.year_experience = year_experience
        self.film_genre = film_genre

    def to_string(self):
        print("Occupation Name: " + self.occupation_name + ", First Name: " + self.first_name +
              ", Last Name: " + self.last_name + ", age: " + str(self.age) + ", Salary Per Hour : "
              + str(self.salary_per_hour) + ", Year Experience: " + str(self.year_experience) + ", Film Genre"
              + str(self.film_genre))
