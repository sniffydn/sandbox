package com.sniffydn.sandbox.core.sn.impl;

public class Me {

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
