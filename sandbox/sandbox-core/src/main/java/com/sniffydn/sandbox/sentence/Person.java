package com.sniffydn.sandbox.sentence;

public enum Person {

    THIRD_SINGULAR_FEMALE("she", "her", "her", "hers", "herself"),
    THIRD_SINGULAR_MALE("he", "him", "his", "his", "himself"),
    THIRD_SINGULAR_NEUTRAL("it", "it", "its", "its", "itself"),
    THIRD_PLURAL_NEUTRAL("they", "them", "their", "theirs", "themselves"),
    FIRST_SINGULAR("I", "me", "my", "mine", "myself"),
    SECOND_SINGULAR("You", "you", "your", "yours", "yourself");

    private String subject;
    private String object;
    private String possessive;
    private String possesivePronoun;
    private String reflexive;

    private Person(String subject, String object, String possessive, String possesivePronoun, String reflexive) {
        this.subject = subject;
        this.object = object;
        this.possessive = possessive;
        this.possesivePronoun = possesivePronoun;
        this.reflexive = reflexive;
    }

    /**
     * @return the subject
     */
    public String getSubject() {
        return subject;
    }

    /**
     * @param subject the subject to set
     */
    public void setSubject(String subject) {
        this.subject = subject;
    }

    /**
     * @return the object
     */
    public String getObject() {
        return object;
    }

    /**
     * @param object the object to set
     */
    public void setObject(String object) {
        this.object = object;
    }

    /**
     * @return the possessive
     */
    public String getPossessive() {
        return possessive;
    }

    /**
     * @param possessive the possessive to set
     */
    public void setPossessive(String possessive) {
        this.possessive = possessive;
    }

    /**
     * @return the possesivePronoun
     */
    public String getPossessivePronoun() {
        return possesivePronoun;
    }

    /**
     * @param possesivePronoun the possesivePronoun to set
     */
    public void setPossesivePronoun(String possesivePronoun) {
        this.possesivePronoun = possesivePronoun;
    }

    /**
     * @return the reflexive
     */
    public String getReflexive() {
        return reflexive;
    }

    /**
     * @param reflexive the reflexive to set
     */
    public void setReflexive(String reflexive) {
        this.reflexive = reflexive;
    }

    public String parseVerb(Verb verb) {
        if (verb.getVerb() == null) {
            if(this.equals(FIRST_SINGULAR)) {
                return verb.getPresentFirstSingular();
            } else if(this.equals(SECOND_SINGULAR)) {
                return verb.getPresentSecondSingular();
            } else if(this.equals(THIRD_SINGULAR_NEUTRAL)) {
                return verb.getPresentThirdSingular();
            } else if(this.equals(THIRD_PLURAL_NEUTRAL)) {
                return verb.getPresentPlural();
            } else {
                return "Verb not defined";
            }
        } else {
            if ((this.equals(FIRST_SINGULAR) || this.equals(SECOND_SINGULAR) || this.equals(THIRD_PLURAL_NEUTRAL)) && verb.getVerb().endsWith("s")) {
                return verb.getVerb().substring(0, verb.getVerb().length() - 1);
            }

            return verb.getVerb();
        }
    }
}
