package com.sniffydn.sandbox.core.sn.impl;

import com.sniffydn.sandbox.core.sn.Item;
import com.sniffydn.sandbox.core.sn.Util;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Scene extends Item {

    private Her her;
    private Me me;
    protected String scene = "scene";

    /**
     * @return the her
     */
    public Her getHer() {
        return her;
    }

    /**
     * @param her the her to set
     */
    public void setHer(Her her) {
        this.her = her;
    }

    public String print() {
        String temp = scene.replaceAll(Pattern.quote("$herWearing#"), Matcher.quoteReplacement(getHer().printOutfit(getMe())));
        temp = temp.replaceAll(Pattern.quote("$meWearing#"), Matcher.quoteReplacement(getMe().printOutfit()));

        temp = temp.replaceAll(Pattern.quote("$meUd#"), Matcher.quoteReplacement(getMe().getOutfit().ud()));
        temp = temp.replaceAll(Pattern.quote("$meHud#"), Matcher.quoteReplacement(getMe().getOutfit().hud()));
        temp = temp.replace(Pattern.quote("$scene#"), Matcher.quoteReplacement(getDescription()));
        if (temp.contains("$scene#")) {
            temp = temp.replaceAll(Pattern.quote("$scene#"), Matcher.quoteReplacement(getDescription()));
        }

        temp = Util.globalReplace(temp);
        temp = temp.substring(0, 1).toUpperCase() + temp.substring(1);
        return temp;
    }

    /**
     * @return the me
     */
    public Me getMe() {
        return me;
    }

    /**
     * @param me the me to set
     */
    public void setMe(Me me) {
        this.me = me;
    }
}
