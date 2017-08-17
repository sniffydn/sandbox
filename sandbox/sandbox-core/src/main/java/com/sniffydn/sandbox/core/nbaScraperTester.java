package com.sniffydn.sandbox.core;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;

public class nbaScraperTester {

    /**
     * @param args the command line arguments
     * http://stats.nba.com/schedule#!?Month=1&TeamID=1610612737
     */
    public static void main(String[] args) {
//        BufferedReader in = null;
//        try {
//            URL url = new URL("https://www.stanza.co/api/schedules/nba-celtics/nba-celtics.ics");
//            in = new BufferedReader(
//                    new InputStreamReader(url.openStream()));
//            String response = parseFile(in);
//            System.out.println(response);
//
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }

        FileReader fr = null;
        try {
            File f = new File("C:\\Users\\dnyffeler\\Documents\\NetBeansProjects\\sandbox\\sandbox\\sandbox-core\\src\\main\\java\\com\\sniffydn\\sandbox\\core\\nba-celtics.ics");
            fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            // Process lines from file
            String line;
            StringBuilder response = new StringBuilder();
            while ((line = br.readLine()) != null) {
                response.append(line);
            }

            System.out.println(parseResponse(response.toString(), "Celtics"));

        } catch (Exception ex) {
            Logger.getLogger(nhlJsonTester.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fr.close();
            } catch (IOException ex) {
                Logger.getLogger(nhlJsonTester.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private static final String dateFormatString = "yyyyMMddHHmmss";

    private static SimpleDateFormat dateFormat = new SimpleDateFormat(dateFormatString);
    private static SimpleDateFormat dayOfWeekFormat = new SimpleDateFormat("EEE");
    private static SimpleDateFormat monthDayFormat = new SimpleDateFormat("M/d");
    private static SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm a");

    private static String parseResponse(String response, String teamName) {
        StringBuilder outgoingJson = new StringBuilder("{\n  teamLocation: '");
        outgoingJson.append("teamLocation");
        outgoingJson.append("',\n  teamName: '");
        outgoingJson.append("teamName");
        outgoingJson.append("',\n  schedule: [\n");

        response = response.replaceAll(Pattern.quote("BEGIN:VEVENT"), "~");

        StringTokenizer tok = new StringTokenizer(response, "~");
        while (tok.hasMoreTokens()) {
            String event = tok.nextToken();
            if (!(event.contains("SUMMARY:") && event.contains("DESCRIPTION:"))) {
                continue;
            }

            Date startDate = new Date();
            int dtStartIndex = event.indexOf("DTSTART:") + "DTSTART:".length();
            try {
                String dateString = event.substring(dtStartIndex, dtStartIndex + dateFormatString.length() + 1).replaceAll(Pattern.quote("T"), "");
                startDate = dateFormat.parse(dateString);
                Calendar c = new GregorianCalendar();
                c.setTime(startDate);
                c.add(Calendar.HOUR, -4);
                startDate = c.getTime();
            } catch (Exception ex) {
                System.out.println(event + "\n  " + dtStartIndex);

                ex.printStackTrace();
            }

            if (!startDate.after(new Date())) {
                continue;
            }

            outgoingJson.append("['");
            outgoingJson.append(dayOfWeekFormat.format(startDate));
            outgoingJson.append("', '");
            outgoingJson.append(monthDayFormat.format(startDate));
            outgoingJson.append("', '");

            int summaryStartIndex = event.indexOf("SUMMARY:") + "SUMMARY:".length();
            int summaryEndIndex = event.indexOf("DESCRIPTION:", summaryStartIndex);
            String summary = event.substring(summaryStartIndex, summaryEndIndex);
            summary = summary.replaceAll("at " + teamName, "");
            summary = summary.replaceAll(teamName, "");
            summary = summary.replaceAll(" at ", "@");
            summary = summary.trim();

            outgoingJson.append(summary);

            outgoingJson.append("', '");
            outgoingJson.append(timeFormat.format(startDate));
            outgoingJson.append("', ''],\n");
        }

        outgoingJson.append("[]\n  ]\n}");

        return outgoingJson.toString();
    }

}
