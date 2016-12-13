package com.sniffydn.sandbox.core.sn.impl.meout;

import com.sniffydn.sandbox.core.sn.impl.MeOutfit;

public class MeOutfit1 extends MeOutfit {

    public MeOutfit1() {
        description = "$uw#";
        longDescripion = "nothing but $uw#";

    }

    @Override
    public String hud() {
//        if (Math.random() < .5) {
//            return Util.her("she walks around behind him, putting both hands inside the back and grabbing his "
//                    + getDescription() + " and gathering them up into her fists.  She quickly and forcefully yanks and 'RRRRRIP' throws his "
//                    + getDescription() + " in a tattered heap on the floor");
//        } else {
            return "she walks around behind him, and with one hand pulls the elastic back on his " + getDescription() + " while the other plunges in to $hP#." +
                    "she then slowly pulls them down and off, making sure to keep her body as close to his as possible.";
//        }
    }
}
