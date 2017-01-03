package com.sniffydn.sandbox.core.scenario.b;

import com.sniffydn.sandbox.sentence.Noun;

public class Arms extends BodyPart {

    public Arms() {
        Arm right = new Arm(true);
        Arm left = new Arm(false);

        getComposedOf().add(right);
        getComposedOf().add(left);

        right.setPartOf(this);
        left.setPartOf(this);
    }

    Noun n = new Noun(this.getClass().getSimpleName());

    @Override
    public Noun getNoun() {
        return n;
    }

}
