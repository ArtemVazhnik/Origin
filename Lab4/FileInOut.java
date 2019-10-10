package com.company;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileInOut {
    static StringBuilder readText(String inPath)  throws IOException {
        StringBuilder text = new StringBuilder();
        File file = new File(inPath);
        Scanner in = new Scanner(file);
        while(in.hasNextLine()){
            text.append(in.nextLine());
            text.append("\n");
        }
        in.close();
        return text;
    }

    static void writeText(String outPath, StringBuilder text) throws IOException
    {
        FileWriter writer = new FileWriter(outPath);
        writer.append(text);
        writer.close();
    }
}
