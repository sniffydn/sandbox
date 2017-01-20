package com.sniffydn.sandbox.core;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author dnyffeler
 */
public class AgentDirectoryParser {

    private static final String TITLE = "<span class=\"agentTitle\">";
    private static final String H4 = "<h4>";
    private static final String CELL = "Cell #";
    private static final String OFFICE_NUM = "Office #";
    private static final String MAIL_TO = "href=\"mailto:";
    private static final String OFFICE = "<strong>Office</strong>";
    private static final String WEBSITE = "Visit My Website";
    private static final String HREF = "href=\"";

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        String response = "";
//        try {
//            System.out.println("name,office,title,officeNum,cellNum,email,website");
//
////            URL url = new URL("https://www.firstteam.com/agents.php");
////
////            parseResponse(readUrl(url));
////            for (int i = 2; i <= 90; i++) {
////                url = new URL("https://www.firstteam.com/agents.php?p=" + i);
////                parseResponse(readUrl(url));
////            }
//            URL url = new URL("https://api2.realtor.ca/individual.svc/IndividualSearch?RecordsPerPage=50&Page=2&SortBy=3&SortOrder=A&CurrentPage=2&CultureId=1&ApplicationId=1&Token=D6TmfZprLI9DXo9uooFJ+t99MOlYqORJRe2Eqz7F4Vg=&GUID=191badff-a44b-4cda-8f8c-e535ecef9f97&_=1484920571884");
//            response = readUrl(url);
//        } catch (Exception ex) {
//            Logger.getLogger(AgentDirectoryParser.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//        System.out.println(response);

