package com.sniffydn.sandbox.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author dnyffeler
 */
public class AddressAnalyzer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        convertWordsToNumbers("SEVENTY THOUSAND NINE HUNDRED SIXTY SEVEN");
//        convertWordsToNumbers("SEVEN THOUSAND NINE HUNDRED SIXTY");
//        convertWordsToNumbers("SEVEN THOUSAND NINE HUNDRED EIGHT");
//        convertWordsToNumbers("SEVEN THOUSAND NINE");
//        convertWordsToNumbers("ONE THOUSAND");
//        convertWordsToNumbers("ONE HUNDRED");
//        convertWordsToNumbers("FIFTEEN THOUSAND TWELVE");

        // TODO code application logic here
        AddressRecord addressRecord1 = new AddressRecord();
        addressRecord1.setAddressId(1);
        addressRecord1.setAddressFirst("Dustin");
        addressRecord1.setAddressLast("Nyffeler");
        addressRecord1.setAddress1("SEVEN THOUSAND NINE HUNDRED SIXTY SEVEN Highland DR");
        addressRecord1.setAddressCity("Lino Lakes");
        addressRecord1.setAddressState("MN");
        addressRecord1.setAddressZip("55014");

        AddressRecord addressRecord2 = new AddressRecord();
        addressRecord2.setAddressId(2);
        addressRecord2.setAddressFirst("Dustin");
        addressRecord2.setAddressLast("Nyffeler");
        addressRecord2.setAddress1("7967 Highland");
        addressRecord2.setAddressCity("Lino Lakes");
        addressRecord2.setAddressState("MN");
        addressRecord2.setAddressZip("55014-1324");

        AddressRecord addressRecord3 = new AddressRecord();
        addressRecord3.setAddressId(3);
        addressRecord3.setAddressFirst("Kristen");
        addressRecord3.setAddressLast("Nyffeler");
        addressRecord3.setAddress1("7967 High land Drive");
        addressRecord3.setAddressCity("Lino Lakes");
        addressRecord3.setAddressState("MN");
        addressRecord3.setAddressZip("55014");

        AddressRecord addressRecord4 = new AddressRecord();
        addressRecord4.setAddressId(4);
        addressRecord4.setAddressFirst("Kristen");
        addressRecord4.setAddressLast("Nyfler");
        addressRecord4.setAddress1("7967 Highland Dr.");
        addressRecord4.setAddressCity("St. Paul");
        addressRecord4.setAddressState("MN");
        addressRecord4.setAddressZip("55104-0000");

        List<AddressRecord> addressList = new ArrayList<>();
        addressList.add(addressRecord1);
        addressList.add(addressRecord2);
        addressList.add(addressRecord3);
        addressList.add(addressRecord4);

        analyzeAddressList(addressList);

        for (AddressRecord rec : addressList) {
            System.out.println(rec.getAddressId() + " \tScore:" + rec.getSimilarScore() + " \t with:" + rec.getSimilarToAddressId());
        }
    }

    private static final Map<String, String> STANDARDIZATION_MAP = new HashMap<>();
    private static final Map<String, String> NUMBER_STANDARDIZATION_MAP = new HashMap<>();
    private static final Map<String, String> BASE_DIGIT_NUMBER_STANDARDIZATION_MAP = new HashMap<>();

    static {
        STANDARDIZATION_MAP.put("ALLEY", "ALY");
        STANDARDIZATION_MAP.put("ANEX", "ANX");
        STANDARDIZATION_MAP.put("ARCADE", "ARC");
        STANDARDIZATION_MAP.put("AVENUE", "AVE");
        STANDARDIZATION_MAP.put("BAYOU", "BYU");
        STANDARDIZATION_MAP.put("BEACH", "BCH");
        STANDARDIZATION_MAP.put("BEND", "BND");
        STANDARDIZATION_MAP.put("BLUFF", "BLF");
        STANDARDIZATION_MAP.put("BLUFFS", "BLFS");
        STANDARDIZATION_MAP.put("BOTTOM", "BTM");
        STANDARDIZATION_MAP.put("BOULEVARD", "BLVD");
        STANDARDIZATION_MAP.put("BRANCH", "BR");
        STANDARDIZATION_MAP.put("BRIDGE", "BRG");
        STANDARDIZATION_MAP.put("BROOK", "BRK");
        STANDARDIZATION_MAP.put("BROOKS", "BRKS");
        STANDARDIZATION_MAP.put("BURG", "BG");
        STANDARDIZATION_MAP.put("BURGS", "BGS");
        STANDARDIZATION_MAP.put("BYPASS", "BYP");
        STANDARDIZATION_MAP.put("CAMP", "CP");
        STANDARDIZATION_MAP.put("CANYON", "CYN");
        STANDARDIZATION_MAP.put("CAPE", "CPE");
        STANDARDIZATION_MAP.put("CAUSEWAY", "CSWY");
        STANDARDIZATION_MAP.put("CENTER", "CTR");
        STANDARDIZATION_MAP.put("CENTERS", "CTRS");
        STANDARDIZATION_MAP.put("CIRCLE", "CIR");
        STANDARDIZATION_MAP.put("CIRCLES", "CIRS");
        STANDARDIZATION_MAP.put("CLIFF", "CLF");
        STANDARDIZATION_MAP.put("CLIFFS", "CLFS");
        STANDARDIZATION_MAP.put("CLUB", "CLB");
        STANDARDIZATION_MAP.put("COMMON", "CMN");
        STANDARDIZATION_MAP.put("COMMONS", "CMNS");
        STANDARDIZATION_MAP.put("CORNER", "COR");
        STANDARDIZATION_MAP.put("CORNERS", "CORS");
        STANDARDIZATION_MAP.put("COURSE", "CRSE");
        STANDARDIZATION_MAP.put("COURT", "CT");
        STANDARDIZATION_MAP.put("COURTS", "CTS");
        STANDARDIZATION_MAP.put("COVE", "CV");
        STANDARDIZATION_MAP.put("COVES", "CVS");
        STANDARDIZATION_MAP.put("CREEK", "CRK");
        STANDARDIZATION_MAP.put("CRESCENT", "CRES");
        STANDARDIZATION_MAP.put("CREST", "CRST");
        STANDARDIZATION_MAP.put("CROSSING", "XING");
        STANDARDIZATION_MAP.put("CROSSROAD", "XRD");
        STANDARDIZATION_MAP.put("CROSSROADS", "XRDS");
        STANDARDIZATION_MAP.put("CURVE", "CURV");
        STANDARDIZATION_MAP.put("DALE", "DL");
        STANDARDIZATION_MAP.put("DAM", "DM");
        STANDARDIZATION_MAP.put("DIVIDE", "DV");
        STANDARDIZATION_MAP.put("DRIVE", "DR");
        STANDARDIZATION_MAP.put("DRIVES", "DRS");
        STANDARDIZATION_MAP.put("ESTATE", "EST");
        STANDARDIZATION_MAP.put("ESTATES", "ESTS");
        STANDARDIZATION_MAP.put("EXPRESSWAY", "EXPY");
        STANDARDIZATION_MAP.put("EXTENSION", "EXT");
        STANDARDIZATION_MAP.put("EXTENSIONS", "EXTS");
        STANDARDIZATION_MAP.put("FALL", "FALL");
        STANDARDIZATION_MAP.put("FALLS", "FLS");
        STANDARDIZATION_MAP.put("FERRY", "FRY");
        STANDARDIZATION_MAP.put("FIELD", "FLD");
        STANDARDIZATION_MAP.put("FIELDS", "FLDS");
        STANDARDIZATION_MAP.put("FLAT", "FLT");
        STANDARDIZATION_MAP.put("FLATS", "FLTS");
        STANDARDIZATION_MAP.put("FORD", "FRD");
        STANDARDIZATION_MAP.put("FORDS", "FRDS");
        STANDARDIZATION_MAP.put("FOREST", "FRST");
        STANDARDIZATION_MAP.put("FORGE", "FRG");
        STANDARDIZATION_MAP.put("FORGES", "FRGS");
        STANDARDIZATION_MAP.put("FORK", "FRK");
        STANDARDIZATION_MAP.put("FORKS", "FRKS");
        STANDARDIZATION_MAP.put("FORT", "FT");
        STANDARDIZATION_MAP.put("FREEWAY", "FWY");
        STANDARDIZATION_MAP.put("GARDEN", "GDN");
        STANDARDIZATION_MAP.put("GARDENS", "GDNS");
        STANDARDIZATION_MAP.put("GATEWAY", "GTWY");
        STANDARDIZATION_MAP.put("GLEN", "GLN");
        STANDARDIZATION_MAP.put("GLENS", "GLNS");
        STANDARDIZATION_MAP.put("GREEN", "GRN");
        STANDARDIZATION_MAP.put("GREENS", "GRNS");
        STANDARDIZATION_MAP.put("GROVE", "GRV");
        STANDARDIZATION_MAP.put("GROVES", "GRVS");
        STANDARDIZATION_MAP.put("HARBOR", "HBR");
        STANDARDIZATION_MAP.put("HARBORS", "HBRS");
        STANDARDIZATION_MAP.put("HAVEN", "HVN");
        STANDARDIZATION_MAP.put("HEIGHTS", "HTS");
        STANDARDIZATION_MAP.put("HIGHWAY", "HWY");
        STANDARDIZATION_MAP.put("HILL", "HL");
        STANDARDIZATION_MAP.put("HILLS", "HLS");
        STANDARDIZATION_MAP.put("HOLLOW", "HOLW");
        STANDARDIZATION_MAP.put("INLET", "INLT");
        STANDARDIZATION_MAP.put("ISLAND", "IS");
        STANDARDIZATION_MAP.put("ISLANDS", "ISS");
        STANDARDIZATION_MAP.put("ISLE", "ISLE");
        STANDARDIZATION_MAP.put("JUNCTION", "JCT");
        STANDARDIZATION_MAP.put("JUNCTIONS", "JCTS");
        STANDARDIZATION_MAP.put("KEY", "KY");
        STANDARDIZATION_MAP.put("KEYS", "KYS");
        STANDARDIZATION_MAP.put("KNOLL", "KNL");
        STANDARDIZATION_MAP.put("KNOLLS", "KNLS");
        STANDARDIZATION_MAP.put("LAKE", "LK");
        STANDARDIZATION_MAP.put("LAKES", "LKS");
        STANDARDIZATION_MAP.put("LAND", "LAND");
        STANDARDIZATION_MAP.put("LANDING", "LNDG");
        STANDARDIZATION_MAP.put("LANE", "LN");
        STANDARDIZATION_MAP.put("LIGHT", "LGT");
        STANDARDIZATION_MAP.put("LIGHTS", "LGTS");
        STANDARDIZATION_MAP.put("LOAF", "LF");
        STANDARDIZATION_MAP.put("LOCK", "LCK");
        STANDARDIZATION_MAP.put("LOCKS", "LCKS");
        STANDARDIZATION_MAP.put("LODGE", "LDG");
        STANDARDIZATION_MAP.put("LOOP", "LOOP");
        STANDARDIZATION_MAP.put("MALL", "MALL");
        STANDARDIZATION_MAP.put("MANOR", "MNR");
        STANDARDIZATION_MAP.put("MANORS", "MNRS");
        STANDARDIZATION_MAP.put("MEADOW", "MDW");
        STANDARDIZATION_MAP.put("MEADOWS", "MDWS");
        STANDARDIZATION_MAP.put("MEWS", "MEWS");
        STANDARDIZATION_MAP.put("MILL", "ML");
        STANDARDIZATION_MAP.put("MILLS", "MLS");
        STANDARDIZATION_MAP.put("MISSION", "MSN");
        STANDARDIZATION_MAP.put("MOTORWAY", "MTWY");
        STANDARDIZATION_MAP.put("MOUNT", "MT");
        STANDARDIZATION_MAP.put("MOUNTAIN", "MTN");
        STANDARDIZATION_MAP.put("MOUNTAINS", "MTNS");
        STANDARDIZATION_MAP.put("NECK", "NCK");
        STANDARDIZATION_MAP.put("ORCHARD", "ORCH");
        STANDARDIZATION_MAP.put("OVAL", "OVAL");
        STANDARDIZATION_MAP.put("OVERPASS", "OPAS");
        STANDARDIZATION_MAP.put("PARK", "PARK");
        STANDARDIZATION_MAP.put("PARKS", "PARK");
        STANDARDIZATION_MAP.put("PARKWAY", "PKWY");
        STANDARDIZATION_MAP.put("PARKWAYS", "PKWY");
        STANDARDIZATION_MAP.put("PASS", "PASS");
        STANDARDIZATION_MAP.put("PASSAGE", "PSGE");
        STANDARDIZATION_MAP.put("PATH", "PATH");
        STANDARDIZATION_MAP.put("PIKE", "PIKE");
        STANDARDIZATION_MAP.put("PINE", "PNE");
        STANDARDIZATION_MAP.put("PINES", "PNES");
        STANDARDIZATION_MAP.put("PLACE", "PL");
        STANDARDIZATION_MAP.put("PLAIN", "PLN");
        STANDARDIZATION_MAP.put("PLAINS", "PLNS");
        STANDARDIZATION_MAP.put("PLAZA", "PLZ");
        STANDARDIZATION_MAP.put("POINT", "PT");
        STANDARDIZATION_MAP.put("POINTS", "PTS");
        STANDARDIZATION_MAP.put("PORT", "PRT");
        STANDARDIZATION_MAP.put("PORTS", "PRTS");
        STANDARDIZATION_MAP.put("PRAIRIE", "PR");
        STANDARDIZATION_MAP.put("RADIAL", "RADL");
        STANDARDIZATION_MAP.put("RAMP", "RAMP");
        STANDARDIZATION_MAP.put("RANCH", "RNCH");
        STANDARDIZATION_MAP.put("RAPID", "RPD");
        STANDARDIZATION_MAP.put("RAPIDS", "RPDS");
        STANDARDIZATION_MAP.put("REST", "RST");
        STANDARDIZATION_MAP.put("RIDGE", "RDG");
        STANDARDIZATION_MAP.put("RIDGES", "RDGS");
        STANDARDIZATION_MAP.put("RIVER", "RIV");
        STANDARDIZATION_MAP.put("ROAD", "RD");
        STANDARDIZATION_MAP.put("ROADS", "RDS");
        STANDARDIZATION_MAP.put("ROUTE", "RTE");
        STANDARDIZATION_MAP.put("ROW", "ROW");
        STANDARDIZATION_MAP.put("RUE", "RUE");
        STANDARDIZATION_MAP.put("RUN", "RUN");
        STANDARDIZATION_MAP.put("SHOAL", "SHL");
        STANDARDIZATION_MAP.put("SHOALS", "SHLS");
        STANDARDIZATION_MAP.put("SHORE", "SHR");
        STANDARDIZATION_MAP.put("SHORES", "SHRS");
        STANDARDIZATION_MAP.put("SKYWAY", "SKWY");
        STANDARDIZATION_MAP.put("SPRING", "SPG");
        STANDARDIZATION_MAP.put("SPRINGS", "SPGS");
        STANDARDIZATION_MAP.put("SPUR", "SPUR");
        STANDARDIZATION_MAP.put("SPURS", "SPUR");
        STANDARDIZATION_MAP.put("SQUARE", "SQ");
        STANDARDIZATION_MAP.put("SQUARES", "SQS");
        STANDARDIZATION_MAP.put("STATION", "STA");
        STANDARDIZATION_MAP.put("STRAVENUE", "STRA");
        STANDARDIZATION_MAP.put("STREAM", "STRM");
        STANDARDIZATION_MAP.put("STREET", "ST");
        STANDARDIZATION_MAP.put("STREETS", "STS");
        STANDARDIZATION_MAP.put("SUMMIT", "SMT");
        STANDARDIZATION_MAP.put("TERRACE", "TER");
        STANDARDIZATION_MAP.put("THROUGHWAY", "TRWY");
        STANDARDIZATION_MAP.put("TRACE", "TRCE");
        STANDARDIZATION_MAP.put("TRACK", "TRAK");
        STANDARDIZATION_MAP.put("TRAFFICWAY", "TRFY");
        STANDARDIZATION_MAP.put("TRAIL", "TRL");
        STANDARDIZATION_MAP.put("TRAILER", "TRLR");
        STANDARDIZATION_MAP.put("TUNNEL", "TUNL");
        STANDARDIZATION_MAP.put("TURNPIKE", "TPKE");
        STANDARDIZATION_MAP.put("UNDERPASS", "UPAS");
        STANDARDIZATION_MAP.put("UNION", "UN");
        STANDARDIZATION_MAP.put("UNIONS", "UNS");
        STANDARDIZATION_MAP.put("VALLEY", "VLY");
        STANDARDIZATION_MAP.put("VALLEYS", "VLYS");
        STANDARDIZATION_MAP.put("VIADUCT", "VIA");
        STANDARDIZATION_MAP.put("VIEW", "VW");
        STANDARDIZATION_MAP.put("VIEWS", "VWS");
        STANDARDIZATION_MAP.put("VILLAGE", "VLG");
        STANDARDIZATION_MAP.put("VILLAGES", "VLGS");
        STANDARDIZATION_MAP.put("VILLE", "VL");
        STANDARDIZATION_MAP.put("VISTA", "VIS");
        STANDARDIZATION_MAP.put("WALK", "WALK");
        STANDARDIZATION_MAP.put("WALKS", "WALK");
        STANDARDIZATION_MAP.put("WALL", "WALL");
        STANDARDIZATION_MAP.put("WAY", "WAY");
        STANDARDIZATION_MAP.put("WAYS", "WAYS");
        STANDARDIZATION_MAP.put("WELL", "WL");
        STANDARDIZATION_MAP.put("WELLS", "WLS");
        STANDARDIZATION_MAP.put("APARTMENT", "APT");
        STANDARDIZATION_MAP.put("BUILDING", "BLDG");
        STANDARDIZATION_MAP.put("DEPARTMENT", "DEPT");
        STANDARDIZATION_MAP.put("SUITE", "STE");

        STANDARDIZATION_MAP.put("NORTH", "N");
        STANDARDIZATION_MAP.put("SOUTH", "S");
        STANDARDIZATION_MAP.put("EAST", "E");
        STANDARDIZATION_MAP.put("WEST", "W");

        STANDARDIZATION_MAP.put("NORTHEAST", "NE");
        STANDARDIZATION_MAP.put("NORTHWEST", "NW");
        STANDARDIZATION_MAP.put("SOUTHEAST", "SE");
        STANDARDIZATION_MAP.put("SOUTHWEST", "SW");

        STANDARDIZATION_MAP.put("FIRST", "1ST");
        STANDARDIZATION_MAP.put("SECOND", "2ND");
        STANDARDIZATION_MAP.put("THIRD", "3RD");
        STANDARDIZATION_MAP.put("FIFTH", "5TH");
        STANDARDIZATION_MAP.put("EIGHTH", "8TH");
        STANDARDIZATION_MAP.put("NINTH", "9TH");
        STANDARDIZATION_MAP.put("TWELFTH", "12TH");
        STANDARDIZATION_MAP.put("TWENTIETH", "20TH");
        STANDARDIZATION_MAP.put("THIRTIETH", "30TH");
        STANDARDIZATION_MAP.put("FORTIETH", "40TH");
        STANDARDIZATION_MAP.put("FIFTIETH", "50TH");
        STANDARDIZATION_MAP.put("SIXTIETH", "60TH");
        STANDARDIZATION_MAP.put("SEVENTIETH", "70TH");
        STANDARDIZATION_MAP.put("EIGHTIETH", "80TH");
        STANDARDIZATION_MAP.put("NINETIETH", "90TH");

        STANDARDIZATION_MAP.put("ZERO", "0");
    }

    private static void analyzeAddressList(List<AddressRecord> addressList) {
        for (int i = 0; i < addressList.size(); i++) {
            AddressRecord first = addressList.get(i);
            for (int j = i + 1; j < addressList.size(); j++) {
                AddressRecord second = addressList.get(j);
                analyzeAddresses(first, second);
            }
        }
    }

    private static void analyzeAddresses(AddressRecord first, AddressRecord second) {
        int similarScore = 0;

        similarScore += analyzeState(first.getAddressState(), second.getAddressState());
        similarScore += analyzeZip(first.getAddressZip(), second.getAddressZip());
        similarScore += analyzeCity(first.getAddressCity(), second.getAddressCity());

        if (similarScore > 15) {
            similarScore += analyzeAddress1(first.getAddress1(), second.getAddress1());
        }

        if (first.getSimilarScore() < similarScore) {
            first.setSimilarScore(similarScore);
            first.setSimilarToAddressId(second.getAddressId());
        }
        if (second.getSimilarScore() < similarScore) {
            second.setSimilarScore(similarScore);
            second.setSimilarToAddressId(first.getAddressId());
        }

    }

    private static int analyzeState(String state, String state2) {
        if (state.equals(state2)) {
            return 10;
        }
        return 0;
    }

    private static int analyzeZip(String zip, String zip2) {
        int similarScore = 0;
        zip = zip.trim().toUpperCase().replaceAll(Pattern.quote(" "), "");
        zip2 = zip2.trim().toUpperCase().replaceAll(Pattern.quote(" "), "");

        try {
            while (zip.charAt(similarScore) == zip2.charAt(similarScore)) {
                similarScore++;
            }
        } catch (Exception e) {
        }

        return similarScore;
    }

    private static int analyzeCity(String city, String city2) {
        if (city.equals(city2)) {
            return 5;
        }
        return 0;
    }

    private static int analyzeAddress1(String address, String address2) {
        address = normalizeAddress1(address);
        address2 = normalizeAddress1(address2);

        if (address.equals(address2)) {
            return 5;
        }
        return 0;
    }

    private static String normalizeAddress1(String address) {
        address = address.trim().toUpperCase().replaceAll(Pattern.quote("  "), " ");

        System.out.println(address);
        address = findAndConvertWordsToNumbers(address);

        for (String key : STANDARDIZATION_MAP.keySet()) {
            if (address.contains(key)) {
                address = address.replaceAll("\\b" + key + "\\b", STANDARDIZATION_MAP.get(key));
            }
        }

        System.out.println("  -" + address);
        return address;
    }

    private static List<String> DIGITS = new ArrayList<>();
    private static List<String> TEENS = new ArrayList<>();
    private static List<String> TENS = new ArrayList<>();
    private static List<String> MAGNITUDE = new ArrayList<>();

    static {
        DIGITS.add("ONE");
        DIGITS.add("TWO");
        DIGITS.add("THREE");
        DIGITS.add("FOUR");
        DIGITS.add("FIVE");
        DIGITS.add("SIX");
        DIGITS.add("SEVEN");
        DIGITS.add("EIGHT");
        DIGITS.add("NINE");

        DIGITS.add("TEN");
        DIGITS.add("ELEVEN");
        DIGITS.add("TWELVE");
        DIGITS.add("THIRTEEN");
        DIGITS.add("FOURTEEN");
        DIGITS.add("FIFTEEN");
        DIGITS.add("SIXTEEN");
        DIGITS.add("SEVENTEEN");
        DIGITS.add("EIGHTEEN");
        DIGITS.add("NINETEEN");

        TENS.add("TWENTY");
        TENS.add("THIRTY");
        TENS.add("FORTY");
        TENS.add("FIFTY");
        TENS.add("SIXTY");
        TENS.add("SEVENTY");
        TENS.add("EIGHTY");
        TENS.add("NINETY");

        MAGNITUDE.add("HUNDRED");
        MAGNITUDE.add("THOUSAND");

    }

    private static String findAndConvertWordsToNumbers(String s) {
        StringBuilder regexBuilder = new StringBuilder("\\b(");

        boolean first = true;

        for (int i = 0; i < TENS.size(); i++) {
            if (first) {
                first = false;
            } else {
                regexBuilder.append("|");
            }
            regexBuilder.append(TENS.get(i));
        }

        for (int i = 0; i < DIGITS.size(); i++) {
            regexBuilder.append("|");
            regexBuilder.append(DIGITS.get(i));
        }

        for (int i = 0; i < TEENS.size(); i++) {
            regexBuilder.append("|");
            regexBuilder.append(TEENS.get(i));
        }

        for (int i = 0; i < MAGNITUDE.size(); i++) {
            regexBuilder.append("|");
            regexBuilder.append(MAGNITUDE.get(i));
        }
        regexBuilder.append("| )+");

        Pattern pattern = Pattern.compile(regexBuilder.toString());
        Matcher matcher = pattern.matcher(s);

        List<String> matches = new ArrayList<>();

        while (matcher.find()) {
            int start = matcher.start();
            int end = matcher.end();
            if (start == end) {
                break;
            }

            try {
                String sub = s.substring(start, end);
                if (sub.trim().length() != 0) {
                    matches.add(sub);

                }
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Error with s:" + s);
            }
        }

        for (String match : matches) {
            System.out.println("        " + match);
            String conversion = convertWordsToNumbers(match);
            s = s.replaceAll(Pattern.quote(match), conversion);
            System.out.println("        s:" + s);
        }

        return s;
    }

    private static String convertWordsToNumbers(String wordsThatAreNumbers) {
        String conversion = wordsThatAreNumbers;
        for (int i = 0; i < DIGITS.size(); i++) {
            conversion = conversion.replaceAll("\\b" + DIGITS.get(i) + "\\b", "" + (i + 1));
        }

        for (int i = 0; i < TENS.size(); i++) {
            int index = conversion.indexOf(TENS.get(i));
            while (index != -1) {
                conversion = conversion.replaceFirst("\\b" + TENS.get(i) + "\\b", "" + (i + 2));

                try {
                    int checkChar = conversion.charAt(index + 2);

                    if (checkChar < '0' || checkChar > '9') {
                        conversion = conversion.substring(0, index + 1) + "0" + conversion.substring(index + 1);
                    } else {
                        conversion = conversion.substring(0, index + 1) + conversion.substring(index + 2);
                    }
                } catch (Exception e) {
                    conversion += "0";
                }

                index = conversion.indexOf(TENS.get(i));
            }
        }
        conversion = conversion.replaceAll("\\s", "");

        int index = conversion.indexOf("HUNDRED");
        while (index != -1) {
            try {
                conversion = conversion.replaceFirst(Pattern.quote("HUNDRED"), "");
                String sub = conversion.substring(index);
                String subReplace = sub;
                System.out.println("    sub:" + sub);
                while(subReplace.length() < 2) {
                    subReplace = 0 + subReplace;
                }
                conversion = conversion.substring(0, index) + subReplace + conversion.substring(index + sub.length());
                
            } catch (Exception e) {
                conversion += "00";
            }

            index = conversion.indexOf("HUNDRED");
        }

        index = conversion.indexOf("THOUSAND");
        while (index != -1) {
            try {
                conversion = conversion.replaceFirst(Pattern.quote("THOUSAND"), "");
                String sub = conversion.substring(index);
                String subReplace = sub;
                System.out.println("    sub:" + sub);
                while(subReplace.length() < 3) {
                    subReplace = 0 + subReplace;
                }
                conversion = conversion.substring(0, index) + subReplace + conversion.substring(index + sub.length());

            } catch (Exception e) {
                conversion += "000";
            }

            index = conversion.indexOf("THOUSAND");
        }

        if(wordsThatAreNumbers.charAt(wordsThatAreNumbers.length() - 1) == ' ') {
            conversion = conversion + " ";
        }
        if(wordsThatAreNumbers.charAt(0) == ' ') {
            conversion = " " + conversion;
        }

        return conversion;
    }

}

