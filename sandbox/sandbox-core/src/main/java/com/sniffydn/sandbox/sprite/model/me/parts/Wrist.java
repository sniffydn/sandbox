
package com.sniffydn.sandbox.sprite.model.me.parts;

import com.sniffydn.sandbox.sprite.model.me.Part;
import com.sniffydn.sandbox.sprite.model.me.parts.types.Grabable;
import com.sniffydn.sandbox.sprite.model.me.parts.types.Restrainable;

public class Wrist extends Part implements Grabable, Restrainable {

    public Wrist(String name) {
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
