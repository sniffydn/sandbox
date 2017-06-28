package com.sniffydn.sandbox.core;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONArray;
import org.json.JSONObject;

public class nhlJsonTester {

    /**
     * @param args the command line arguments
     * https://statsapi.web.nhl.com/api/v1/schedule?site=en_nhl&expand=schedule.teams,schedule.venue,schedule.metadata,schedule.ticket,schedule.broadcasts.all&startDate=2017-9-01&endDate=2018-4-30&teamId=24
     */
    public static void main(String[] args) {
        FileReader fr = null;
        try {
            File f = new File("C:\\Users\\dnyffeler\\Documents\\NetBeansProjects\\sandbox\\sandbox\\sandbox-core\\src\\main\\java\\com\\sniffydn\\sandbox\\core\\nhl.json");
            fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            // Process lines from file
            String line;
            StringBuilder response = new StringBuilder();
            while ((line = br.readLine()) != null) {
                response.append(line);
            }

            parseResponse(response.toString(), 24);

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

    private static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    private static SimpleDateFormat dayOfWeekFormat = new SimpleDateFormat("EEE");
    private static SimpleDateFormat monthDayFormat = new SimpleDateFormat("M/d");

    private static void parseResponse(String response, int teamId) {

        String teamLocation = null;
        StringBuilder outgoingJson = new StringBuilder("{\n  teamLocation: '");
        Map<String, Integer> teamToIdMap = new HashMap<>();

        JSONObject json = new JSONObject(response);

//            System.out.println(json.toString(2));
        JSONArray dates = json.getJSONArray("dates");
        for (int i = 0; i < dates.length(); i++) {
            try {
                JSONObject date = dates.getJSONObject(i);
//            System.out.println(date.getString("date"));
                Date d = dateFormat.parse(date.getString("date"));
                JSONArray games = date.getJSONArray("games");
                for (int j = 0; j < games.length(); j++) {
                    JSONObject game = games.getJSONObject(j);

                    JSONObject teams = game.getJSONObject("teams");
                    JSONObject away = teams.getJSONObject("away");
                    JSONObject home = teams.getJSONObject("home");
                    teamToIdMap.put(away.getJSONObject("team").getString("teamName"), away.getJSONObject("team").getInt("id"));
                    teamToIdMap.put(home.getJSONObject("team").getString("teamName"), home.getJSONObject("team").getInt("id"));
                    if (away.getJSONObject("team").getInt("id") == teamId) {
                        if (teamLocation == null) {
                            teamLocation = away.getJSONObject("team").getString("locationName");
                            if (teamLocation.equals("MontrÃ©al")) {
                                teamLocation = "Montréal";
                            }
                            outgoingJson.append(teamLocation);
                            outgoingJson.append("',\n  teamName: '");
                            outgoingJson.append(away.getJSONObject("team").getString("teamName"));
                            outgoingJson.append("',\n  schedule: [\n");
                        }
                        outgoingJson.append("['");
                        outgoingJson.append(dayOfWeekFormat.format(d));
                        outgoingJson.append("', '");
                        outgoingJson.append(monthDayFormat.format(d));
                        outgoingJson.append("', '");
                        String name = home.getJSONObject("team").getString("abbreviation");
                        outgoingJson.append("@").append(name);

//                    System.out.println("@" + home.getJSONObject("team").getString("locationName"));
                    } else {
                        if (teamLocation == null) {
                            teamLocation = home.getJSONObject("team").getString("locationName");
                            if (teamLocation.equals("MontrÃ©al")) {
                                teamLocation = "Montréal";
                            }
                            outgoingJson.append(teamLocation);
                            outgoingJson.append("',\n  teamName: '");
                            outgoingJson.append(home.getJSONObject("team").getString("teamName"));
                            outgoingJson.append("',\n  schedule: [\n");
                        }
                        outgoingJson.append("['");
                        outgoingJson.append(dayOfWeekFormat.format(d));
                        outgoingJson.append("', '");
                        outgoingJson.append(monthDayFormat.format(d));
                        outgoingJson.append("', '");
                        String name = away.getJSONObject("team").getString("abbreviation");
                        outgoingJson.append(name);

//                    System.out.println(away.getJSONObject("team").getString("locationName"));
                    }
                    outgoingJson.append("', '");
                    outgoingJson.append("12:34 pm");
                    outgoingJson.append("', ''],\n");
                }
            } catch (ParseException ex) {
                throw new RuntimeException(ex.getMessage());
            }
        }

        outgoingJson.append("[]\n  ]\n}");

//        System.out.println(outgoingJson.toString());
//
//        System.out.println("\n\n" + teamToIdMap.keySet().size());
//        for(String key: teamToIdMap.keySet()) {
//            System.out.println("nameToIdMap.put(\"" + key + "\", " + teamToIdMap.get(key) + ");");
//        }
    }

}
