package com.company;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Text {
    private final static String TAGREGEX = "<.*?>";

    public static String deleteAllHTMLTags(StringBuilder text) {
        Pattern pattern = Pattern.compile(TAGREGEX);
        Matcher matcher = pattern.matcher(text);

        return matcher.replaceAll("");
    }

    public static ArrayList<String> findAllHTMLTags(StringBuilder text) {
        Pattern pattern = Pattern.compile(TAGREGEX);
        Matcher matcher = pattern.matcher(text);
        ArrayList<String> result = new ArrayList<String>();

        while (matcher.find()) {
            if (
                    text.charAt(matcher.start() + 1) != '/' &&
                            !result.contains(text.substring(matcher.start(), matcher.end()))
            ) {
                result.add(text.substring(matcher.start(), matcher.end()));
            }

        }
        result.sort(Comparator.comparing(String::length));
        return result;
    }

    public static ArrayList<Integer> findTextFragments(String text, String fragments) {
        ArrayList<Integer> answer = new ArrayList<Integer>();
        String[] textArray = text.split("\\n");
        String[] fragmentsArray = fragments.split("(\\n)|(; )|(;\\n)|(;)");

        for (String temp:fragmentsArray) {
            int i = 0;
            while (i < textArray.length) {
                if (textArray[i].toLowerCase().contains(temp.toLowerCase())) break;
                i++;
            }
            if (i == textArray.length) i = -1;
            answer.add(i);
        }
        return answer;
    }

    public static ArrayList<String> getNotFoundFragments(String text, String fragments) {
        ArrayList<String> answer = new ArrayList<String>();
        String[] textArray = text.split("\\n");
        String[] fragmentsArray = fragments.split("(\\n)|(; )|(;\\n)|(;)");
        for (String temp:fragmentsArray) {
            int i = 0;
            while (i < textArray.length) {
                if (textArray[i].toLowerCase().contains(temp.toLowerCase())) break;
                i++;
            }
            if (i == textArray.length) answer.add(temp);
        }
        return answer;
    }
}
