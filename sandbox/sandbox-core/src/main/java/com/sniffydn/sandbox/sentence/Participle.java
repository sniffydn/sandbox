package com.sniffydn.sandbox.sentence;

public class Participle {

    private Verb participle;
    private Noun object;
    private Preposition preposition;

    public Participle(Verb participle) {
        this.participle = participle;
    }

    public Participle(Verb participle, Noun object) {
        this.participle = participle;
        this.object = object;
    }

    /**
     * @return the participle
     */
    public Verb getParticiple() {
        return participle;
    }

    /**
     * @param participle the participle to set
     */
    public void setParticiple(Verb participle) {
        this.participle = participle;
    }

    /**
     * @return the object
     */
    public Noun getObject() {
        return object;
    }

    /**
     * @param object the object to set
     */
    public void setObject(Noun object) {
        this.object = object;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (String s : participle.getAdverb()) {
            sb.append(s);
            sb.append(" ");
        }
        sb.append(participle.getParticiple());
        if(object != null) {
            sb.append(" ");
            sb.append(object.getObjectPronoun());
        }

        if(preposition != null) {
            sb.append(" ");
            sb.append(preposition.toString());
        }
        return sb.toString();
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
}
