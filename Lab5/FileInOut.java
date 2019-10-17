package com.company;

import java.io.*;
import java.util.Scanner;

public class FileInOut {
    static StringBuilder readFile(FileReader inPath) throws IOException {
        StringBuilder text = new StringBuilder();
        Scanner fin = new Scanner(inPath);
        while (fin.hasNextLine()) {
            //String temp = fin.nextLine().toLowerCase();
            text.append(fin.nextLine());
            text.append("\n");
        }
        //fin.close();
        return text;
    }

    static void writeFile(FileWriter outPath, String text) throws IOException {
        outPath.append(text);
        //outPath.close();
    }
}
