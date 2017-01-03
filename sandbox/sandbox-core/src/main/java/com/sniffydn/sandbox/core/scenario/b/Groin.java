
package com.sniffydn.sandbox.core.scenario.b;

import com.sniffydn.sandbox.sentence.Noun;

public class Groin extends BodyPart {

    public Groin() {
    }

    Noun n = new Noun(this.getClass().getSimpleName());

    @Override
    public Noun getNoun() {
        return n;
    }

}
