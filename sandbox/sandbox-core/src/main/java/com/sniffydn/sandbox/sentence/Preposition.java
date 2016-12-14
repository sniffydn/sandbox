
package com.sniffydn.sandbox.sentence;

import java.util.ArrayList;
import java.util.List;

public class Preposition {
    private List<Noun> noun = new ArrayList<Noun>();
    private String preposition;

    public Preposition(String preposition) {
        this.preposition = preposition;
    }

    public Preposition(String preposition, Noun noun) {
        this.preposition = preposition;
        this.noun.add(noun);
    }

    /**
     * @return the preposition
     */
    public String getPreposition() {
        return preposition;
    }

    /**
     * @param preposition the preposition to set
     */
    public void setPreposition(String preposition) {
        this.preposition = preposition;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(preposition);
        boolean first= true;
        for(Noun n: noun) {
            if(first) {
                first = false;
            } else {
                sb.append(" and");
            }
            sb.append(" ");
            sb.append(n.getObjectPronoun());
        }
        return sb.toString();
    }

    /**
     * @return the noun
     */
    public List<Noun> getNoun() {
        return noun;
    }
}
