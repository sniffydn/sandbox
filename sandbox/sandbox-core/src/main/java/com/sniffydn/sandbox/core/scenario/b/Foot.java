package com.sniffydn.sandbox.core.scenario.b;

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
    }
}
