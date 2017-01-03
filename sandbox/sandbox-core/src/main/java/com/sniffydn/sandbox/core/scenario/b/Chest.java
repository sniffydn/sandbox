
package com.sniffydn.sandbox.core.scenario.b;

import com.sniffydn.sandbox.sentence.Noun;

public class Chest extends BodyPart {

    public Chest() {
    }

    Noun n = new Noun(this.getClass().getSimpleName());

    @Override
    public Noun getNoun() {
        return n;
    }

}