        realtorCaSearch();
    }

    private static void realtorCaSearch() {

        try {
            for (int page = 51; page < 2488; page++) {
                List<Principal> principals = new ArrayList<>();
                URL url = new URL("https://api2.realtor.ca/individual.svc/IndividualSearch?RecordsPerPage=50&Page="
                        + page + "&SortBy=3&SortOrder=A&CurrentPage=" + page +
                        "&CultureId=1&ApplicationId=1&Token=D6TmfZprLI9DXo9uooFJ+t99MOlYqORJRe2Eqz7F4Vg=&GUID=191badff-a44b-4cda-8f8c-e535ecef9f97&_=1484920571884");
                String response = readUrl(url);

//            File f = new File("C:\\Users\\dnyffeler\\Documents\\NetBeansProjects\\sandbox\\sandbox\\sandbox-core\\src\\main\\java\\com\\sniffydn\\sandbox\\core\\temp.json");
//            FileReader fr = new FileReader(f);
//            BufferedReader br = new BufferedReader(fr);
//            // Process lines from file
//            String line;
//            StringBuilder response = new StringBuilder();
//            while ((line = br.readLine()) != null) {
//                response.append(line);
//            }
                JSONObject json = new JSONObject(response.toString());

                JSONObject errorCode = json.getJSONObject("ErrorCode");
                if (errorCode.getInt("Id") == 200) {
                    JSONArray results = json.getJSONArray("Results");
                    if (results.length() > 0) {
                        for (int i = 0; i < results.length(); i++) {
                            Principal p = new Principal();
                            JSONObject individual = results.getJSONObject(i);
                            try {
                                p.setName(individual.getString("Name"));
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                            try {
                                p.setTitle(individual.getString("Position"));
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                            JSONObject organization = individual.getJSONObject("Organization");
                            try {
                                p.setOffice(organization.getString("Name"));
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                            try {
                                JSONObject address = organization.getJSONObject("Address");
                                p.setAddress(address.getString("AddressText"));
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }

                            try {
                                StringBuilder phoneBuilder = new StringBuilder();
                                JSONArray phones = organization.getJSONArray("Phones");
                                for (int ph = 0; ph < phones.length(); ph++) {
                                    JSONObject phone = phones.getJSONObject(ph);
                                    phoneBuilder.append(phone.getString("AreaCode") + " " + phone.getString("PhoneNumber") + "(" + phone.getString("PhoneType") + ")");
                                }
                                p.setOfficeNum(phoneBuilder.toString());
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }

                            try {
                                StringBuilder websiteBuilder = new StringBuilder();
                                JSONArray websites = organization.getJSONArray("Websites");
                                for (int ph = 0; ph < websites.length(); ph++) {
                                    JSONObject website = websites.getJSONObject(ph);
                                    websiteBuilder.append(website.getString("Website") + "     ");
                                }
                                p.setWebsite(websiteBuilder.toString());

                            } catch (JSONException e) {
                                e.printStackTrace();
                            }

                            principals.add(p);
                        }
                    }
                } else {
                    Thread.sleep(1500);

                    System.out.println("\n\n\n\n\npage = " + page + "\n"+ json.toString(2));
                    break;
                }

                Thread.sleep(500);
                BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\TEMP\\agents.csv", true));
                for (Principal p : principals) {
                    bw.append(p.getName() + "," + p.getOffice() + "," + p.getTitle() + "," + p.getAddress() + "," + p.getOfficeNum() + "," + p.getWebsite());
                    bw.newLine();
                    System.out.println(p.getName() + "," + p.getOffice() + "," + p.getTitle() + "," + p.getAddress() + "," + p.getOfficeNum() + "," + p.getWebsite());
                }
                bw.flush();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private static void parseResponse(String response) {
        List<Principal> principals = new ArrayList<>();

        List<String> agents = splitString(response, "<article class=\"agent\">");
        for (String agent : agents) {
            Principal p = new Principal();
            int indexOfAgentHeader = agent.indexOf("<header class=\"agentHeader\">");
            if (indexOfAgentHeader != -1) {
                int indexOfH4 = agent.indexOf(H4, indexOfAgentHeader);
                p.setName(agent.substring(indexOfH4 + H4.length(), agent.indexOf("<", indexOfH4 + H4.length())));

                int indexOfTitle = agent.indexOf(TITLE, indexOfH4);
                if (indexOfTitle != -1) {
                    p.setTitle(agent.substring(indexOfTitle + TITLE.length(), agent.indexOf("<", indexOfTitle + TITLE.length())));
                }

                int indexOfOffice = agent.indexOf(OFFICE, indexOfH4);
                if (indexOfOffice != -1) {
                    p.setOffice(findTheNextPlainText(agent.substring(indexOfOffice + OFFICE.length(), agent.indexOf("<li class=", indexOfOffice + OFFICE.length()))));
                }

                int indexOfOfficeNum = agent.indexOf(OFFICE_NUM, indexOfH4);
                if (indexOfOfficeNum != -1) {
                    p.setOfficeNum(findTheNextPhoneNumber(agent.substring(indexOfOfficeNum, indexOfOfficeNum + 50)));
                }

                int indexOfCell = agent.indexOf(CELL, indexOfH4);
                if (indexOfCell != -1) {
                    p.setCellNum(findTheNextPhoneNumber(agent.substring(indexOfCell, indexOfCell + 50)));
                }

                int indexOfMailTo = agent.indexOf(MAIL_TO, indexOfH4);
                if (indexOfMailTo != -1) {
                    p.setEmail(decodeEmailAddress(agent.substring(indexOfMailTo + MAIL_TO.length(), agent.indexOf("\"", indexOfMailTo + MAIL_TO.length()))));
                }

                int indexOfWebsite = agent.indexOf(WEBSITE);
                if (indexOfWebsite != -1) {
                    int indexOfHref = agent.substring(0, indexOfWebsite).lastIndexOf(HREF);
                    p.setWebsite(agent.substring(indexOfHref + HREF.length(), agent.indexOf("\"", indexOfHref + HREF.length())));
                }

//                System.out.println(agent + "\n");
                principals.add(p);
            }
        }

        for (Principal p : principals) {
            System.out.println(p.getName() + "," + p.getOffice() + "," + p.getTitle() + "," + p.getOfficeNum() + "," + p.getCellNum() + "," + p.getEmail() + "," + p.getWebsite());
        }
    }

    public static String readUrl(URL url) throws IOException {
        StringBuilder result = new StringBuilder("");
        BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream(), "utf-8"));
        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            result.append(inputLine);
        }
        in.close();
        return result.toString();
    }

    public static List<String> splitString(String s, String delim) {
        List<String> retVal = new ArrayList<>();
        int indexOfSplit = s.indexOf(delim);
        while (indexOfSplit != -1) {
            retVal.add(s.substring(0, indexOfSplit));
            s = s.substring(indexOfSplit + delim.length());
            indexOfSplit = s.indexOf(delim);
        }

        retVal.add(s);

        return retVal;
    }

    private static String findTheNextPhoneNumber(String str) {
        Pattern pattern = Pattern.compile("\\d{3}-\\d{3}-\\d{4}");
        Matcher matcher = pattern.matcher(str);
        if (matcher.find()) {
            return matcher.group(0);
        }
        return "none found";
    }

    private static String decodeEmailAddress(String encodedEmail) {
        String retVal = "";
        StringTokenizer tok = new StringTokenizer(encodedEmail, "&");
        while (tok.hasMoreTokens()) {
            String s = tok.nextToken().substring(1);
            int i = new Integer(s);

            retVal += ((char) i);
        }
        return retVal;
    }

    private static String findTheNextPlainText(String htmlText) {
        // replace all occurrences of one or more HTML tags with optional
        // whitespace inbetween with a single space character
        String strippedText = htmlText.replaceAll("(?s)<[^>]*>(\\s*<[^>]*>)*", " ").trim();
        return strippedText;
    }

}

class Principal {

    private String name = "";
    private String title = "";
    private String office = "";
    private String officeNum = "";
    private String cellNum = "";
    private String email = "";
    private String website = "";
    private String address = "";

    /**
     * @return the name
     */
    public String getName() {
        return name.replaceAll(Pattern.quote(","), ";");
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the title
     */
    public String getTitle() {
        return title.replaceAll(Pattern.quote(","), ";");
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return the office
     */
    public String getOffice() {
        return office.replaceAll(Pattern.quote(","), ";");
    }

    /**
     * @param office the office to set
     */
    public void setOffice(String office) {
        this.office = office;
    }

    /**
     * @return the officeNum
     */
    public String getOfficeNum() {
        return officeNum.replaceAll(Pattern.quote(","), ";");
    }

    /**
     * @param officeNum the officeNum to set
     */
    public void setOfficeNum(String officeNum) {
        this.officeNum = officeNum;
    }

    /**
     * @return the cellNum
     */
    public String getCellNum() {
        return cellNum.replaceAll(Pattern.quote(","), ";");
    }

    /**
     * @param cellNum the cellNum to set
     */
    public void setCellNum(String cellNum) {
        this.cellNum = cellNum;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email.replaceAll(Pattern.quote(","), ";");
    }

    /**
     * @return the website
     */
    public String getWebsite() {
        return website.replaceAll(Pattern.quote(","), ";");
    }

    /**
     * @param website the website to set
     */
    public void setWebsite(String website) {
        this.website = website;
    }

    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }
}
