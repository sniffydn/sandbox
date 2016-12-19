package com.sniffydn.sandbox.core.sn.impl.acc;

import com.sniffydn.sandbox.core.sn.Item;
import com.sniffydn.sandbox.sentence.Noun;
import com.sniffydn.sandbox.sentence.Preposition;

public class Anchor extends Item {

    private Preposition preposition;
    private AnchorType anchorType = AnchorType.OVERHEAD;

    public Anchor(Noun noun, Preposition preposition) {
        this.noun = noun;
        this.preposition = preposition;
    }

    /**
     * @return the preposition
     */
    public Preposition getPreposition() {
        return preposition;
    }

    public AnchorType getAnchorType() {
        return anchorType;
    }

    public void setAnchorType(AnchorType anchorType) {
        this.anchorType = anchorType;
    }

}
