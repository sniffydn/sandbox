
package com.sniffydn.sandbox.core.scenario.b;

public class Body extends BodyPart {

    public Body() {
        Head head = new Head();
        Torso torso = new Torso();
        Legs legs = new Legs();
        Arms arms = new Arms();

        head.setPartOf(this);
        torso.setPartOf(this);
        legs.setPartOf(this);
        arms.setPartOf(this);

        getComposedOf().add(head);
        getComposedOf().add(torso);
        getComposedOf().add(legs);
        getComposedOf().add(arms);

        head.getDown().add(torso);
        torso.getUp().add(head);

        arms.getDown().add(torso);
        torso.getUp().add(arms);

        legs.getUp().add(torso);
        torso.getDown().add(legs);
        
    }

}
