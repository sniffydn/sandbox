package com.sniffydn.sandbox.core.sn;

import java.util.ArrayList;
import java.util.List;

public class Action {

    private String description;
    private List<Restriction> addsRestriction = new ArrayList<>();

    Action(String desc) {
        description = desc;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the addsRestriction
     */
    public List<Restriction> getAddsRestriction() {
        return addsRestriction;
    }

    /**
     * @param addsRestriction the addsRestriction to set
     */
    public void setAddsRestriction(List<Restriction> addsRestriction) {
        this.addsRestriction = addsRestriction;
    }

    public void print() {
        System.out.println(description);
    }

}
