
package com.sniffydn.sandbox.sentence;

public class DirectObject {
    private Noun noun;
    private Sentence sentence;

    public DirectObject(Noun noun) {
        this.noun = noun;
    }

    public DirectObject(Sentence sentence) {
        this.sentence = sentence;
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

    /**
     * @return the sentence
     */
    public Sentence getSentence() {
        return sentence;
    }

    /**
     * @param sentence the sentence to set
     */
    public void setSentence(Sentence sentence) {
        this.sentence = sentence;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if(noun != null) {
            sb.append(noun.getObjectPronoun());
        }

        if(sentence != null) {
            sb.append(sentence.directObjectToString());
        }
        return sb.toString();
    }
}
