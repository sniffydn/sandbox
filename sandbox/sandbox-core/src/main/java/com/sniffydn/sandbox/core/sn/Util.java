package com.sniffydn.sandbox.core.sn;

import com.sniffydn.sandbox.core.sn.impl.Her;
import com.sniffydn.sandbox.core.sn.impl.Me;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Util {

    public static final boolean HER_FIRST_PERSON = true;
    public static final Map<String, List<String>> COMMON_VERBS = new HashMap<>();

    public static final Map<String, String> GLOBAL_REPLACE = new HashMap<>();
    public static final List<String> COLORS = new ArrayList<>();

    static {
        COMMON_VERBS.put("(?i)\\bwalks\\b", new ArrayList<>(Arrays.asList(new String[]{"walk"})));
        COMMON_VERBS.put("(?i)\\bfinds\\b", new ArrayList<>(Arrays.asList(new String[]{"find"})));
        COMMON_VERBS.put("(?i)\\btakes\\b", new ArrayList<>(Arrays.asList(new String[]{"take"})));
        COMMON_VERBS.put("(?i)\\byanks\\b", new ArrayList<>(Arrays.asList(new String[]{"yank"})));
        COMMON_VERBS.put("(?i)\\bthrows\\b", new ArrayList<>(Arrays.asList(new String[]{"throw"})));
        COMMON_VERBS.put("(?i)\\bpulls\\b", new ArrayList<>(Arrays.asList(new String[]{"pull"})));


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

    public static String globalPronounReplace(String temp) {
        if(HER_FIRST_PERSON) {
            temp = temp.replaceAll("(?i)\\bshe\\b", "I");
            temp = temp.replaceAll("(?i)\\bherself\\b", "myself");
            temp = temp.replaceAll("(?i)\\bher\\b", "my");//me?


            temp = temp.replaceAll("(?i)\\bhe\\b", "you");
            temp = temp.replaceAll("(?i)\\bhimself\\b", "yourself");
            temp = temp.replaceAll("(?i)\\bhis\\b", "your");
            temp = temp.replaceAll("(?i)\\bhim\\b", "you");
        } else {
            temp = temp.replaceAll("(?i)\\bshe\\b", "you");
            temp = temp.replaceAll("(?i)\\bherself\\b", "yourself");
            temp = temp.replaceAll("(?i)\\bher\\b", "your");


            temp = temp.replaceAll("(?i)\\bhe\\b", "I");
            temp = temp.replaceAll("(?i)\\bhimself\\b", "myself");
            temp = temp.replaceAll("(?i)\\bhis\\b", "my");
            temp = temp.replaceAll("(?i)\\bhim\\b", "me");
        }
        return temp;
    }

    public static String globalReplace(String temp) {
        String s = temp.replaceFirst(Pattern.quote(" "), " ");
        for(String key:GLOBAL_REPLACE.keySet()) {
            s = s.replaceAll(Pattern.quote(key), Matcher.quoteReplacement(GLOBAL_REPLACE.get(key)));
        }
        return s;
    }

    public static String me(String text) {
        for (String key : Me.getCOMMON_VERBS().keySet()) {
            Pattern pattern = Pattern.compile(key);
            Matcher matcher = pattern.matcher(text);
            while((matcher.find())) {
                List<String> wordList = Me.getCOMMON_VERBS().get(key);
                text = text.replaceFirst(key, wordList.get(Util.getRandom(wordList.size())));
            }
        }
        return Util.globalPronounReplace(text);
    }

    public static String her(String text) {
        for (String key : Her.getCOMMON_VERBS().keySet()) {
            Pattern pattern = Pattern.compile(key);
            Matcher matcher = pattern.matcher(text);
            while((matcher.find())) {
                List<String> wordList = Her.getCOMMON_VERBS().get(key);
                text = text.replaceFirst(key, wordList.get(Util.getRandom(wordList.size())));
            }
        }
        return Util.globalPronounReplace(text);
    }
}
