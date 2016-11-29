
package com.sniffydn.sandbox.core.sn.impl;

import com.sniffydn.sandbox.core.sn.Persons;

public class Me {
    public static Persons person = Persons.SECOND_PERSON;

    public static String getHe() {
        return person.getPersonMap().get("he").get(0);
    }

    public static String getHimself() {
        return person.getPersonMap().get("himself").get(0);
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
