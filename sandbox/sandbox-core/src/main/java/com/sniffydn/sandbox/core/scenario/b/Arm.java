package com.sniffydn.sandbox.core.scenario.b;

class Arm extends BodyPart {

    public Arm(Boolean right) {
        setRightSide(right);

        Shoulder shoulder = new Shoulder(right);
        Tricep tricep = new Tricep(right);
        Bicep bicep = new Bicep(right);
        Elbow elbow = new Elbow(right);
        Forearm forearm = new Forearm(right);
        Wrist wrist = new Wrist(right);
        Hand hand = new Hand(right);

        shoulder.setPartOf(this);
        tricep.setPartOf(this);
        bicep.setPartOf(this);
        elbow.setPartOf(this);
        forearm.setPartOf(this);
        wrist.setPartOf(this);
        hand.setPartOf(this);

        getComposedOf().add(shoulder);
        getComposedOf().add(tricep);
        getComposedOf().add(bicep);
        getComposedOf().add(elbow);
        getComposedOf().add(forearm);
        getComposedOf().add(wrist);
        getComposedOf().add(hand);

        shoulder.getDown().add(tricep);
        shoulder.getDown().add(bicep);
        tricep.getAround().add(bicep);
        bicep.getAround().add(tricep);
        tricep.getUp().add(shoulder);
        bicep.getUp().add(shoulder);

        elbow.getUp().add(tricep);
        elbow.getUp().add(bicep);
        tricep.getDown().add(elbow);
        bicep.getDown().add(elbow);

        elbow.getDown().add(forearm);
        forearm.getUp().add(elbow);

        forearm.getDown().add(wrist);
        wrist.getUp().add(forearm);

        wrist.getDown().add(hand);
        hand.getUp().add(wrist);
    }
}
