
package com.sniffydn.sandbox.sprite.model.me.parts;

import com.sniffydn.sandbox.sprite.model.me.Part;
import com.sniffydn.sandbox.sprite.model.me.parts.types.Clampable;
import com.sniffydn.sandbox.sprite.model.me.parts.types.Grabable;

public class Ear extends Part implements Grabable, Clampable {

    public Ear(String name) {
        super(name);
    }

    @Override
    public String grab() {
        return "grab";
    }

    @Override
    public String release() {
        return "release";
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
