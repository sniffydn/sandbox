
package com.sniffydn.sandbox.sentence;

public class Conjunction {
    public static final Conjunction AND = new Conjunction("and", false);
    public static final Conjunction COMMA = new Conjunction(",", false);
    private String conjunction;
    private boolean repeat = true;

    public Conjunction(String conjunction) {
        this.conjunction = conjunction;
    }

    public Conjunction(String conjunction, boolean repeat) {
        this.conjunction = conjunction;
        this.repeat = repeat;
    }


    /**
     * @return the conjunction
     */
    public String getConjunction() {
        return conjunction;
    }

    /**
     * @return the repeat
     */
    public boolean isRepeat() {
        return repeat;
    }

    /**
     * @param repeat the repeat to set
     */
    public void setRepeat(boolean repeat) {
        this.repeat = repeat;
    }

}
