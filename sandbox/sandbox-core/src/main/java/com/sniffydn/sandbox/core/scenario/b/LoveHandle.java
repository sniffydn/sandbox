package com.sniffydn.sandbox.core.scenario.b;

import com.sniffydn.sandbox.sentence.Noun;

public class LoveHandle extends BodyPart {

    public LoveHandle(Boolean right) {
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
