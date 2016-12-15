package com.sniffydn.sandbox.core.sn.impl;

import com.sniffydn.sandbox.core.sn.Item;
import com.sniffydn.sandbox.sentence.Noun;
import com.sniffydn.sandbox.sentence.Paragraph;

public abstract class DustinOutfit extends Item {

    public abstract Paragraph ud(Noun subject, Noun dirObj);
    public abstract Paragraph tease(Noun subject, Noun dirObj);

    @Override
    public Noun getNoun() {
        if(noun.getAdjective().isEmpty()) {
            return noun;
        } else {
            Noun old = noun;
            noun = new Noun(old.getNoun());
            noun.setPerson(old.getPerson());
            noun.setPosseser(old.getPosseser());
            noun.setDefiniteArticle(old.getDefiniteArticle());
            return old;
        }
    }
}
