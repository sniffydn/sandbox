package com.sniffydn.sandbox.core.sn.impl.sn;

import com.sniffydn.sandbox.core.sn.impl.Scene;
import com.sniffydn.sandbox.sentence.DirectObject;
import com.sniffydn.sandbox.sentence.Noun;
import com.sniffydn.sandbox.sentence.Paragraph;
import com.sniffydn.sandbox.sentence.Person;
import com.sniffydn.sandbox.sentence.Preposition;
import com.sniffydn.sandbox.sentence.Sentence;
import com.sniffydn.sandbox.sentence.Verb;

public class Scene1 extends Scene {

    public Scene1() {
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

        s = new Sentence(kristen, new Verb(Verb.IS, "wearing"));
        s.setDirectObject(getHer().getOutfit().getDirectObject());

        paragraph.getSentences().add(s);
        scene.add(paragraph);

        paragraph = sceneBeforeUd();
        scene.add(paragraph);

        paragraph = getMe().getOutfit().ud(kristen, dustin);
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

        Paragraph subParagraph = getMe().getOutfit().tease(kristen, dustin);
        for (Sentence sentence : subParagraph.getSentences()) {
            paragraph.getSentences().add(sentence);
        }

        return paragraph;
    }
}
