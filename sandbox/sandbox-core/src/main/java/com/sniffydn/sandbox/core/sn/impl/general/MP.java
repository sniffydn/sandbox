package com.sniffydn.sandbox.core.sn.impl.general;

import com.sniffydn.sandbox.sentence.Noun;
import com.sniffydn.sandbox.sentence.Paragraph;
import com.sniffydn.sandbox.sentence.Preposition;
import com.sniffydn.sandbox.sentence.Sentence;
import com.sniffydn.sandbox.sentence.Verb;

public class MP {

    public static Paragraph tease(Noun subject, Noun dustin) {
        Paragraph paragraph = new Paragraph();
        Noun kristen = subject;

        Verb g = new Verb("grabs");

        Sentence s = new Sentence(kristen, new Verb("blows"));
        Noun b = new Noun("$cr#");
        b.setPosseser(dustin);
        Preposition p = new Preposition("all over", b);
        s.setPreposition(p);
        paragraph.getSentences().add(s);

        Noun c = new Noun("$p#");
        c.setPosseser(dustin);
        Sentence s1 = new Sentence(c, new Verb("throbs"));
        p = new Preposition("with", new Noun("involuntary", "excitement"));
        s1.setPreposition(p);
        paragraph.getSentences().add(s1);

        return paragraph;
    }
}
