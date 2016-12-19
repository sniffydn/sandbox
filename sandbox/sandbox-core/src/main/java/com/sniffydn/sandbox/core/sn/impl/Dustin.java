package com.sniffydn.sandbox.core.sn.impl;

import com.sniffydn.sandbox.core.sn.impl.acc.Attachable;
import com.sniffydn.sandbox.core.sn.impl.meout.MeOutfit1;
import com.sniffydn.sandbox.sentence.Noun;
import com.sniffydn.sandbox.sentence.Person;
import java.util.ArrayList;
import java.util.List;

public class Dustin {

    private Noun noun = new Noun("Dustin");
    private DustinOutfit outfit = new MeOutfit1();
    private List<Attachable> attachments = new ArrayList<>();
    private DBodyPos bodyPos = DBodyPos.STANDING;

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

    /**
     * @return the attachments
     */
    public List<Attachable> getAttachments() {
        return attachments;
    }

    /**
     * @return the dBodyPos
     */
    public DBodyPos getdBodyPos() {
        return bodyPos;
    }

    /**
     * @param dBodyPos the dBodyPos to set
     */
    public void setBodyPos(DBodyPos bodyPos) {
        this.bodyPos = bodyPos;
    }

}
