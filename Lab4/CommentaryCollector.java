package com.company;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CommentaryCollector {
    private Pattern pattern;

    public CommentaryCollector(Pattern pattern) {
        this.pattern = pattern;
    }

    public StringBuilder delete(StringBuilder text) {

        Matcher matcher = pattern.matcher(text);
        StringBuilder result = new StringBuilder();
        Integer start = 0;
        while (matcher.find()) {
            if ((text.charAt(matcher.start()) == '"') || (text.charAt(matcher.start()) == '\'')) {
                result.append(text.subSequence(start,matcher.end()));
                start = matcher.end();
            }
            else {
                result.append(text.subSequence(start, matcher.start()));
                start = matcher.end();
            }
        }
        result.append(text.subSequence(start,text.length()));
        return result;
    }
}
