package com.sniffydn.sandbox.core.sn.impl;

import com.sniffydn.sandbox.core.sn.Item;
import com.sniffydn.sandbox.core.sn.Util;

public abstract class MeOutfit extends Item {

    public String ud() {
        return Util.me("he takes off the " + getDescription());
    }

    public String hud() {
        return Util.her("she takes off the " + getDescription());
    }
}
