package com.sniffydn.sandbox.core;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LynxLogParser {

    public static void main(String[] args) {
        List<String> searchStrings = new ArrayList<>();
        searchStrings.add("INFO  c.m.lynx.ui.product.ProductEditor - ");
        searchStrings.add("INFO  c.m.l.u.t.MagnetStreetEventListener - ");

        System.out.println();
        StringBuilder fullString = new StringBuilder();
        FileReader fr = null;
        BufferedWriter bw = null;
        try {
            File f = new File("C:\\TEMP\\lynx.log");
            fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            // Process lines from file
            String line;
            while ((line = br.readLine()) != null) {
                for (String searchString : searchStrings) {
                    if (line.contains(searchString)) {
                        fullString.append(line.replaceAll(searchString, "") + "\n");
                    }
                }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(LynxLogParser.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(LynxLogParser.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fr.close();
            } catch (IOException ex) {
                Logger.getLogger(LynxLogParser.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        System.out.println(fullString);
    }
}
