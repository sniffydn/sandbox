package com.sniffydn.sandbox.core.sn.impl.sn;

import com.sniffydn.sandbox.core.sn.impl.Her;
import com.sniffydn.sandbox.core.sn.impl.Me;
import com.sniffydn.sandbox.core.sn.impl.Scene;

public class Scene1 extends Scene {

    public Scene1() {
        description = "basement";
        longDescripion = "dark basement";
        scene = Me.getHe() + " find " + Me.getHimself() + " in a $scene# wearing $meWearing#.  " + Her.getShe() + " walk into the $scene# wearing $herWearing#.";
    }
}
