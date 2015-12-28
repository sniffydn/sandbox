
package com.sniffydn.sandbox.sprite.model.me.parts;

import com.sniffydn.sandbox.sprite.model.me.Part;
import com.sniffydn.sandbox.sprite.model.me.parts.types.Grabable;
import com.sniffydn.sandbox.sprite.model.me.parts.types.Restrainable;

public class Ankle extends Part implements Grabable, Restrainable {

    public Ankle(String name) {
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
    public String restrain() {
        occupied = true;
        return "restrain";
    }

    @Override
    public String unrestrain() {
        occupied = false;
        return "unrestrain";
    }
}
