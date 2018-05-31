package com.manager;

import com.filmstudio.Worker;
import com.persistance.dao.WorkerDao;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;


@Dependent
public class StudioManager implements Serializable {
    private static final long serialVersionUID = 1L;
    @Inject
    public WorkerDao workerDao;
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
    public Worker get( Integer id) {
        return workerDao.findById(id);
    }

    public Worker put(Worker worker) {
        return workerDao.persist(worker);
    }

    public void remove(Worker worker) {
        workerDao.remove(worker.getId());
    }

    public Worker update(Worker worker) {
        return workerDao.update(worker);
    }


}