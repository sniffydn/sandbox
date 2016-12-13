package com.sniffydn.sandbox.core.sn.impl;

import com.sniffydn.sandbox.sentence.Noun;
import com.sniffydn.sandbox.sentence.Person;

public class Kristen {

    private Noun noun = new Noun("Kristen");
    private KristenOutfit outfit = new KristenOutfit();

    public Kristen() {
        noun.setPerson(Person.FIRST_SINGULAR);
    }

    /**
     * @return the outfit
     */
    public KristenOutfit getOutfit() {
        return outfit;
    }

    /**
     * @param outfit the outfit to set
     */
    public void setOutfit(KristenOutfit outfit) {
        this.outfit = outfit;
    }

    /**
     * @return the noun
     */
    public Noun getNoun() {
        return noun;
    }
}
