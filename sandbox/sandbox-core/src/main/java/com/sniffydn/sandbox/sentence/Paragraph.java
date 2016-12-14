package com.sniffydn.sandbox.sentence;

import java.util.ArrayList;
import java.util.List;

public class Paragraph {

    private List<Sentence> sentences = new ArrayList<>();

    /**
     * @return the sentences
     */
    public List<Sentence> getSentences() {
        return sentences;
    }

    @Override
    public String toString() {
        List<Sentence> newSentences = new ArrayList<>();
        Sentence previousSentence = null;
        for (Sentence s : sentences) {
            if (previousSentence != null
                    && previousSentence.getSubject() == s.getSubject()
                    && s.getInterjection() == null
                    && !(s instanceof CompoundSentence)) {

                CompoundSentence cs = new CompoundSentence(previousSentence, Conjunction.AND);
                cs.setCompound(s);
                newSentences.remove(previousSentence);
                newSentences.add(cs);
                previousSentence = null;
            } else {
                newSentences.add(s);
                previousSentence = s;
            }

            if (s instanceof CompoundSentence) {
                previousSentence = null;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (Sentence s : newSentences) {
            sb.append(s.toString());
        }

        return sb.toString().trim() + "\n";
    }
}
