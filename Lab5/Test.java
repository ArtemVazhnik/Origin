package com.company;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Test {
    public static void main(String[] args) throws IOException {

        String textHTMLPath = "C:\\Users\\User\\IdeaProjects\\HTML-tegs\\input1.html";
        String textFragmentsPath = "C:\\Users\\User\\IdeaProjects\\HTML-tegs\\input2";
        String output1 = "C:\\Users\\User\\IdeaProjects\\HTML-tegs\\output1";
        String output2 = "C:\\Users\\User\\IdeaProjects\\HTML-tegs\\output2";
        String output3 = "C:\\Users\\User\\IdeaProjects\\HTML-tegs\\output3";


        var textHTML = FileInOut.readFile(new FileReader(textHTMLPath));

        ArrayList<String> tagList = Text.findAllHTMLTags(textHTML);
        FileInOut.writeFile(new FileWriter(output1), tagList.toString());


        var textFragments = FileInOut.readFile(new FileReader(textFragmentsPath));

        ArrayList<Integer> fragmentsPositionList
                = Text.findTextFragments(Text.deleteAllHTMLTags(textHTML), new String(textFragments));
        FileInOut.writeFile(new FileWriter(output2), fragmentsPositionList.toString());

        ArrayList<String> notFoundFragmentsList
                = Text.getNotFoundFragments(Text.deleteAllHTMLTags(textHTML), new String(textFragments));
        FileInOut.writeFile(new FileWriter(output3), notFoundFragmentsList.toString());
    }
}
