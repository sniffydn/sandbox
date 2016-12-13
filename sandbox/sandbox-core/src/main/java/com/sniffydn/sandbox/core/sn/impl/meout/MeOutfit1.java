package com.sniffydn.sandbox.core.sn.impl.meout;

import com.sniffydn.sandbox.core.sn.impl.DustinOutfit;
import com.sniffydn.sandbox.sentence.DirectObject;
import com.sniffydn.sandbox.sentence.Noun;
import com.sniffydn.sandbox.sentence.Paragraph;
import com.sniffydn.sandbox.sentence.Person;
import com.sniffydn.sandbox.sentence.Preposition;
import com.sniffydn.sandbox.sentence.Sentence;
import com.sniffydn.sandbox.sentence.Verb;

public class MeOutfit1 extends DustinOutfit {

    public MeOutfit1() {
        noun = new Noun("$uw#");
        noun.getAdjective().add("nothing but");
        noun.setPerson(Person.THIRD_PLURAL_NEUTRAL);
    }
//
//    @Override
//    public String hud() {
////        if (Math.random() < .5) {
////            return Util.her("she walks around behind him, putting both hands inside the back and grabbing his "
////                    + getDescription() + " and gathering them up into her fists.  She quickly and forcefully yanks and 'RRRRRIP' throws his "
////                    + getDescription() + " in a tattered heap on the floor");
////        } else {
//            return "with one hand pulls the elastic back on his " + getDescription() + " while the other plunges in to $hP#." +
//                    "she then slowly pulls them down and off, making sure to keep her body as close to his as possible.";
////        }
//    }

    @Override
    public Paragraph ud(Noun subject, Noun dustin) {
        if (subject.equals(dustin)) {
            throw new RuntimeException("Not yet implemented");
        } else {
            Noun kristen = subject;
            Paragraph paragraph = new Paragraph();
            Sentence s = new Sentence(kristen, new Verb("walks"));
            Preposition p = new Preposition("around behind", dustin);
            s.setPreposition(p);
            paragraph.getSentences().add(s);

            s = new Sentence(kristen, new Verb("puts"));
            Noun n = new Noun("both", "hands");
            s.setDirectObject(new DirectObject(n));
            noun = new Noun(noun.getNoun());
            noun.setPosseser(dustin);
            noun.setPerson(Person.THIRD_PLURAL_NEUTRAL);
            p = new Preposition("inside the back of", noun);
            s.setPreposition(p);
            paragraph.getSentences().add(s);

            s = new Sentence(kristen, new Verb("grabs"));
            s.setDirectObject(new DirectObject(noun));
            paragraph.getSentences().add(s);

            s = new Sentence(kristen, new Verb("gathers"));
            s.setDirectObject(new DirectObject(noun));
            n = new Noun("fists");
            n.setPosseser(kristen);
            p = new Preposition("up into", n);
            s.setPreposition(p);
            paragraph.getSentences().add(s);

            Verb v = new Verb("throws");
            v.getAdverb().add("'rrrrrRIP'");
            s = new Sentence(kristen, v);
            s.setDirectObject(new DirectObject(noun));
            p = new Preposition("into a tattered heap on the floor");
            s.setPreposition(p);
            paragraph.getSentences().add(s);

            return paragraph;
        }
    }
}
