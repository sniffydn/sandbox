
package com.sniffydn.sandbox.sentence;

public class Preposition {
    private Noun noun;
    private String preposition;

    public Preposition(String preposition) {
        this.preposition = preposition;
    }

    public Preposition(String preposition, Noun noun) {
        this.preposition = preposition;
        this.noun = noun;
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
        if(getNoun()!= null) {
            sb.append(" ");
            sb.append(getNoun().getObjectPronoun());
        }
        return sb.toString();
    }

    /**
     * @return the noun
     */
    public Noun getNoun() {
        return noun;
    }

    /**
     * @param noun the noun to set
     */
    public void setNoun(Noun noun) {
        this.noun = noun;
    }
}
