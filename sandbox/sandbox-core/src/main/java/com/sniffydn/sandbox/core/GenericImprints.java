package com.sniffydn.sandbox.core;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

public class GenericImprints {

    private String firstName = "Joseph \"Jo\"";
    private String lastName = "McRealtor";
    private String officeName = "Do It Best Realty Inc.";
    private String addressOne = "45612 Sycamore Lane";
    private String addressTwo = "Suite 200";
    private String city = "Litchfield";
    private String state = "MO";
    private String postalCode = "85442";
    private String logoImgLocation = "ML_remax7_b_highres.ai";
    private LogoImgPosition logoImgPosition = new LogoImgPosition();

    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return the officeName
     */
    public String getOfficeName() {
        return officeName;
    }

    /**
     * @param officeName the officeName to set
     */
    public void setOfficeName(String officeName) {
        this.officeName = officeName;
    }

    /**
     * @return the addressOne
     */
    public String getAddressOne() {
        return addressOne;
    }

    /**
     * @param addressOne the addressOne to set
     */
    public void setAddressOne(String addressOne) {
        this.addressOne = addressOne;
    }

    /**
     * @return the addressTwo
     */
    public String getAddressTwo() {
        return addressTwo;
    }

    /**
     * @param addressTwo the addressTwo to set
     */
    public void setAddressTwo(String addressTwo) {
        this.addressTwo = addressTwo;
    }

    /**
     * @return the city
     */
    public String getCity() {
        return city;
    }

    /**
     * @param city the city to set
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * @return the state
     */
    public String getState() {
        return state;
    }

    /**
     * @param state the state to set
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * @return the postalCode
     */
    public String getPostalCode() {
        return postalCode;
    }

    /**
     * @param postalCode the postalCode to set
     */
    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    /**
     * @return the logoImgLocation
     */
    public String getLogoImgLocation() {
        return logoImgLocation;
    }

    /**
     * @param logoImgLocation the logoImgLocation to set
     */
    public void setLogoImgLocation(String logoImgLocation) {
        this.logoImgLocation = logoImgLocation;
    }

    /**
     * @return the logoImgPosition
     */
    public LogoImgPosition getLogoImgPosition() {
        return logoImgPosition;
    }

    /**
     * @param logoImgPosition the logoImgPosition to set
     */
    public void setLogoImgPosition(LogoImgPosition logoImgPosition) {
        this.logoImgPosition = logoImgPosition;
    }

    /**
     * @param jsonAsString the jsonAsString to set
     */
    public void setJsonAsString(boolean jsonAsString) {
        this.jsonAsString = jsonAsString;
    }

    class LogoImgPosition {

        private int width = 1;
        private int height = 1;

        /**
         * @return the width
         */
        public int getWidth() {
            return width;
        }

        /**
         * @param width the width to set
         */
        public void setWidth(int width) {
            this.width = width;
        }

        /**
         * @return the height
         */
        public int getHeight() {
            return height;
        }

        /**
         * @param height the height to set
         */
        public void setHeight(int height) {
            this.height = height;
        }
    }

    public static void main(String[] args) {
        JSONObject json = new JSONObject("{\n"
                + "\"firstName\":\"Joseph\",\n"
                + "\"lastName\":\"McRealtor\",\n"
                + "\"officeName\":\"Do It Best Realty Inc.\",\n"
                + "\"addressOne\":\"45612 Sycamore Lane\",\n"
                + "\"addressTwo\":\"Suite 200\",\n"
                + "\"city\":\"Litchfield\",\n"
                + "\"state\":\"MO\",\n"
                + "\"postalCode\":\"85442\",\n"
                + "\"logoImgLocation\":\"ML_remax7_b_highres.ai\",\n"
                + "\"logoImgPosition\":\"{\\\"width\\\":1,\\\"height\\\":1}\"\n"
                + "}");

        System.out.println(json.toString(2));

        GenericImprints gi = new GenericImprints();

        System.out.println(gi.getJSON().toString(2));
    }

//    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(GenericImprints.class);
    private static final List<String> PRIMATIVE_DATA_TYPES = new ArrayList<>();
    private transient boolean jsonAsString = true;

    static {
        PRIMATIVE_DATA_TYPES.add("String");
        PRIMATIVE_DATA_TYPES.add("char");
        PRIMATIVE_DATA_TYPES.add("byte");
        PRIMATIVE_DATA_TYPES.add("short");
        PRIMATIVE_DATA_TYPES.add("long");
        PRIMATIVE_DATA_TYPES.add("int");
        PRIMATIVE_DATA_TYPES.add("double");
        PRIMATIVE_DATA_TYPES.add("float");
        PRIMATIVE_DATA_TYPES.add("boolean");
    }

    public JSONObject getJSON() {
        JSONObject obj = new JSONObject();
        updateJSON(obj, this);
        return obj;
    }

    private void updateJSON(JSONObject obj, Object o) {
        for (Field field : o.getClass().getDeclaredFields()) {
            if (Modifier.isTransient(field.getModifiers()) || Modifier.isStatic(field.getModifiers())) {
                continue;
            }
            String fieldName = field.getName();
            System.out.println("    " + field.getType().getSimpleName() + "  " + fieldName);
            if (PRIMATIVE_DATA_TYPES.contains(field.getType().getSimpleName())) {
                try {
                    Method getMethod = o.getClass().getMethod("get" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1));
                    obj.put(fieldName, getMethod.invoke(o, null));
                } catch (Exception ex) {
//            logger.error(fieldName, ex);
                    ex.printStackTrace();
                }
            } else {
                try {
                    JSONObject subObj = new JSONObject();
                    Method getMethod = o.getClass().getMethod("get" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1));
                    updateJSON(subObj, getMethod.invoke(o, null));

                    if (jsonAsString) {
                        obj.put(fieldName, subObj.toString());
                    } else {
                        obj.put(fieldName, subObj);
                    }
                } catch (Exception ex) {
//            logger.error(fieldName, ex);
                    System.out.println(fieldName);
                    ex.printStackTrace();
                }
            }

        }
    }
}
