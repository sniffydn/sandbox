package com.sniffydn.sandbox.core.sn.impl.acc;

import com.sniffydn.sandbox.core.sn.clts.Accessory;
import com.sniffydn.sandbox.core.sn.impl.DBodyPos;
import com.sniffydn.sandbox.core.sn.impl.Dustin;
import com.sniffydn.sandbox.core.sn.impl.Kristen;
import com.sniffydn.sandbox.sentence.CompoundSentence;
import com.sniffydn.sandbox.sentence.Conjunction;
import com.sniffydn.sandbox.sentence.DirectObject;
import com.sniffydn.sandbox.sentence.Noun;
import com.sniffydn.sandbox.sentence.Paragraph;
import com.sniffydn.sandbox.sentence.Person;
import com.sniffydn.sandbox.sentence.Preposition;
import com.sniffydn.sandbox.sentence.Sentence;
import com.sniffydn.sandbox.sentence.Verb;

public class Acc1 extends Accessory implements Attachable, Anchorable {

    private boolean behind = Math.random() < .5;

    public Acc1(Noun holder) {
        super(holder);
        noun = new Noun("$hc#");
        noun.getAdjective().add("pair of");
        noun.setDefiniteArticle("the");
    }

    public Paragraph getAction(Kristen kr, Dustin d) {
        Paragraph paragraph = new Paragraph();
        Noun kristen = kr.getNoun();
        Noun dustin = d.getNoun();

        if (kristen == holder) {
            Paragraph p = attach(kr, d);
            for (Sentence ps : p.getSentences()) {
                paragraph.getSentences().add(ps);
            }
        }

        return paragraph;
    }

    @Override
    public Paragraph attach(Kristen kr, Dustin d) {
        Paragraph paragraph = new Paragraph();
        Noun kristen = kr.getNoun();
        Noun dustin = d.getNoun();
        Noun back = new Noun("back");
        back.setPosseser(dustin);

        Sentence s = new Sentence(kristen, Verb.TAKES);
        Noun hands = new Noun("hands");
        hands.setPosseser(dustin);
        hands.setPerson(Person.THIRD_PLURAL_NEUTRAL);
        s.setDirectObject(new DirectObject(hands));
        if (behind) {
            Preposition p = new Preposition("behind", back);
            s.setPreposition(p);
        }
        paragraph.getSentences().add(s);

        CompoundSentence cs = new CompoundSentence(kristen, new Verb("click-lick-ick-ick-ick", "puts"), new Conjunction("so"));
        cs.setDirectObject(new DirectObject(noun));
        Preposition p = new Preposition("on", dustin);
        cs.setPreposition(p);
        s = new Sentence(hands, new Verb(Verb.IS, "restrained"));
        if (behind) {
            p = new Preposition("behind ", back);
            s.setPreposition(p);
        } else {
            p = new Preposition("in front");
            s.setPreposition(p);
        }
        cs.setCompound(s);
        paragraph.getSentences().add(cs);
        kr.getOutfit().getAccessories().remove(this);
        this.holder = null;
        d.getAttachments().add(this);

        return paragraph;
    }

    Anchor anchor;

    @Override
    public Paragraph anchor(Kristen kr, Dustin d, Anchor a) {
        anchor = a;

        Paragraph paragraph = new Paragraph();
        Noun kristen = kr.getNoun();
        Noun dustin = d.getNoun();

        Noun head = new Noun("head");
        head.setPosseser(dustin);
        Noun hands = new Noun("hands");
        hands.setPosseser(dustin);
        hands.setPerson(Person.THIRD_PLURAL_NEUTRAL);

        Sentence s = new Sentence(kristen, new Verb("attaches"));
        s.setDirectObject(new DirectObject(noun));
        Preposition p = new Preposition("to", a.getNoun());
        s.setPreposition(p);
        paragraph.getSentences().add(s);

        if (anchor.getAnchorType().equals(AnchorType.OVERHEAD)) {
            if (behind) {
                Noun back = new Noun("back");
                back.setPosseser(dustin);
                CompoundSentence cs = new CompoundSentence(hands, new Verb(Verb.IS, "restrained"), new Conjunction("and"));
                s = new Sentence(hands, new Verb(Verb.IS, "stretched"));
                p = new Preposition("up behind", back);
                s.setPreposition(p);
                cs.setCompound(s);
                paragraph.getSentences().add(cs);
                d.setBodyPos(DBodyPos.STANDING_ANCHORED_OVERHEAD_HBB);
            } else {
                s = new Sentence(hands, new Verb(Verb.IS, "restrained"));
                p = new Preposition("over", head);
                s.setPreposition(p);
                paragraph.getSentences().add(s);
                d.setBodyPos(DBodyPos.STANDING_ANCHORED_OVERHEAD_HOH);
            }
        } else {
            throw new RuntimeException(anchor.getAnchorType() + " not accounted for in " + this.getClass());
        }

        return paragraph;
    }

    @Override
    public Anchor getAnchor() {
        return anchor;
    }
}
