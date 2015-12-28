
package com.sniffydn.sandbox.sprite.model.me.parts;

import com.sniffydn.sandbox.sprite.model.me.Part;
import com.sniffydn.sandbox.sprite.model.me.parts.types.Lashable;

public class Shin extends Part implements Lashable {

    public Shin(String name) {
        super(name);
    }

    @Override
    public String lash() {
        return "lash";
    }
}
