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
        Sentence previousSentence = null;
        StringBuilder sb = new StringBuilder();
        for (Sentence s : sentences) {
            if (previousSentence != null
                    && !(previousSentence instanceof CompoundSentence)
                    && previousSentence.getSubject() == s.getSubject()
                    && s.getInterjection() == null) {
                sb.replace(sb.lastIndexOf("."), sb.length(), " ");

                if (s.getVerb().getSubVerb() == Verb.IS && s.getVerb().getVerb().endsWith("ing")) {
                    sb.append(s.getVerb().getVerb());
                } else {
                    sb.append("and ");
                    s.getVerb().setSubject(s.getSubject());
                    sb.append(s.getVerb().toString());
                }

                sb.append(s.toConjoined());
                sb.append("  ");
                previousSentence = null;
            } else {
                sb.append(s.toString());
                sb.append("  ");
                previousSentence = s;
            }
        }
        sb.append("\n");
        return sb.toString();
    }
}
