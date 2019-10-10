package com.company;

import java.io.IOException;
import java.util.regex.Pattern;

public class Test {
    public static void main(String[] args) throws IOException {

        String inPath = "C:\\Users\\User\\IdeaProjects\\DeleteComments\\src\\com\\company\\input";
        String outPath = "C:\\Users\\User\\IdeaProjects\\DeleteComments\\src\\com\\company\\output";

        String str = "('\\\\?.')|(\"[^\\\\]*?(\\\\?.[^\\\\]*?)*?\")|(\\/\\/.*)|(\\/\\*[\\s\\S]*?\\*\\/)";


        Pattern pattern = Pattern.compile(str);
        CommentaryCollector toDelete = new CommentaryCollector(pattern);

        FileInOut.writeText(outPath,toDelete.delete(FileInOut.readText(inPath)));
        System.out.println("Done!");
    }
}
