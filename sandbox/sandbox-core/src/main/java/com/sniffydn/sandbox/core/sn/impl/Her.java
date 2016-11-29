package com.sniffydn.sandbox.core.sn.impl;

import com.sniffydn.sandbox.core.sn.Persons;

public class Her {
    public static Persons person = Persons.FIRST_PERSON;

    public static String getShe() {
        return person.getPersonMap().get("she").get(0);
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

    public String printOutfit() {
        return outfit.print();
    }

    public void print() {
        printOutfit();
    }
}
