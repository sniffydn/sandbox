package com.sniffydn.sandbox.core.sn.impl;

import com.sniffydn.sandbox.core.sn.Item;

public abstract class MeOutfit extends Item {

    public String ud() {
        return "he takes off the " + getDescription();
    }

    public String hud() {
        return "she takes off the " + getDescription();
    }
}
