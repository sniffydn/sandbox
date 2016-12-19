package com.sniffydn.sandbox.core.sn.clts;

import com.sniffydn.sandbox.sentence.Noun;
import java.util.ArrayList;
import java.util.List;

public class Bottoms extends CltsItem {

    private List<TopType> topTypeRestrictions = new ArrayList<>();

    public Bottoms(Noun wearer) {
        super(wearer);
    }

    /**
     * @return the topTypeRestrictions
     */
    public List<TopType> getTopTypeRestrictions() {
        return topTypeRestrictions;
    }
}
