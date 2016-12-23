package com.sniffydn.sandbox.core.sn.impl.general;

import com.sniffydn.sandbox.sentence.CompoundSentence;
import com.sniffydn.sandbox.sentence.Conjunction;
import com.sniffydn.sandbox.sentence.DirectObject;
import com.sniffydn.sandbox.sentence.Noun;
import com.sniffydn.sandbox.sentence.Paragraph;
import com.sniffydn.sandbox.sentence.Participle;
import com.sniffydn.sandbox.sentence.Person;
import com.sniffydn.sandbox.sentence.Preposition;
import com.sniffydn.sandbox.sentence.Sentence;
import com.sniffydn.sandbox.sentence.Verb;
import java.util.ArrayList;
import java.util.List;

public class HP {

    public static Paragraph oneHand(Noun subject, Noun dustin) {
        Paragraph paragraph = new Paragraph();
        Noun kristen = subject;

        if (Math.random() < .5) {
            Verb g = new Verb("grabs");
            g.getAdverb().add("gently but firmly");

            Sentence s = new Sentence(kristen, g);
            Noun b = new Noun("$b#");
            b.setPosseser(dustin);
            b.setPerson(Person.THIRD_PLURAL_NEUTRAL);
            s.setDirectObject(new DirectObject(b));
            paragraph.getSentences().add(s);

            paragraph.getSentences().add(getNextAr(dustin));
        } else {
            Noun c = new Noun("$p#");
            c.setPosseser(dustin);
            Verb g = new Verb("grabs");
            g.getAdverb().add("gently but firmly");

            Sentence s = new Sentence(kristen, g);
            s.setDirectObject(new DirectObject(c));
            paragraph.getSentences().add(s);
            paragraph.getSentences().add(getNextAr(dustin));
        }

        return paragraph;
    }

    public static Paragraph twoHand(Noun subject, Noun dustin) {
        Paragraph paragraph = new Paragraph();
        Noun kristen = subject;

        if (Math.random() < .5) {
            Verb g = new Verb("grabs");
            g.getAdverb().add("gently but firmly");

            Sentence s = new Sentence(kristen, g);
            Noun b = new Noun("$b#");
            b.setPosseser(dustin);
            b.setPerson(Person.THIRD_PLURAL_NEUTRAL);
            s.setDirectObject(new DirectObject(b));
            Preposition p = new Preposition("with both hands.");
            s.setPreposition(p);
            paragraph.getSentences().add(s);

            paragraph.getSentences().add(getNextAr(dustin));
        } else {
            Noun c = new Noun("$p#");
            c.setPosseser(dustin);
            Verb g = new Verb("grabs");
            g.getAdverb().add("gently but firmly");

            Sentence s = new Sentence(kristen, g);
            s.setDirectObject(new DirectObject(c));
            Preposition p = new Preposition("with both hands.");
            s.setPreposition(p);
            paragraph.getSentences().add(s);
            paragraph.getSentences().add(getNextAr(dustin));
        }

        return paragraph;
    }

    private static List<Sentence> ar = new ArrayList<>();
    private static int arIndex = 0;

    public static Sentence getNextAr(Noun dustin) {
        if (ar.size() == 0) {
            Noun c = new Noun("$p#");
            c.setPosseser(dustin);
            Participle ing = new Participle(new Verb("grows"));
            Sentence s1 = new Sentence(c, new Verb("starts"));
            s1.addParticiple(ing);
            ar.add(s1);

            CompoundSentence cs1 = new CompoundSentence(c, new Verb("swells"), new Conjunction("and"));
            s1 = new Sentence(c, new Verb("becomes"));
            s1.setDirectObject(new DirectObject(new Noun("rock", "hard")));
            cs1.setCompound(s1);
            ar.add(cs1);

            s1 = new Sentence(c, new Verb("throbs"));
            Preposition p = new Preposition("with", new Noun("involuntary", "excitement"));
            s1.setPreposition(p);
            ar.add(s1);
        }

        Sentence s = ar.get(arIndex);
        arIndex++;
        if (arIndex >= ar.size()) {
            arIndex = ar.size() - 1;
        }
        return s;
    }

}
