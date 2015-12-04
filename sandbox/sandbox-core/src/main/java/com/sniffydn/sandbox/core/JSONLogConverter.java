/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sniffydn.sandbox.core;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONObject;

/**
 *
 * @author dnyffeler
 */
public class JSONLogConverter {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        StringBuilder fullJSONString = new StringBuilder();
        FileReader fr = null;
        try {
            File f = new File("C:\\TEMP\\gmi\\GMIS172-16-7-122-20151203212536.log");
            fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            // Process lines from file
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
                fullJSONString.append(line);
                if(line.trim().equals("}")) {
                    try {
                        JSONObject json = new JSONObject(fullJSONString);
                        
                        
                    } catch(Exception e) {
                        
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
