package com.company;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Test {
    public static void main(String[] args) throws IOException {

        String textHTMLPath = "C:\\Users\\User\\IdeaProjects\\HTML-tegs\\input1.html";
        String textFragmentsPath = "C:\\Users\\User\\IdeaProjects\\HTML-tegs\\input2";
        String output1Path = "C:\\Users\\User\\IdeaProjects\\HTML-tegs\\output1";
        String output2Path = "C:\\Users\\User\\IdeaProjects\\HTML-tegs\\output2";
        String output3Path = "C:\\Users\\User\\IdeaProjects\\HTML-tegs\\output3";


        var textHTML = FileInOut.readFile(new FileReader(textHTMLPath));

        ArrayList<String> tagList = Text.findAllHTMLTags(textHTML);
        FileWriter output1 = new FileWriter(output1Path);

        for (String temp : tagList) {
            FileInOut.writeFile(output1, temp + "\n");
        }
        output1.close();


        var textFragments = FileInOut.readFile(new FileReader(textFragmentsPath));

        ArrayList<Integer> fragmentsPositionList;
        fragmentsPositionList = Text.findTextFragments(Text.deleteAllHTMLTags(textHTML), new String(textFragments));
        FileWriter output2 = new FileWriter(output2Path);

        for (Integer temp : fragmentsPositionList) {
            FileInOut.writeFile(output2, temp + "\n");
        }
        output2.close();


        ArrayList<String> notFoundFragmentsList;
        notFoundFragmentsList = Text.getNotFoundFragments(Text.deleteAllHTMLTags(textHTML), new String(textFragments));
        FileWriter output3 = new FileWriter(output3Path);
        for (String temp : notFoundFragmentsList) {
            FileInOut.writeFile(output3, temp + "\n");
        }
        output3.close();

    }

}
