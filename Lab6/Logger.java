package com.company;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public class Logger {

    public static void launch(FileWriter writer) throws IOException {
        Date current = new Date();
        writer.append("Launched at " + current.toString() + "\n");
    }

    public static void inquiry(FileWriter writer, int mode, String message) throws IOException {
        switch (mode) {
            case 1: {
                writer.append(message + "\n");
                break;
            }
            default: {
                writer.append("fault: " + message + "\n");
            }
        }

    }
}
