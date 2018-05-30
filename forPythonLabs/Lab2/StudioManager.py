class StudioManager():
    available_workers = []

    def init(self):
        pass

    def add_worker(self, worker):

        self.available_workers += worker

    def print_(self):
        for worker in self.available_workers:
            print(worker.to_string())

    def print_list(self):
        for worker in self.available_workers:
            print(worker.to_string())

    def sort_by_salary_per_hour(self):
        self.available_workers.sort(key=lambda x: x.salary_per_hour, reverse=False)

    def find_workers_by_genres(self, film_genre):
        worker_list = []
        for worker in self.available_workers:
            if worker.film_genre == film_genre:
                worker_list.append(worker)
            return worker_list

        pass
