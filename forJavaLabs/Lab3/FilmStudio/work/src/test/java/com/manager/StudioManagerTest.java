package com.manager;

import com.filmstudio.*;
import model.enums.FilmGenre;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StudioManagerTest {

    private Actor actor = new Actor("Neil", "Armstrong", "Actor",
            "Ryan", "Gosling", 37, 9500, FilmGenre.COMEDYFILMS, 20);
    private Cameraman cameraman = new Cameraman(25, "Cameraman", "Robert",
            "Elswit", 57, 12000, FilmGenre.DOCUMENTARYFILMS,
            39);
    private Producer producer = new Producer(25000000.50, "Producer", "Lauren",
            "Greenfield", 63, 20500, FilmGenre.DOCUMENTARYFILMS, 40);

    private Director director = new Director("First Man", "Director", "Michael",
            "Bay", 53, 50000, FilmGenre.ADVENTUREFILMS,
            27);

    private List<Worker> menu = new LinkedList<>();
    StudioManager manager = new StudioManager();

    @Test
    void printTest() {
        manager.addWorker(actor);
        manager.addWorker(cameraman);
        manager.addWorker(producer);
        manager.addWorker(director);


        String actualMenu = "";
        for (Worker worker : manager.getWorkerGenres()) {
            actualMenu += worker;

        }
        String expectedMenu = manager.print();
        assertEquals(expectedMenu, actualMenu);

    }


    @Test
    void addWorkerTest() {
        manager = new StudioManager();
        manager.addWorker(actor);
        manager.addWorker(cameraman);
        manager.addWorker(producer);
        manager.addWorker(director);

    }


    @Test
    void findWorkersByGenresTest() {
        String workerToFind = "DOCUMENTARYFILMS";
        manager.addWorker(actor);
        manager.addWorker(cameraman);
        manager.addWorker(producer);
        manager.addWorker(director);
        List<Worker> expectedWorkers = manager.findWorkersByGenres(workerToFind);
        List<Worker> actualWorkers = new LinkedList<>();
        actualWorkers.add(cameraman);
        actualWorkers.add(producer);
        assertEquals(expectedWorkers, actualWorkers);
    }

    @Test
    void sortBySalaryPerHourTest() {
        manager.addWorker(actor);
        manager.addWorker(cameraman);
        manager.addWorker(producer);
        manager.addWorker(director);
        menu.add(actor);
        menu.add(cameraman);
        menu.add(producer);
        menu.add(director);

        List<Worker> workers = manager.sortBySalaryPerHour();
        assertEquals(workers, menu);
    }
    @Test
    void writerTest (){
        manager.addWorker(actor);
        manager.addWorker(cameraman);
        manager.addWorker(producer);
        manager.addWorker(director);
        WorkerWriter workerWriter = new WorkerWriter();
        workerWriter.writeToFile(manager.getWorkerGenres());
    }

}