package com.sniffydn.sandbox.core.sn.impl;

public class Her {

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
