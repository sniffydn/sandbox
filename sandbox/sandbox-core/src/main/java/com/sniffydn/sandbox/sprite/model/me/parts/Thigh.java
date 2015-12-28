
package com.sniffydn.sandbox.sprite.model.me.parts;

import com.sniffydn.sandbox.sprite.model.me.Part;
import com.sniffydn.sandbox.sprite.model.me.parts.types.Lashable;

public class Thigh extends Part implements Lashable {

    public Thigh(String name) {
        super(name);
    }

    @Override
    public String lash() {
        return "lash";
    }
}
