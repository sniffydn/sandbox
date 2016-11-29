package com.sniffydn.sandbox.core.sn.clts;

import java.util.ArrayList;
import java.util.List;

public class Bottoms extends CltsItem {

    private List<TopType> topTypeRestrictions = new ArrayList<>();

    /**
     * @return the topTypeRestrictions
     */
    public List<TopType> getTopTypeRestrictions() {
        return topTypeRestrictions;
    }
}
