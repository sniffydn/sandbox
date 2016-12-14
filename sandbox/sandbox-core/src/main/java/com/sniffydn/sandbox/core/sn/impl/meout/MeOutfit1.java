package com.sniffydn.sandbox.core.sn.impl.meout;

import com.sniffydn.sandbox.core.sn.impl.DustinOutfit;
import com.sniffydn.sandbox.sentence.Noun;
import com.sniffydn.sandbox.sentence.Paragraph;
import com.sniffydn.sandbox.sentence.Person;

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

//            Sentence compound = new Sentence(kristen, new Verb("puts"));
//            Noun finger = new Noun("finger");
//            finger.setPosseser(kristen);
//            compound.setDirectObject(new DirectObject(finger));
//            Preposition p = new Preposition("in between", dustin);
//            Noun elastic = new Noun("elastic");
//            elastic.setPosseser(noun);
//            noun.setPosseser(dustin);
//            p.getNoun().add(elastic);
//            compound.setPreposition(p);
//            paragraph.getSentences().add(compound);
//
//            CompoundSentence cs = new CompoundSentence(kristen, Verb.WALKS, new Conjunction("and while"));
//            p = new Preposition("around", dustin);
//            cs.setPreposition(p);
//            CompoundSentence sub = new CompoundSentence(kristen, new Verb("slides"), Conjunction.COMMA);
//            sub.setDirectObject(new DirectObject(finger));
//            p = new Preposition("around inside", elastic);
//            sub.setPreposition(p);
//            cs.setCompound(sub);
//            Sentence s = new Sentence(kristen, new Verb("inspects"));
//            s.setDirectObject(new DirectObject(dustin));
//            sub.setCompound(s);
//            paragraph.getSentences().add(cs);
//
//            cs = new CompoundSentence(kristen, new Verb("gets"), new Conjunction(","));
//            cs.setInterjection("when");
//            Noun front = new Noun("front");
//            front.setPosseser(dustin);
//            p = new Preposition("back to ", front);
//            cs.setPreposition(p);
//            sub = new CompoundSentence(kristen, new Verb("pulls"), Conjunction.AND);
//            p = new Preposition("back", elastic);
//            sub.setPreposition(p);
//            sub.setCompound(compound);
//            s = new Sentence(kristen, new Verb("plunges"));
//            Noun hand = new Noun("hand");
//            hand.setPosseser(kristen);
//            s.setDirectObject(new DirectObject(hand));
//            s.setPreposition(new Preposition("into", noun));
//            cs.setCompound(sub);
//            sub.setCompound(s);
//            paragraph.getSentences().add(cs);



//            paragraph.getSentences().add(cs);
//            Sentence s = new Sentence(kristen, Verb.WALKS);
//            Preposition p = new Preposition("around behind", dustin);
//            s.setPreposition(p);
//            paragraph.getSentences().add(s);
//
//            s = new Sentence(kristen, new Verb("puts"));
//            Noun n = new Noun("both", "hands");
//            s.setDirectObject(new DirectObject(n));
//            noun = new Noun(noun.getNoun());
//            noun.setPosseser(dustin);
//            noun.setPerson(Person.THIRD_PLURAL_NEUTRAL);
//            p = new Preposition("inside the back of", noun);
//            s.setPreposition(p);
//            paragraph.getSentences().add(s);
//
//            s = new Sentence(kristen, new Verb("grabs"));
//            s.setDirectObject(new DirectObject(noun));
//            paragraph.getSentences().add(s);
//
//            s = new Sentence(kristen, new Verb("gathers"));
//            s.setDirectObject(new DirectObject(noun));
//            n = new Noun("fists");
//            n.setPosseser(kristen);
//            p = new Preposition("up into", n);
//            s.setPreposition(p);
//            paragraph.getSentences().add(s);
//
//            s = new Sentence(kristen, new Verb("quickly and forcefully", "rrrrRIP"));
//            s.setDirectObject(new DirectObject(noun));
//            p = new Preposition("off");
//            s.setPreposition(p);
//            paragraph.getSentences().add(s);
//
//            s = new Sentence(kristen, new Verb("discards"));
//            s.setDirectObject(new DirectObject(noun));
//            p = new Preposition("into a tattered heap on the floor");
//            s.setPreposition(p);
//            paragraph.getSentences().add(s);
            return paragraph;
        }
    }
}
