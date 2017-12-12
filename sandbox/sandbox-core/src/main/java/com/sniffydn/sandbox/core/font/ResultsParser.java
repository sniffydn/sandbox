package com.sniffydn.sandbox.core.font;

import java.io.File;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author dnyffeler
 */
public class ResultsParser {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        File resultPath = new File("C:\\TEMP\\Font\\3Results");
        Map<String, List<FontAndScore>> fontMap = new HashMap<>();

        for (File r : resultPath.listFiles()) {
            ArrayList<FontAndScore> fontAndScoreList = new ArrayList<FontAndScore>();
            fontMap.put(r.getName(), fontAndScoreList);
            for (File s : r.listFiles()) {
                FontAndScore fontAndScore = new FontAndScore();
                fontAndScore.font = s.getName();
//                System.out.print(r.getName() + "," + s.getName());
                int composite = 0;
                StringBuilder sb = new StringBuilder();
                for (File t : s.listFiles()) {
                    String percent = t.getName().substring(t.getName().indexOf("_") + 1, t.getName().length() - 4);
                    composite += Integer.parseInt(percent);
                    sb.append(",");
                    sb.append(percent);
                }
//                System.out.println("," + composite + sb.toString());
                fontAndScore.score = composite;
                fontAndScoreList.add(fontAndScore);
            }
        }

        for (Object key : fontMap.keySet()) {
            List<FontAndScore> list = fontMap.get(key);
            list.sort(new Comparator<FontAndScore>() {

                @Override
                public int compare(FontAndScore o1, FontAndScore o2) {
                    return o2.score.compareTo(o1.score);
                }
            });

            for (int i = 0; i < 20 && i < list.size() - 1; i++) {
                FontAndScore fas = list.get(i);
                System.out.println(key + "," + fas.font + "," + fas.score);
            }
        }
    }
}

class FontAndScore {

    String font;
    Integer score;
}
