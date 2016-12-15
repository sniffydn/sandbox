package com.sniffydn.sandbox.core.sn.impl.general;

import com.sniffydn.sandbox.sentence.DirectObject;
import com.sniffydn.sandbox.sentence.Noun;
import com.sniffydn.sandbox.sentence.Paragraph;
import com.sniffydn.sandbox.sentence.Person;
import com.sniffydn.sandbox.sentence.Preposition;
import com.sniffydn.sandbox.sentence.Sentence;
import com.sniffydn.sandbox.sentence.Verb;

public class HP {

    public static Paragraph oneHand(Noun subject, Noun dustin) {
        Paragraph paragraph = new Paragraph();
        Noun kristen = subject;

        Verb g = new Verb("grabs");
        g.getAdverb().add("gently but firmly");

        Sentence s = new Sentence(kristen, g);
        Noun b = new Noun("$b#");
        b.setPosseser(dustin);
        b.setPerson(Person.THIRD_PLURAL_NEUTRAL);
        s.setDirectObject(new DirectObject(b));
        paragraph.getSentences().add(s);

        Noun c = new Noun("$c#");
        c.setPosseser(dustin);
        Sentence s1 = new Sentence(c, new Verb("throbs"));
        Preposition p = new Preposition("with", new Noun("excitement"));
        s1.setPreposition(p);
        paragraph.getSentences().add(s1);

        return paragraph;
    }

}
