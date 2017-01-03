
package com.sniffydn.sandbox.core.scenario.b;

import com.sniffydn.sandbox.sentence.Verb;

public enum PartState {
    SQUEEZED(new Verb("squeezes")),
    PULLED(new Verb("pulls")),
    STRECHED(new Verb("streches")),
    TWISTED(new Verb("twists")),
    STUNG(new Verb("stings")),
    SHOCKED(new Verb("shocks")),
    SHOOK(new Verb("shakes")),
    STROKED(new Verb("strokes")),
    TICKLED(new Verb("tickles")),
    RUBBED(new Verb("rubs")),
    LASHED(new Verb("lashes")),
    PADDLED(new Verb("paddles")),
    PATTED(new Verb("pats")),
    GRABBED(new Verb("grabs")),
    SLAPPED(new Verb("slaps")),
    SWATTED(new Verb("swats")),
    BIT(new Verb("bites")),
    BLOWN(new Verb("blows")),
    LICKED(new Verb("licks")),
    KISSED(new Verb("kisses")),
    SUCKED(new Verb("sucks"));

    private Verb v;

    private PartState(Verb v) {
        this.v = v;
    }

    /**
     * @return the v
     */
    public Verb getV() {
        return v;
    }

}
