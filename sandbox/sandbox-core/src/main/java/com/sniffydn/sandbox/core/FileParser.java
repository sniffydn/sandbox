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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileParser {

    public static void main(String[] args) {
        String cityStateZipRegex = "(^.+[,]{1}.*[a-zA-Z]{2}.*[ ]{1}.+$)";
        Pattern cityStateZipPattern = Pattern.compile(cityStateZipRegex);
        Matcher cityStateZipMatcher;

        String phoneRegex = "[(]{1}[0-9]{3}[)]{1} [0-9]{3}.*[0-9]{4}";
        Pattern phonePattern = Pattern.compile(phoneRegex);
        Matcher phoneMatcher;

        List<Address> addresses = new ArrayList<>();

        System.out.println();
        FileReader fr = null;
        BufferedWriter bw = null;
        try {
            File f = new File("C:\\TEMP\\chick-fil-a-locations.txt");
            fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            // Process lines from file
            String line;
            Address address = new Address();
            while ((line = br.readLine()) != null) {
                line = line.replaceAll(Pattern.quote("\""), "");
                line = line.trim();
                if (line.length() == 0) {
                    continue;
                }
                cityStateZipMatcher = cityStateZipPattern.matcher(line);
                phoneMatcher = phonePattern.matcher(line);
                System.out.println(line);
                boolean cityStateZipFound = cityStateZipMatcher.find();
                boolean phoneFound = phoneMatcher.find();
                if (phoneFound) {
                    address.phone = line;
                    addresses.add(address);
                    address = new Address();
                } else {
                    if (address.name == null) {
                        address.name = line;
                    } else if (address.address1 == null) {
                        address.address1 = line;
                    } else if (address.address2 == null) {
                        if (cityStateZipFound) {
                            System.out.println("CSZ: " + line);
                            address.cityStateZip = "\"" + line + "\"";
                        } else {
                            System.out.println("AD2: " + line);
                            address.address2 = line;
                        }
                    } else if (cityStateZipFound) {
                        address.cityStateZip = "\"" + line + "\"";
                    }
                }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileParser.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FileParser.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fr.close();
            } catch (IOException ex) {
                Logger.getLogger(FileParser.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        for (Address address : addresses) {
            StringBuilder sb = new StringBuilder();
            if (address.name == null) {
                sb.append(",");
            } else {
                sb.append(address.name);
                sb.append(",");
            }
            if (address.address1 == null) {
                sb.append(",");
            } else {
                sb.append(address.address1);
                sb.append(",");
            }
            if (address.address2 == null) {
                sb.append(",");
            } else {
                sb.append(address.address2);
                sb.append(",");
            }
            if (address.cityStateZip == null) {
                sb.append(",");
            } else {
                sb.append(address.cityStateZip);
                sb.append(",");
            }
            if (address.phone != null) {
                sb.append(address.phone);
            }

            System.out.println(sb.toString());
        }
    }
}

class Address {

    String name;
    String address1;
    String address2;
    String cityStateZip;
    String phone;
}
