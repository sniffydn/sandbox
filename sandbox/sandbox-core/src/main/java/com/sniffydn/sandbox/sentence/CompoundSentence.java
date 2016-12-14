package com.sniffydn.sandbox.sentence;

public class CompoundSentence extends Sentence {

    Conjunction conjuction;
    private Sentence compound;

    public CompoundSentence(Noun subject, Verb verb, Conjunction conjuction) {
        super(subject, verb);
        this.conjuction = conjuction;
    }

    /**
     * @return the compound
     */
    public Sentence getCompound() {
        return compound;
    }

    /**
     * @param compound the compound to set
     */
    public void setCompound(Sentence compound) {
        this.compound = compound;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        sb.replace(sb.lastIndexOf("."), sb.length(), " ");

        sb.append(conjuction.getConjunction());
        sb.append(" ");
        sb.append(compound.toString());

        return sb.toString();
    }


}
