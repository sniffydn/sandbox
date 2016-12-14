package com.sniffydn.sandbox.sentence;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Noun {

    private static Map<Person, Noun> ANTECEDENT = new HashMap<Person, Noun>();

    private Person person = Person.THIRD_SINGULAR_NEUTRAL;
    private String noun;
    private String definiteArticle = "";
    private List<String> adjective = new ArrayList<>();
    private Noun posseser;

    public Noun(String noun) {
        this.noun = noun;
    }

    public Noun(String adj, String noun) {
        this.noun = noun;
        adjective.add(adj);
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

    /**
     * @return the pronoun
     */
    public String getSubject() {
        if (this.equals(ANTECEDENT.get(person)) || getPerson().equals(Person.FIRST_SINGULAR) || getPerson().equals(Person.SECOND_SINGULAR)) {
            ANTECEDENT.put(person, this);
            return getPerson().getSubject();
        }

        StringBuilder sb = new StringBuilder();
        if (!this.equals(ANTECEDENT.get(person))) {
            for (String a : adjective) {
                sb.append(a);
                sb.append(" ");
            }
        }
        sb.append(noun);
        ANTECEDENT.put(person, this);
        return sb.toString();
    }

    public String getObjectPronoun() {
        if (this.equals(ANTECEDENT.get(person)) || getPerson().equals(Person.FIRST_SINGULAR) || getPerson().equals(Person.SECOND_SINGULAR)) {
            ANTECEDENT.put(person, this);
            return getPerson().getObject();
        }

        StringBuilder sb = new StringBuilder();
        if (posseser == null) {
            sb.append(definiteArticle);
            if (definiteArticle.length() > 0) {
                sb.append(" ");
            }
        } else {
            sb.append(posseser.getPossessive());
            sb.append(" ");
        }
        if (!this.equals(ANTECEDENT.get(person))) {
            for (String a : adjective) {
                sb.append(a);
                sb.append(" ");
            }
        }

        sb.append(noun);
        ANTECEDENT.put(person, this);
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
        if (this.equals(ANTECEDENT.get(person)) || getPerson().equals(Person.FIRST_SINGULAR) || getPerson().equals(Person.SECOND_SINGULAR)) {
            ANTECEDENT.put(person, this);
            return getPerson().getPossessivePronoun();
        }

        ANTECEDENT.put(person, this);
        return noun + "'s";
    }

    private String getPossessive() {
        StringBuilder sb = new StringBuilder();
        if (getPosseser() != null) {
            sb.append(getPosseser().getPossessive());
            sb.append(" ");
        } else if (this.equals(ANTECEDENT.get(person)) || getPerson().equals(Person.FIRST_SINGULAR) || getPerson().equals(Person.SECOND_SINGULAR)) {
            ANTECEDENT.put(person, this);
            sb.append(getPerson().getPossessive());
            return sb.toString();
        }

        ANTECEDENT.put(person, this);
        sb.append(noun + "'s");
        return sb.toString();
    }

    public String getReflexivePronoun() {
        return getPerson().getReflexive();
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
