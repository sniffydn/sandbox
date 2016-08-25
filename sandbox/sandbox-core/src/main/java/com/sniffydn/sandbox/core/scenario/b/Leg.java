package com.sniffydn.sandbox.core.scenario.b;

public class Leg extends BodyPart {

    public Leg(Boolean right) {
        this.setRightSide(right);

        ACheek aCheek = new ACheek(right);
        Thigh thigh = new Thigh(right);
        Knee knee = new Knee(right);
        Calf calf = new Calf(right);
        Shin shin = new Shin(right);
        Ankle ankle = new Ankle(right);
        Foot foot = new Foot(right);

        aCheek.setPartOf(this);
        thigh.setPartOf(this);
        knee.setPartOf(this);
        calf.setPartOf(this);
        shin.setPartOf(this);
        ankle.setPartOf(this);
        foot.setPartOf(this);

        getComposedOf().add(aCheek);
        getComposedOf().add(thigh);
        getComposedOf().add(knee);
        getComposedOf().add(calf);
        getComposedOf().add(shin);
        getComposedOf().add(ankle);
        getComposedOf().add(foot);

        aCheek.getAround().add(thigh);
        thigh.getAround().add(aCheek);

        knee.getUp().add(thigh);
        thigh.getDown().add(knee);

        calf.getUp().add(knee);
        knee.getDown().add(calf);
        shin.getUp().add(knee);
        knee.getDown().add(shin);
        shin.getAround().add(calf);
        calf.getAround().add(shin);

        ankle.getUp().add(shin);
        shin.getDown().add(ankle);

        foot.getUp().add(ankle);
        ankle.getDown().add(foot);
    }

}
