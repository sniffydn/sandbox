package com.sniffydn.sandbox.sentence;

import java.util.ArrayList;
import java.util.List;

public class Sentence {

    protected Noun subject;
    protected Verb verb;
    protected DirectObject directObject;
    protected Noun indirectObject;
    protected Preposition preposition;
    protected String interjection;
    protected Infinitive infinitive;
    protected List<Participle> participle = new ArrayList<>();

    public Sentence(Noun subject, Verb verb) {
        this.subject = subject;
        this.verb = verb;
    }

    /**
     * @return the subject
     */
    public Noun getSubject() {
        return subject;
    }

    /**
     * @param subject the subject to set
     */
    public void setSubject(Noun subject) {
        this.subject = subject;
    }

    /**
     * @return the directObject
     */
    public DirectObject getDirectObject() {
        return directObject;
    }

    /**
     * @param directObject the directObject to set
     */
    public void setDirectObject(DirectObject directObject) {
        this.directObject = directObject;
    }

    /**
     * @return the indirectObject
     */
    public Noun getIndirectObject() {
        return indirectObject;
    }

    /**
     * @param indirectObject the indirectObject to set
     */
    public void setIndirectObject(Noun indirectObject) {
        this.indirectObject = indirectObject;
    }

    public String toString() {
        String sb = toStringNoUpperCase();
        return sb.substring(0, 1).toUpperCase() + sb.substring(1);
    }

    String toStringNoUpperCase() {
        StringBuilder sb = new StringBuilder();
        if (interjection != null) {
            sb.append(interjection);
            sb.append(" ");
        }
        sb.append(subject.getSubject());
        sb.append(" ");
        sb.append(toStringNoSubject());
        return sb.toString();
    }

    String toStringNoSubject() {
        StringBuilder sb = new StringBuilder();
        verb.setSubject(subject);
        sb.append(verb.toString());
        build(sb);
        sb.append(".");
        return sb.toString();
    }

    public String toConjoined() {
        StringBuilder sb = new StringBuilder();

        build(sb);
        sb.append(".");
        return sb.substring(0, 1).toUpperCase() + sb.substring(1);
    }

    public String directObjectToString() {

        StringBuilder sb = new StringBuilder(subject.getObjectPronoun());
        return build(sb);
    }

    private String build(StringBuilder sb) {
        if (indirectObject != null) {
            sb.append(" ");
            sb.append(indirectObject.getObjectPronoun());
        }
        if (directObject != null) {
            sb.append(" ");
            if (subject.equals(directObject.getNoun())) {
                sb.append(subject.getReflexivePronoun());
            } else {
                sb.append(directObject);
            }
        }
        if (preposition != null) {
            sb.append(" ");
            sb.append(preposition.toString());
        }

        if (infinitive != null) {
            sb.append(" ");
            sb.append(infinitive);
        }

        for(Participle p: participle) {
            sb.append(" ");
            sb.append(p.toString());
        }

        return sb.toString();
    }

    /**
     * @return the verb
     */
    public Verb getVerb() {
        return verb;
    }

    /**
     * @param verb the verb to set
     */
    public void setVerb(Verb verb) {
        this.verb = verb;
    }

    public static void main(String[] args) {

//        Noun n1 = new Noun("Kristen");
//        n1.setPronoun(Person.FIRST_SINGULAR);
//        Verb v1 = new Verb("walks");
//        v1.getAdverb().add("slowly");
//
//        Preposition p1 = new Preposition("to");
//        Noun n2 = new Noun("Dustin");
//        n2.setPronoun(Person.SECOND_SINGULAR);
//        p1.setNoun(n2);
//
//
//        Sentence s1 = new Sentence(n1, v1);
//        s1.setPreposition(p1);
//        System.out.println(s1);
//
//        Verb v2 = new Verb("grabs");
//        Sentence s2 = new Sentence(n1, v2);
//        Noun n3 = new Noun("tie");
//        n3.getAdjective().add("black");
//        n3.setPosseser(n2);
//        s2.setDirectObject(new DirectObject(n3));
//
//        System.out.println(s2);
//
//
//        Verb v3 = new Verb("unzips");
//        Sentence s3 = new Sentence(n1, v3);
//        Noun n4 = new Noun("pants");
//        n4.setPerson(Person.THIRD_PLURAL_NEUTRAL);
//        n4.setPosseser(n2);
//        s3.setDirectObject(new DirectObject(n4));
//
//        System.out.println(s3);
//
//        Verb v4 = new Verb("lets");
//        Sentence s4 = new Sentence(n1, v4);
//
//
//        Verb v5 = new Verb("falls");
//        Sentence do1 = new Sentence(n4, v5);
//        s4.setDirectObject(new DirectObject(do1));
//        Preposition p2 = new Preposition("to");
//        Noun n5 = new Noun("floor");
//        p2.setNoun(n5);
//        do1.setPreposition(p2);
//
//        System.out.println(s4);
//
//        Sentence s6 = new Sentence(n1, v2);
//        s6.setDirectObject(new DirectObject(n3));
//
//        System.out.println(s6);
//
//
//        Sentence s5 = new Sentence(n4, v5);
//        Preposition p3 = new Preposition("to");
//        p3.setNoun(n5);
//        s5.setPreposition(p3);
//
//        System.out.println(s5);
    }

    /**
     * @return the preposition
     */
    public Preposition getPreposition() {
        return preposition;
    }

    /**
     * @param preposition the preposition to set
     */
    public void setPreposition(Preposition preposition) {
        this.preposition = preposition;
    }

    /**
     * @return the interjection
     */
    public String getInterjection() {
        return interjection;
    }

    /**
     * @param interjection the interjection to set
     */
    public void setInterjection(String interjection) {
        this.interjection = interjection;
    }

    /**
     * @return the infinitive
     */
    public Infinitive getInfinitive() {
        return infinitive;
    }

    /**
     * @param infinitive the infinitive to set
     */
    public void setInfinitive(Infinitive infinitive) {
        this.infinitive = infinitive;
    }

    /**
     * @return the participle
     */
    public List<Participle> getParticiple() {
        return participle;
    }

    public void addParticiple(Participle p) {
        participle.add(p);
    }
}
