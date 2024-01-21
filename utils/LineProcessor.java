package utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LineProcessor {
    public static int getNum(String line) throws Exception {
        Pattern pattern = Pattern.compile("\\[(\\d+)]");
        Matcher matcher = pattern.matcher(line);

        if (matcher.find()) {
            int num = Integer.parseInt(matcher.group(1));
            return num;
        } else {
            throw new Exception("No number id on line" + line);
        }
    }

    public static String getLine(String input) throws Exception {
        Pattern pattern = Pattern.compile("\\[n\\] (.+)");
        Matcher matcher = pattern.matcher(input);

        if (matcher.find()) {
            return matcher.group(1);
        } else {
            throw new Exception("Wrong line format");
        }
    }
}

