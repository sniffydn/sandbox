package com.sniffydn.sandbox.core;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import org.json.JSONObject;

/**
 *
 * @author dnyffeler
 */
public class JSONLogConverter {

    private static final List<String> keys;
    private static final String DELIMITER = ",";

    static {
        List<String> temp = new ArrayList<>();
        temp.add("method");
        temp.add("returnCode");
        temp.add("docId");
        temp.add("startTime");
        temp.add("finishTime");
        temp.add("elapseTime");
        temp.add("timeWithAdobo");
        temp.add("returnMessage");
        temp.add("sessionId");
        temp.add("parameterData");

        keys = temp;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        for (String s : keys) {
            System.out.print(s + DELIMITER);
        }
        System.out.println();
        StringBuilder fullJSONString = new StringBuilder();
        FileReader fr = null;
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\TEMP\\gmi\\log.csv", true));
            File f = new File("C:\\TEMP\\gmi\\" + "GMIS172-16-7-122-20151228000000" + ".log");
            fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            // Process lines from file
            String line;
            while ((line = br.readLine()) != null) {
                fullJSONString.append(line);
                if (line.trim().equals("}")) {
                    try {
                        JSONObject json = new JSONObject(fullJSONString.toString());

                        for (String s : keys) {
                            try {
                                System.out.print(json.getString(s) + DELIMITER);
                                bw.append(json.getString(s) + DELIMITER);
                            } catch (Exception e) {
                                try {
                                    System.out.print(json.getInt(s) + DELIMITER);
                                    bw.append(json.getInt(s) + DELIMITER);
                                } catch (Exception e1) {
                                    try {
                                        System.out.print(json.getJSONObject(s).toString().replaceAll(Pattern.quote(DELIMITER), "|") + DELIMITER);
                                        bw.append(json.getJSONObject(s).toString().replaceAll(Pattern.quote(DELIMITER), "|") + DELIMITER);
                                    } catch (Exception e2) {
                                        System.out.print(e2);
                                    }
                                }
                            }
                        }
                        System.out.println();
                        bw.newLine();
                        fullJSONString = new StringBuilder();
                    } catch (Exception e) {
                    }
                }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(JSONLogConverter.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(JSONLogConverter.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fr.close();
            } catch (IOException ex) {
                Logger.getLogger(JSONLogConverter.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
