package com.sniffydn.sandbox.sentence;

import java.util.ArrayList;
import java.util.List;

public class Verb {

    private String verb;
    private List<String> adverb = new ArrayList<>();
    private Noun subject;

    public Verb(String verb) {
        this.verb = verb;
    }

    /**
     * @return the verb
     */
    public String getVerb() {
        return verb;
    }

    /**
     * @param verb the verb to set
     */
    public void setVerb(String verb) {
        this.verb = verb;
    }

    /**
     * @return the adverb
     */
    public List<String> getAdverb() {
        return adverb;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (String a : adverb) {
            sb.append(a);
            sb.append(" ");
        }

        sb.append(subject.getPerson().parseVerb(this));
        return sb.toString();
    }

    void setSubject(Noun subject) {
        this.subject = subject;
    }
}
