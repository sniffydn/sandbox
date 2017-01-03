package com.sniffydn.sandbox.core.sn.impl.general;

import com.sniffydn.sandbox.core.sn.impl.Dustin;
import com.sniffydn.sandbox.sentence.Noun;
import com.sniffydn.sandbox.sentence.Paragraph;
import com.sniffydn.sandbox.sentence.Preposition;
import com.sniffydn.sandbox.sentence.Sentence;
import com.sniffydn.sandbox.sentence.Verb;

public class MP {

    public static Paragraph tease(Noun subject, Dustin dustin) {
        Paragraph paragraph = new Paragraph();
        Noun kristen = subject;

        Sentence s = new Sentence(kristen, new Verb("blows"));
        Noun b = new Noun("$cr#");
        b.setPosseser(dustin.getNoun());
        Preposition p = new Preposition("all over", b);
        s.setPreposition(p);
        paragraph.getSentences().add(s);

        paragraph.getSentences().add(HP.getNextAr(dustin));

        return paragraph;
    }
}
