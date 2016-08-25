package com.sniffydn.sandbox.core.scenario.b;

public class Head extends BodyPart {

    public Head() {
        Neck neck = new Neck();

        getComposedOf().add(neck);

        neck.setPartOf(this);

        this.getDown().add(neck);
        neck.getUp().add(this);

    }

}
