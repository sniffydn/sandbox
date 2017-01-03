package com.sniffydn.sandbox.core.scenario.b;

import com.sniffydn.sandbox.sentence.Noun;

public class Foot extends BodyPart {

    public Foot(Boolean right) {
        this.setRightSide(right);

        Heel heel = new Heel(right);
        Toes toes = new Toes(right);

        heel.setPartOf(this);
        toes.setPartOf(this);

        getComposedOf().add(heel);
        getComposedOf().add(toes);

        toes.getUp().add(this);
        this.getDown().add(toes);
        this.getDown().add(heel);
        heel.getUp().add(toes);
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
