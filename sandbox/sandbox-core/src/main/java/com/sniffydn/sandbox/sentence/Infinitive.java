
package com.sniffydn.sandbox.sentence;

public class Infinitive {
    private Sentence infinitive;

    public Infinitive(Sentence infinitive) {
        this.infinitive = infinitive;
    }

    /**
     * @return the infinitive
     */
    public Sentence getInfinitive() {
        return infinitive;
    }

    /**
     * @param infinitive the infinitive to set
     */
    public void setInfinitive(Sentence infinitive) {
        this.infinitive = infinitive;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(infinitive.toStringNoSubject());
        sb.replace(sb.lastIndexOf("."), sb.length(), "");
        return "to " + sb.toString();
    }
}
