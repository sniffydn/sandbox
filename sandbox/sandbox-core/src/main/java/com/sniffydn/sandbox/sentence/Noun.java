package com.sniffydn.sandbox.sentence;

import java.util.ArrayList;
import java.util.List;

public class Noun {

    private Person person = Person.THIRD_SINGULAR_NEUTRAL;
    private boolean singular = true;
    private String noun;
    private String definiteArticle = "the";
    private List<String> adjective = new ArrayList<>();
    private Noun posseser;

    public Noun(String noun) {
        this.noun = noun;
    }

    /**
     * @return the singular
     */
    public boolean isSingular() {
        return singular;
    }

    /**
     * @param singular the singular to set
     */
    public void setSingular(boolean singular) {
        this.singular = singular;
    }

    /**
     * @return the noun
     */
    public String getNoun() {
        return noun;
    }

    /**
     * @param noun the noun to set
     */
    public void setNoun(String noun) {
        this.noun = noun;
    }

    /**
     * @return the definiteArticle
     */
    public String getDefiniteArticle() {
        return definiteArticle;
    }

    /**
     * @param definiteArticle the definiteArticle to set
     */
    public void setDefiniteArticle(String definiteArticle) {
        this.definiteArticle = definiteArticle;
    }

    /**
     * @return the adjective
     */
    public List<String> getAdjective() {
        return adjective;
    }

    int toStringCount = -1;

    /**
     * @return the pronoun
     */
    public String getSubject() {
        toStringCount++;
        if (toStringCount % 4 != 0 || getPerson().equals(Person.FIRST_SINGULAR) || getPerson().equals(Person.SECOND_SINGULAR)) {
            return getPerson().getSubject();
        }

        StringBuilder sb = new StringBuilder();
        if (toStringCount == 0) {
            for (String a : adjective) {
                sb.append(a);
                sb.append(" ");
            }
        }
        sb.append(noun);
        return sb.toString();
    }

    public String getObjectPronoun() {
        toStringCount++;
        if (toStringCount % 4 != 0 || getPerson().equals(Person.FIRST_SINGULAR) || getPerson().equals(Person.SECOND_SINGULAR)) {
            return getPerson().getObject();
        }

        StringBuilder sb = new StringBuilder();
        if(posseser == null) {
            sb.append(definiteArticle);
            sb.append(" ");
        } else {
            sb.append(posseser.getPossessive());
            sb.append(" ");
        }
        if (toStringCount == 0) {
            for (String a : adjective) {
                sb.append(a);
                sb.append(" ");
            }
        }

        sb.append(noun);
        return sb.toString();
    }

    /**
     * @param pronoun the pronoun to set
     */
    public void setPronoun(Person pronoun) {
        this.setPerson(pronoun);
    }

    /**
     * @return the posseser
     */
    public Noun getPosseser() {
        return posseser;
    }

    /**
     * @param posseser the posseser to set
     */
    public void setPosseser(Noun posseser) {
        this.posseser = posseser;
    }

    private String getPossessivePronoun() {
        toStringCount++;
        if (toStringCount % 4 != 0 || getPerson().equals(Person.FIRST_SINGULAR) || getPerson().equals(Person.SECOND_SINGULAR)) {
            return getPerson().getPossessivePronoun();
        }
        
        return noun + "'s";
    }
    
    private String getPossessive() {
        toStringCount++;
        if (toStringCount % 4 != 0 || getPerson().equals(Person.FIRST_SINGULAR) || getPerson().equals(Person.SECOND_SINGULAR)) {
            return getPerson().getPossessive();
        }
        
        return noun + "'s";
    }

    /**
     * @return the person
     */
    public Person getPerson() {
        return person;
    }

    /**
     * @param person the person to set
     */
    public void setPerson(Person person) {
        this.person = person;
    }
}
