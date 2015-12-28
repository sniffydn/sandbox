
package com.sniffydn.sandbox.sprite.model.me.parts;

import com.sniffydn.sandbox.sprite.model.me.Part;
import com.sniffydn.sandbox.sprite.model.me.parts.types.Lashable;

public class Knee extends Part implements Lashable {

    public Knee(String name) {
        super(name);
    }

    @Override
    public String lash() {
        return "lash";
    }
}
