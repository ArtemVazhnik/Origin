package com.company;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;
import java.util.function.Supplier;

public class Test {
    public static void main(String[] args) {
        String CSV = "input.csv";
        String logger = "logfile.txt";
        String output = "output";
        String fieldName = "state";

        try (FileWriter log = new FileWriter(logger)) {
            Logger.launch(log);
            try (FileReader in = new FileReader(CSV); FileWriter out = new FileWriter(output)) {
                Scanner fin = new Scanner(in);
                Supplier<HumanModel> sup = ()->{return new HumanModel();};
                CSVDatabaseLoader<HumanModel> loader = new CSVDatabaseLoader<>(sup);
                Database<HumanModel> database = new Database<>(sup, loader);
                database.load(fin);
                String message = "field sorting (" + fieldName + "); \t";
                database.sort(fieldName);
                Logger.inquiry(log, 1, message + "amount of users: " + (database.writeToFile(out)));
            } catch (Throwable throwable) {
                Logger.inquiry(log, 0, throwable.getMessage());
            }
        } catch (Throwable throwable) {
            System.err.println(throwable.getMessage());
        }

    }

}
