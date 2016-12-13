
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
        StringBuilder sb = new StringBuilder();
        for(Sentence s: sentences) {
            sb.append(s.toString());
            sb.append("  ");
        }
        sb.append("\n");
        return sb.toString();
    }
}
