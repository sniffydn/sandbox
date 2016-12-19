package com.sniffydn.sandbox.core.sn.impl.sn;

import com.sniffydn.sandbox.core.sn.Util;
import com.sniffydn.sandbox.core.sn.clts.Accessory;
import com.sniffydn.sandbox.core.sn.impl.Scene;
import com.sniffydn.sandbox.core.sn.impl.acc.Anchor;
import com.sniffydn.sandbox.core.sn.impl.acc.Anchorable;
import com.sniffydn.sandbox.core.sn.impl.acc.Attachable;
import com.sniffydn.sandbox.sentence.DirectObject;
import com.sniffydn.sandbox.sentence.Noun;
import com.sniffydn.sandbox.sentence.Paragraph;
import com.sniffydn.sandbox.sentence.Person;
import com.sniffydn.sandbox.sentence.Preposition;
import com.sniffydn.sandbox.sentence.Sentence;
import com.sniffydn.sandbox.sentence.Verb;
import java.util.ArrayList;
import java.util.List;

public class Scene1 extends Scene {

    List<Accessory> accessories = new ArrayList<>();
    Noun cage = new Noun("cage");
    Noun lock = new Noun("cable");
    Anchor anchor = new Anchor(lock, new Preposition("attached to the bottom of", cage));

    public Scene1() {
        cage.setDefiniteArticle("the");
        lock.setDefiniteArticle("the");
        lock.setDescriptor("that's attached to the bottom of the cage");

        Paragraph paragraph = new Paragraph();
        Noun dustin = getMe().getNoun();

        Sentence s = new Sentence(dustin, new Verb("finds"));
        s.setDirectObject(new DirectObject(dustin));
        Preposition p = new Preposition("in", new Noun("a dimly lit", "basement"));
        s.setPreposition(p);

        paragraph.getSentences().add(s);

        s = new Sentence(dustin, new Verb(Verb.IS, "wearing"));
        Noun n = getMe().getOutfit().getNoun();
        s.setDirectObject(new DirectObject(n));

        paragraph.getSentences().add(s);

        Noun lights = new Noun("a row of", "lights");
        lights.setPerson(Person.THIRD_SINGULAR_NEUTRAL);
        s = new Sentence(lights, new Verb("turns"));
        p = new Preposition("on");
        s.setPreposition(p);

        paragraph.getSentences().add(s);

        Noun bunker = new Noun("cavernous concrete", "bunker");
        bunker.setDefiniteArticle("the");
        s = new Sentence(lights, new Verb("illuminates"));
        s.setDirectObject(new DirectObject(bunker));
        paragraph.getSentences().add(s);

        Noun kristen = getHer().getNoun();
        s = new Sentence(kristen, new Verb("enters"));
        s.setDirectObject(new DirectObject(bunker));
        p = new Preposition("by", new Noun("descending in a cage lowered from the opening in the ceiling"));
        s.setPreposition(p);
        paragraph.getSentences().add(s);

        s = new Sentence(dustin, new Verb("backs"));
        p = new Preposition("out of the way");
        s.setPreposition(p);
        paragraph.getSentences().add(s);

        s = new Sentence(kristen, new Verb("steps"));
        p = new Preposition("out of", cage);
        s.setPreposition(p);
        paragraph.getSentences().add(s);

        s = new Sentence(cage, new Verb("raises"));
        Noun reach = new Noun("reach");
        reach.setPosseser(dustin);
        p = new Preposition("up just out of", reach);
        s.setPreposition(p);
        paragraph.getSentences().add(s);

        s = new Sentence(kristen, new Verb(Verb.IS, "wearing"));
        s.setDirectObject(getHer().getOutfit().getDirectObject());
        paragraph.getSentences().add(s);

        if (getHer().getOutfit().getAccessories().size() > 0) {
            for (Accessory a : getHer().getOutfit().getAccessories()) {
                accessories.add(a);
            }
            s = new Sentence(kristen, new Verb(Verb.IS, "carrying"));
            s.setDirectObject(getHer().getOutfit().getAccessoriesDirectObject());
            paragraph.getSentences().add(s);
        }

        scene.add(paragraph);

        paragraph = sceneBeforeUd();
        scene.add(paragraph);

        paragraph = getMe().getOutfit().ud(kristen, getMe());
        scene.add(paragraph);

    }

    private Paragraph sceneBeforeUd() {
        Noun dustin = getMe().getNoun();
        Noun kristen = getHer().getNoun();

        Paragraph paragraph = new Paragraph();

        Verb v1 = new Verb("walks");
        v1.getAdverb().add("slowly");
        Sentence s = new Sentence(kristen, v1);
        Preposition p = new Preposition("to", dustin);
        s.setPreposition(p);

        paragraph.getSentences().add(s);

        if (accessories.size() > 0) {
            Paragraph para = accessories.get(Util.getRandom(accessories.size())).getAction(getHer(), getMe());
            for (Sentence sentence : para.getSentences()) {
                paragraph.getSentences().add(sentence);
            }
        }

        for (Attachable att : getMe().getAttachments()) {
            if (att instanceof Anchorable) {
                Paragraph para = ((Anchorable) att).anchor(getHer(), getMe(), anchor);
                for (Sentence sentence : para.getSentences()) {
                    paragraph.getSentences().add(sentence);
                }
            }
        }

        Paragraph subParagraph = getMe().getOutfit().tease(kristen, getMe());
        for (Sentence sentence : subParagraph.getSentences()) {
            paragraph.getSentences().add(sentence);
        }

        return paragraph;
    }
}
