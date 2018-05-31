package com.filmstudio;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class WorkerWriter {

    public final void writeToFile(final List<Worker> workers) {
        try (PrintWriter writer = new PrintWriter("staff.csv")) {
            for (Worker worker : workers) {
                writer.println(worker.getHeaders());
                writer.println(worker.toCSV());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

