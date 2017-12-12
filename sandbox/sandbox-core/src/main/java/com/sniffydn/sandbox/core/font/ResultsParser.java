package com.sniffydn.sandbox.core.font;

import java.io.File;

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

        for (File r : resultPath.listFiles()) {
            for (File s : r.listFiles()) {
                System.out.print(r.getName() + "," + s.getName());
                int composite = 0;
                StringBuilder sb = new StringBuilder();
                for (File t : s.listFiles()) {
                    String percent = t.getName().substring(t.getName().indexOf("_") + 1, t.getName().length() - 4);
                    composite += Integer.parseInt(percent);
                    sb.append(",");
                    sb.append(percent);
                }
                System.out.println("," + composite + sb.toString());
            }
        }
    }

}
