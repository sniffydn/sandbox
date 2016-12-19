package com.sniffydn.sandbox.core.sn.impl.meout;

import com.sniffydn.sandbox.core.sn.Util;
import com.sniffydn.sandbox.core.sn.impl.Dustin;
import com.sniffydn.sandbox.core.sn.impl.DustinOutfit;
import com.sniffydn.sandbox.core.sn.impl.general.HP;
import com.sniffydn.sandbox.core.sn.impl.general.MP;
import com.sniffydn.sandbox.sentence.CompoundSentence;
import com.sniffydn.sandbox.sentence.Conjunction;
import com.sniffydn.sandbox.sentence.DirectObject;
import com.sniffydn.sandbox.sentence.Infinitive;
import com.sniffydn.sandbox.sentence.Noun;
import com.sniffydn.sandbox.sentence.Paragraph;
import com.sniffydn.sandbox.sentence.Participle;
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

    @Override
    public Paragraph ud(Noun subject, Dustin d) {
        Noun dustin = d.getNoun();
        if (subject.equals(dustin)) {
            throw new RuntimeException("Not yet implemented");
        } else {
            Noun kristen = subject;
            Paragraph paragraph = new Paragraph();

            if (Math.random() < .5) {
                CompoundSentence cs = new CompoundSentence(kristen, new Verb("gets"), new Conjunction(","));
                cs.setInterjection("when");
                Noun front = new Noun("front");
                front.setPosseser(dustin);
                Preposition p = new Preposition("back to ", front);
                cs.setPreposition(p);
                CompoundSentence sub = new CompoundSentence(kristen, new Verb("pulls"), Conjunction.AND);
                Noun elastic = new Noun("elastic");
                elastic.setPosseser(noun);
                p = new Preposition("back", elastic);
                sub.setPreposition(p);
                Sentence s = new Sentence(kristen, new Verb("plunges"));
                Noun hand = new Noun("hand");
                hand.setPosseser(kristen);
                s.setDirectObject(new DirectObject(hand));
                s.setPreposition(new Preposition("into", noun));
                cs.setCompound(sub);
                sub.setCompound(s);
                paragraph.getSentences().add(cs);

                Paragraph subParagraph = HP.oneHand(kristen, dustin);
                for (Sentence sentence : subParagraph.getSentences()) {
                    paragraph.getSentences().add(sentence);
                }

                s = new Sentence(kristen, new Verb("slowly", "pulls"));
                s.setDirectObject(new DirectObject(noun));
                p = new Preposition("down and off");
                s.setPreposition(p);
                paragraph.getSentences().add(s);

                cs = new CompoundSentence(kristen, new Verb("makes"), new Conjunction("so"));
                cs.setDirectObject(new DirectObject(new Noun("sure")));
                Sentence infinitive = new Sentence(kristen, new Verb("slides"));
                Noun kBody = new Noun("body");
                kBody.setPosseser(kristen);
                infinitive.setDirectObject(new DirectObject(kBody));
                Noun dBody = new Noun("body");
                dBody.setPosseser(dustin);
                p = new Preposition("down against", dBody);
                infinitive.setPreposition(p);
                cs.setInfinitive(new Infinitive(infinitive));

                Noun face = new Noun("face");
                face.setPosseser(kristen);
                s = new Sentence(face, new Verb("ends"));
                Noun b = new Noun("$c#");
                b.setPosseser(dustin);
                p = new Preposition("up right next to", b);
                s.setPreposition(p);
                cs.setCompound(s);
                paragraph.getSentences().add(cs);

                subParagraph = MP.tease(kristen, dustin);
                for (Sentence sentence : subParagraph.getSentences()) {
                    paragraph.getSentences().add(sentence);
                }

                cs = new CompoundSentence(kristen, new Verb("slides"), new Conjunction("as"));
                Noun hands = new Noun("hands");
                hands.setPerson(Person.THIRD_PLURAL_NEUTRAL);
                hands.setPosseser(kristen);
                cs.setDirectObject(new DirectObject(hands));
                Noun l = new Noun("$l#");
                l.setPosseser(dustin);
                p = new Preposition("up along", l);
                cs.setPreposition(p);
                Noun a = new Noun("$a#");
                a.setPosseser(dustin);
                Participle ing = new Participle(new Verb("grabs"), a);
                cs.addParticiple(ing);

                s = new Sentence(kristen, new Verb("stands"));
                p = new Preposition("back up");
                s.setPreposition(p);
                cs.setCompound(s);
                paragraph.getSentences().add(cs);
            } else {
                Sentence s = new Sentence(kristen, Util.WALKS);
                Preposition p = new Preposition("around behind", dustin);
                s.setPreposition(p);
                paragraph.getSentences().add(s);

                s = new Sentence(kristen, new Verb("puts"));
                Noun n = new Noun("both", "hands");
                s.setDirectObject(new DirectObject(n));
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

                s = new Sentence(kristen, new Verb("quickly and forcefully", "rrrrRIP"));
                s.setDirectObject(new DirectObject(noun));
                p = new Preposition("off");
                s.setPreposition(p);
                paragraph.getSentences().add(s);

                s = new Sentence(kristen, new Verb("discards"));
                s.setDirectObject(new DirectObject(noun));
                p = new Preposition("into a tattered heap on the floor");
                s.setPreposition(p);
                paragraph.getSentences().add(s);
            }
            return paragraph;
        }
    }

    @Override
    public Paragraph tease(Noun subject, Dustin d) {
        Noun dustin = d.getNoun();
        Noun kristen = subject;
        Paragraph paragraph = new Paragraph();

        Sentence compound = new Sentence(kristen, new Verb("puts"));
        Noun finger = new Noun("finger");
        finger.setPosseser(kristen);
        compound.setDirectObject(new DirectObject(finger));
        Preposition p = new Preposition("in between", dustin);
        noun.setPosseser(dustin);
        Noun elastic = new Noun("elastic");
        elastic.setPosseser(noun);
        p.getNoun().add(elastic);
        compound.setPreposition(p);
        paragraph.getSentences().add(compound);

        Sentence cs = new Sentence(kristen, Util.WALKS);
        p = new Preposition("around", dustin);
        cs.setPreposition(p);
        Participle ing = new Participle(new Verb("slides"), finger);
        p = new Preposition("around inside", elastic);
        ing.setPreposition(p);
        cs.addParticiple(ing);
        Noun dBody = new Noun("body");
        dBody.setPosseser(dustin);
        ing = new Participle(new Verb("carefully", "inspects"), dBody);
        cs.addParticiple(ing);
        paragraph.getSentences().add(cs);

        return paragraph;
    }
}
