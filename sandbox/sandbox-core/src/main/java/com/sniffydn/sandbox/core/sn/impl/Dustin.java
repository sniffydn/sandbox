package com.sniffydn.sandbox.core.sn.impl;

import com.sniffydn.sandbox.core.sn.impl.meout.MeOutfit1;
import com.sniffydn.sandbox.sentence.Noun;
import com.sniffydn.sandbox.sentence.Person;

public class Dustin {

    private Noun noun = new Noun("Dustin");
    private DustinOutfit outfit = new MeOutfit1();

    public Dustin() {
        noun.setPerson(Person.SECOND_SINGULAR);
    }

    /**
     * @return the outfit
     */
    public DustinOutfit getOutfit() {
        return outfit;
    }

    /**
     * @param outfit the outfit to set
     */
    public void setOutfit(DustinOutfit outfit) {
        this.outfit = outfit;
    }

    /**
     * @return the noun
     */
    public Noun getNoun() {
        return noun;
    }

}
