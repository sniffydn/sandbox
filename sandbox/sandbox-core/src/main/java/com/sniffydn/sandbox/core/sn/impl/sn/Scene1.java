package com.sniffydn.sandbox.core.sn.impl.sn;

import com.sniffydn.sandbox.core.sn.impl.Scene;

public class Scene1 extends Scene {

    public Scene1() {
        description = "basement";
        longDescripion = "dark basement";
        scene = me("He finds himself in a $scene# wearing $meWearing#.\n") +
                "Suddenly, a row of lights turns on, illuminating the cavernous concrete bunker.\n" +
                her("She walks into the $scene# wearing $herWearing#.\n") +
                her("She walks up to him, and $meHud#.\n");
    }
}
