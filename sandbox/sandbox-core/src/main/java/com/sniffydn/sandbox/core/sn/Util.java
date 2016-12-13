package com.sniffydn.sandbox.core.sn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Util {

    public static final Map<String, String> GLOBAL_REPLACE = new HashMap<>();
    public static final List<String> COLORS = new ArrayList<>();

    static {
        COLORS.add("black");
        COLORS.add("white");
        COLORS.add("red");
        COLORS.add("blue");

        GLOBAL_REPLACE.put("$hh#", "hh");
        GLOBAL_REPLACE.put("$pl#", "pl");
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
