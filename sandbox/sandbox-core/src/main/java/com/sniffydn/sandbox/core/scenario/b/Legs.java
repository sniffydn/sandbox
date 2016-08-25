package com.sniffydn.sandbox.core.scenario.b;

public class Legs extends BodyPart {

    public Legs() {
        Leg right = new Leg(true);
        Leg left = new Leg(false);

        getComposedOf().add(right);
        getComposedOf().add(left);

        right.setPartOf(this);
        left.setPartOf(this);
    }

}
