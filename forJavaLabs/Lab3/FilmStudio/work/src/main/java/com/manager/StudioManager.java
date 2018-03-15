package com.manager;

import com.filmstudio.Worker;

import java.util.LinkedList;
import java.util.List;

public class StudioManager {
    private List<Worker> availableWorkers = new LinkedList<Worker>();

    public final String print() {
        String output = "";
        for (Worker worker : availableWorkers) {
            output += worker;
        }
        return output;
    }

    public StudioManager() {
    }

    public final void addWorker(final Worker addWorker) {
        availableWorkers.add(addWorker);
    }

    public final List<Worker> getWorkerGenres() {
        return availableWorkers;
    }


    public final List<Worker> findWorkersByGenres(final String workerToFind) {
        List<Worker> workerList = new LinkedList<Worker>();

        for (Worker worker : availableWorkers) {
            if (workerToFind.equals(worker.getGenre().name())) {
                workerList.add(worker);
            }
        }
        return workerList;
    }

    public final List<Worker> sortBySalaryPerHour() {
        availableWorkers.sort((Worker o1, Worker o2) -> o1.getSalaryPerHour() - o2.getSalaryPerHour());
        return availableWorkers;
    }
}