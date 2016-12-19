package com.sniffydn.sandbox.sentence;

import java.util.ArrayList;
import java.util.List;

public class Verb {

    public static Verb IS = new Verb("am", "are", "is", "are", "being");
    public static Verb ATTACHES = new Verb("attach", "attach", "attaches", "attach", "attaching");

    protected String verb;
    private List<String> adverb = new ArrayList<>();
    protected Noun subject;
    private String presentFirstSingular;
    private String presentSecondSingular;
    private String presentThirdSingular;
    private String presentPlural;
    private Verb subVerb;
    protected String participle;

    public Verb(String verb) {
        this.verb = verb;
    }

    public Verb(String adverb, String verb) {
        this.verb = verb;
        this.adverb.add(adverb);
    }

    public Verb(Verb v, String verb) {
        subVerb = v;
        this.verb = verb;
    }

    private Verb(String presentFirstSingular, String presentSecondSingular, String presentThirdSingular, String presentPlural, String participle) {
        this.presentFirstSingular = presentFirstSingular;
        this.presentSecondSingular = presentSecondSingular;
        this.presentThirdSingular = presentThirdSingular;
        this.presentPlural = presentPlural;
        this.participle = participle;
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
        if(getSubVerb() == null) {
            sb.append(subject.getPerson().parseVerb(this));
        } else {
            sb.append(subject.getPerson().parseVerb(getSubVerb()));
            sb.append(" ");
            sb.append(verb);
        }
        return sb.toString();
    }

    protected void setSubject(Noun subject) {
        this.subject = subject;
    }

    /**
     * @return the presentFirstSingular
     */
    public String getPresentFirstSingular() {
        return presentFirstSingular;
    }

    /**
     * @return the presentSecondSingular
     */
    public String getPresentSecondSingular() {
        return presentSecondSingular;
    }

    /**
     * @return the presentThirdSingular
     */
    public String getPresentThirdSingular() {
        return presentThirdSingular;
    }

    /**
     * @return the presentPlural
     */
    public String getPresentPlural() {
        return presentPlural;
    }

    /**
     * @return the subVerb
     */
    public Verb getSubVerb() {
        return subVerb;
    }

    public String getParticiple() {
        if(participle == null && verb.endsWith("es")) {
            return verb.substring(0, verb.length() - 2) + "ing";
        } else if(participle == null && verb.endsWith("s")) {
            return verb.substring(0, verb.length() - 1) + "ing";
        }
        return participle;
    }
}
