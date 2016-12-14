package com.sniffydn.sandbox.sentence;

public class CompoundSentence extends Sentence {

    Conjunction conjuction;
    private Sentence compound;

    public CompoundSentence(Noun subject, Verb verb, Conjunction conjuction) {
        super(subject, verb);
        this.conjuction = conjuction;
    }

    CompoundSentence(Sentence previousSentence, Conjunction conjunction) {
        this(previousSentence.subject, previousSentence.verb, conjunction);
        this.directObject = previousSentence.directObject;
        this.indirectObject = previousSentence.indirectObject;
        this.interjection = previousSentence.interjection;
        this.preposition = previousSentence.preposition;
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
        return toString(sb);
    }

    private String toString(StringBuilder sb) {
        sb.replace(sb.lastIndexOf("."), sb.length(), " ");

        if (getSubject() == compound.getSubject()
                && compound.getInterjection() == null && !conjuction.isRepeat()) {

            if (compound.getVerb().getSubVerb() == Verb.IS && compound.getVerb().getVerb().endsWith("ing")) {
                sb.append(compound.getVerb().getVerb());
            } else {
                sb.append(conjuction.getConjunction());
                sb.append(" ");
                compound.getVerb().setSubject(compound.getSubject());
                sb.append(compound.getVerb().toString());
            }

            sb.append(compound.toConjoined());
            sb.append(" ");
        } else {
            sb.append(conjuction.getConjunction());
            sb.append(" ");
            String s = compound.toStringNoUpperCase();
            sb.append(s);
            sb.append(" ");
        }

        if(compound instanceof CompoundSentence) {
            ((CompoundSentence)compound).toString(sb);
        }

        return sb.toString();
    }

}
