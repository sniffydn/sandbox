package com.sniffydn.sandbox.core.sn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Util {

    public static final Map<String, List<String>> FIRST_PERSON = new HashMap<>();
    public static final Map<String, List<String>> SECOND_PERSON = new HashMap<>();
    public static final Map<String, String> GLOBAL_REPLACE = new HashMap<>();
    public static final List<String> COLORS = new ArrayList<>();

    static {

        FIRST_PERSON.put("she", Arrays.asList(new String[]{"I"}));
        FIRST_PERSON.put("he", Arrays.asList(new String[]{"I"}));
        FIRST_PERSON.put("himself", Arrays.asList(new String[]{"myself"}));
        FIRST_PERSON.put("herself", Arrays.asList(new String[]{"myself"}));
        FIRST_PERSON.put("is", Arrays.asList(new String[]{"am"}));
        FIRST_PERSON.put("walks", Arrays.asList(new String[]{"walk"}));

        SECOND_PERSON.put("she", Arrays.asList(new String[]{"you"}));
        SECOND_PERSON.put("he", Arrays.asList(new String[]{"you"}));
        SECOND_PERSON.put("himself", Arrays.asList(new String[]{"yourself"}));
        SECOND_PERSON.put("herself", Arrays.asList(new String[]{"yourself"}));
        SECOND_PERSON.put("is", Arrays.asList(new String[]{"are"}));
        SECOND_PERSON.put("walks", Arrays.asList(new String[]{"walk"}));

        COLORS.add("black");
        COLORS.add("white");
        COLORS.add("red");
        COLORS.add("blue");

        GLOBAL_REPLACE.put("$hh#", "hh");
        GLOBAL_REPLACE.put("$hhp#", "hhp");
        GLOBAL_REPLACE.put("$md#", "md");
        GLOBAL_REPLACE.put("$uw#", "uw");
        GLOBAL_REPLACE.put("$primaryColor#", COLORS.get(Util.getRandom(COLORS.size())));
        GLOBAL_REPLACE.put("$secondaryColor#", COLORS.get(Util.getRandom(COLORS.size())));
        GLOBAL_REPLACE.put("$tertiaryColor#", COLORS.get(Util.getRandom(COLORS.size())));


    }

    public static int getRandom(int size) {
        return (int) Math.floor(Math.random() * size);
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            System.out.println(getRandom(10));
        }
    }

    public static String globalReplace(String temp) {
        String s = temp.replaceFirst(Pattern.quote(" "), " ");
        for(String key:GLOBAL_REPLACE.keySet()) {
            s = s.replaceAll(Pattern.quote(key), Matcher.quoteReplacement(GLOBAL_REPLACE.get(key)));
        }
        return s;
    }
}
