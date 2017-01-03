package com.sniffydn.sandbox.core.scenario.b;

import com.sniffydn.sandbox.sentence.Noun;

public class Thigh extends BodyPart {

    public Thigh(Boolean right) {
        setRightSide(right);
        if (right) {
            n.getAdjective().add("right");
        } else {
            n.getAdjective().add("left");
        }
    }

    Noun n = new Noun(this.getClass().getSimpleName());

    @Override
    public Noun getNoun() {
        return n;
    }

}
