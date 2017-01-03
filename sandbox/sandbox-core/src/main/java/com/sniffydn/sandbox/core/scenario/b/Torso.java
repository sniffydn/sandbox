package com.sniffydn.sandbox.core.scenario.b;

import com.sniffydn.sandbox.sentence.Noun;

public class Torso extends BodyPart {

    public Torso() {
        LowerBack lowerBack = new LowerBack();
        UpperBack upperBack = new UpperBack();
        Stomach stomach = new Stomach();
        Chest chest = new Chest();
        LoveHandle rightLoveHandle = new LoveHandle(true);
        LoveHandle leftLoveHandle = new LoveHandle(false);
        Groin groin = new Groin();

        getComposedOf().add(lowerBack);
        getComposedOf().add(upperBack);
        getComposedOf().add(stomach);
        getComposedOf().add(chest);
        getComposedOf().add(rightLoveHandle);
        getComposedOf().add(leftLoveHandle);
        getComposedOf().add(groin);

        lowerBack.setPartOf(this);
        upperBack.setPartOf(this);
        stomach.setPartOf(this);
        chest.setPartOf(this);
        rightLoveHandle.setPartOf(this);
        leftLoveHandle.setPartOf(this);
        groin.setPartOf(this);

        groin.getUp().add(stomach);
        stomach.getDown().add(groin);

        stomach.getUp().add(chest);
        chest.getDown().add(stomach);
        stomach.getAround().add(leftLoveHandle);
        stomach.getAround().add(rightLoveHandle);
        leftLoveHandle.getAround().add(stomach);
        rightLoveHandle.getAround().add(stomach);

        leftLoveHandle.getAround().add(lowerBack);
        rightLoveHandle.getAround().add(lowerBack);
        lowerBack.getAround().add(leftLoveHandle);
        lowerBack.getAround().add(rightLoveHandle);
        lowerBack.getUp().add(upperBack);

        upperBack.getDown().add(lowerBack);
        upperBack.getAround().add(chest);
        chest.getAround().add(upperBack);

    }

    Noun n = new Noun(this.getClass().getSimpleName());

    @Override
    public Noun getNoun() {
        return n;
    }

}
