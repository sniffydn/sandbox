package com.sniffydn.sandbox.core.scenario.b;

import com.sniffydn.sandbox.sentence.Noun;

public class Head extends BodyPart {

    public Head() {
        Neck neck = new Neck();

        getComposedOf().add(neck);

        neck.setPartOf(this);

        this.getDown().add(neck);
        neck.getUp().add(this);

    }

    Noun n = new Noun(this.getClass().getSimpleName());

    @Override
    public Noun getNoun() {
        return n;
    }

}