class AddressRecord {

    private Integer similarScore = 0;
    private Integer similarToAddressId = -1;

    private Integer addressId;
    private Integer customerId;
    private String addressFirst;
    private String addressLast;
    private String addressCompany;
    private String address1;
    private String address2;
    private String addressCity;
    private String addressState;
    private String addressZip;
    private String addressCountry;
    private String addressType;
    private Boolean addressInvalid;
    private Boolean addressMarketing;
    private Boolean addressPrimary;
    private String addressEmail;
    private String addressPhone1;
    private String addressPhone2;
    private String addressFax;
    private Boolean addressResidential;
    private java.util.Date addressDateAdded;
    private java.util.Date addressDateModified;
    private String addressFullname;
    private Integer addressVerified;
    private Boolean addressDisable;
    private Boolean addressDonotemail;

    public void setAddressId(Integer addressId) {
        Integer oldAddressId = this.addressId;
        this.addressId = addressId;
    }

    public Integer getAddressId() {
        return addressId;
    }

    public void setCustomerId(Integer customerId) {
        Integer oldCustomerId = this.customerId;
        this.customerId = customerId;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setAddressFirst(String addressFirst) {
        String oldAddressFirst = this.addressFirst;
        this.addressFirst = addressFirst;
    }

    public String getAddressFirst() {
        return addressFirst;
    }

    public void setAddressLast(String addressLast) {
        String oldAddressLast = this.addressLast;
        this.addressLast = addressLast;
    }

    public String getAddressLast() {
        return addressLast;
    }

    public void setAddressCompany(String addressCompany) {
        String oldAddressCompany = this.addressCompany;
        this.addressCompany = addressCompany;
    }

    public String getAddressCompany() {
        return addressCompany;
    }

    public void setAddress1(String address1) {
        String oldAddress1 = this.address1;
        this.address1 = address1;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress2(String address2) {
        String oldAddress2 = this.address2;
        this.address2 = address2;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddressCity(String addressCity) {
        String oldAddressCity = this.addressCity;
        this.addressCity = addressCity;
    }

    public String getAddressCity() {
        return addressCity;
    }

    public void setAddressState(String addressState) {
        String oldAddressState = this.addressState;
        this.addressState = addressState;
    }

    public String getAddressState() {
        return addressState;
    }

    public void setAddressZip(String addressZip) {
        String oldAddressZip = this.addressZip;
        this.addressZip = addressZip;
    }

    public String getAddressZip() {
        return addressZip;
    }

    public void setAddressCountry(String addressCountry) {
        String oldAddressCountry = this.addressCountry;
        this.addressCountry = addressCountry;
    }

    public String getAddressCountry() {
        return addressCountry;
    }

    public void setAddressType(String addressType) {
        String oldAddressType = this.addressType;
        this.addressType = addressType;
    }

    public String getAddressType() {
        return addressType;
    }

    public void setAddressInvalid(Boolean addressInvalid) {
        Boolean oldAddressInvalid = this.addressInvalid;
        this.addressInvalid = addressInvalid;
    }

    public Boolean getAddressInvalid() {
        return addressInvalid;
    }

    public void setAddressMarketing(Boolean addressMarketing) {
        Boolean oldAddressMarketing = this.addressMarketing;
        this.addressMarketing = addressMarketing;
    }

    public Boolean getAddressMarketing() {
        return addressMarketing;
    }

    public void setAddressPrimary(Boolean addressPrimary) {
        Boolean oldAddressPrimary = this.addressPrimary;
        this.addressPrimary = addressPrimary;
    }

    public Boolean getAddressPrimary() {
        return addressPrimary;
    }

    public void setAddressEmail(String addressEmail) {
        String oldAddressEmail = this.addressEmail;
        this.addressEmail = addressEmail;
    }

    public String getAddressEmail() {
        return addressEmail;
    }

    public void setAddressPhone1(String addressPhone1) {
        String oldAddressPhone1 = this.addressPhone1;
        this.addressPhone1 = addressPhone1;
    }

    public String getAddressPhone1() {
        return addressPhone1;
    }

    public void setAddressPhone2(String addressPhone2) {
        String oldAddressPhone2 = this.addressPhone2;
        this.addressPhone2 = addressPhone2;
    }

    public String getAddressPhone2() {
        return addressPhone2;
    }

    public void setAddressFax(String addressFax) {
        String oldAddressFax = this.addressFax;
        this.addressFax = addressFax;
    }

    public String getAddressFax() {
        return addressFax;
    }

    public void setAddressResidential(Boolean addressResidential) {
        Boolean oldAddressResidential = this.addressResidential;
        this.addressResidential = addressResidential;
    }

    public Boolean getAddressResidential() {
        return addressResidential;
    }

    public void setAddressDateAdded(java.util.Date addressDateAdded) {
        java.util.Date oldAddressDateAdded = this.addressDateAdded;
        this.addressDateAdded = addressDateAdded;
    }

    public java.util.Date getAddressDateAdded() {
        return addressDateAdded;
    }

    public void setAddressDateModified(java.util.Date addressDateModified) {
        java.util.Date oldAddressDateModified = this.addressDateModified;
        this.addressDateModified = addressDateModified;
    }

    public java.util.Date getAddressDateModified() {
        return addressDateModified;
    }

    public void setAddressFullname(String addressFullname) {
        String oldAddressFullname = this.addressFullname;
        this.addressFullname = addressFullname;
    }

    public String getAddressFullname() {
        return addressFullname;
    }

    public void setAddressVerified(Integer addressVerified) {
        Integer oldAddressVerified = this.addressVerified;
        this.addressVerified = addressVerified;
    }

    public Integer getAddressVerified() {
        return addressVerified;
    }

    public void setAddressDisable(Boolean addressDisable) {
        Boolean oldAddressDisable = this.addressDisable;
        this.addressDisable = addressDisable;
    }

    public Boolean getAddressDisable() {
        return addressDisable;
    }

    public void setAddressDonotemail(Boolean addressDonotemail) {
        Boolean oldAddressDonotemail = this.addressDonotemail;
        this.addressDonotemail = addressDonotemail;
    }

    public Boolean getAddressDonotemail() {
        return addressDonotemail;
    }

    private String addressTitle;

    public String getAddressTitle() {
        return addressTitle;
    }

    public void setAddressTitle(String addressTitle) {
        String old = this.addressTitle;
        this.addressTitle = addressTitle;
    }

    public String toString() {
        return addressFirst + " " + addressLast + " " + addressCompany + " " + address1 + " " + address2 + " " + addressCity + " " + addressState + " " + addressZip;
    }

    /**
     * @return the similarScore
     */
    public Integer getSimilarScore() {
        return similarScore;
    }

    /**
     * @param similarScore the similarScore to set
     */
    public void setSimilarScore(Integer similarScore) {
        this.similarScore = similarScore;
    }

    /**
     * @return the similarToAddressId
     */
    public Integer getSimilarToAddressId() {
        return similarToAddressId;
    }

    /**
     * @param similarToAddressId the similarToAddressId to set
     */
    public void setSimilarToAddressId(Integer similarToAddressId) {
        this.similarToAddressId = similarToAddressId;
    }
}
