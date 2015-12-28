
package com.sniffydn.sandbox.sprite.model.me.parts;

import com.sniffydn.sandbox.sprite.model.me.Part;
import com.sniffydn.sandbox.sprite.model.me.parts.types.Grabable;

public class Hand extends Part implements Grabable {

    public Hand(String name) {
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
