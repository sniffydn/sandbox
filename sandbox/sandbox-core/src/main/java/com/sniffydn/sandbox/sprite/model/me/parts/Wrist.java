
package com.sniffydn.sandbox.sprite.model.me.parts;

import com.sniffydn.sandbox.sprite.model.me.Part;
import com.sniffydn.sandbox.sprite.model.me.parts.types.Grabable;

public class Wrist extends Part implements Grabable {

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
}
