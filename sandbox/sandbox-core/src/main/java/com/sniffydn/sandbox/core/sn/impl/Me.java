package com.sniffydn.sandbox.core.sn.impl;

import com.sniffydn.sandbox.core.sn.Util;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Me {

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
    private MeOutfit outfit;

    public void print() {
        System.out.print("He is wearing ");
    }

    public String printOutfit() {
        return getOutfit().print();
    }

    /**
     * @return the outfit
     */
    public MeOutfit getOutfit() {
        return outfit;
    }

    /**
     * @param outfit the outfit to set
     */
    public void setOutfit(MeOutfit outfit) {
        this.outfit = outfit;
    }

}
