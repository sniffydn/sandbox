package com.sniffydn.sandbox.core.sn.impl;

import com.sniffydn.sandbox.core.sn.Util;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Her {

    private static final Map<String, List<String>> COMMON_VERBS = new HashMap<>();

    static {
        for (String key : Util.COMMON_VERBS.keySet()) {
            List<String> tempList = new ArrayList<>(Util.COMMON_VERBS.get(key));
            getCOMMON_VERBS().put(key, tempList);
        }
    }

    /**
     * @return the COMMON_VERBS
     */
    public static Map<String, List<String>> getCOMMON_VERBS() {
        return COMMON_VERBS;
    }

    private HerOutfit outfit;

    /**
     * @return the outfit
     */
    public HerOutfit getOutfit() {
        return outfit;
    }

    /**
     * @param outfit the outfit to set
     */
    public void setOutfit(HerOutfit outfit) {
        this.outfit = outfit;
    }

    public String printOutfit(Me me) {
        return outfit.print(this, me);
    }

    public void print(Me me) {
        printOutfit(me);
    }
}
