package com.sniffydn.sandbox.sprite.model.me.parts;

import com.sniffydn.sandbox.sprite.model.me.Part;
import com.sniffydn.sandbox.sprite.model.me.parts.types.Clampable;

public class Nose extends Part implements Clampable {

    public Nose() {
        super("nose");
    }

    @Override
    public String clamp() {
        occupied = true;
        return "clamp";
    }

    @Override
    public String unclamp() {
        occupied = false;
        return "unclamp";
    }
}
