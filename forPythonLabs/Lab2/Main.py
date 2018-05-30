from StudioManager import StudioManager
from Actor import Actor
from Cameraman import Cameraman
from Producer import Producer
from enums.FilmGenre import FilmGenre
from Director import Director

if __name__ == "__main__":
    studio_manager = StudioManager()
    actor = Actor("Actor", "Neil", "Armstrong", 37, 9500, 20, FilmGenre.COMEDYFILMS, "Ryan", "Gosling")
    cameraman = Cameraman("Cameraman", "Robert", "Elswit", 57, 12000, FilmGenre.DOCUMENTARYFILMS, 39, 2)
    producer = Producer("Producer", "Lauren", "Greenfield", 63, 20500, 35, FilmGenre.DOCUMENTARYFILMS, 20)
    director = Director("Director", "Michael", "Bay", 53, 50000, 27, FilmGenre.ADVENTUREFILMS, "First Man")

    studio_manager.available_workers = [actor, cameraman, director, producer]
    print("before sort: ")
    studio_manager.print_list()

    studio_manager.sort_by_salary_per_hour()
    print("\n after sort:")
    studio_manager.print_list()

    studio_manager.available_workers = studio_manager.find_workers_by_genres(FilmGenre.COMEDYFILMS)
    print("Found list:")
    studio_manager.print_list()

    pass
