package com.sniffydn.sandbox.sprite.model.me.parts;

import com.sniffydn.sandbox.sprite.model.me.Part;
import com.sniffydn.sandbox.sprite.model.me.parts.types.Clampable;
import com.sniffydn.sandbox.sprite.model.me.parts.types.Grabable;
import com.sniffydn.sandbox.sprite.model.me.parts.types.Lashable;

public class Pn extends Part implements Clampable, Lashable, Grabable {

    public Pn() {
        super("pn");
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

    @Override
    public String lash() {
        return "lash";
    }

    @Override
    public String grab() {
        return "grab";
    }

    @Override
    public String release() {
        return "release";
    }
}
