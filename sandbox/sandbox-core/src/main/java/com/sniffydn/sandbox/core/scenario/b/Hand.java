package com.sniffydn.sandbox.core.scenario.b;

import com.sniffydn.sandbox.sentence.Noun;

public class Hand extends BodyPart {

    public Hand(Boolean right) {
        setRightSide(right);

        Palm palm = new Palm(right);
        Thumb thumb = new Thumb(right);
        Knuckles knuckles = new Knuckles(right);
        Fingers fingers = new Fingers(right);

        palm.setPartOf(this);
        thumb.setPartOf(this);
        knuckles.setPartOf(this);
        fingers.setPartOf(this);

        getComposedOf().add(palm);
        getComposedOf().add(thumb);
        getComposedOf().add(knuckles);
        getComposedOf().add(fingers);

        palm.getDown().add(thumb);
        thumb.getUp().add(palm);

        palm.getDown().add(knuckles);
        knuckles.getUp().add(palm);

        knuckles.getDown().add(fingers);
        fingers.getUp().add(knuckles);
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
