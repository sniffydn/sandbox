package com.sniffydn.sandbox.sprite.model.me.parts;

import com.sniffydn.sandbox.sprite.model.me.Part;
import com.sniffydn.sandbox.sprite.model.me.parts.types.Lashable;

public class Butt extends Part implements Lashable {

    public Butt() {
        super("butt");
    }

    @Override
    public String lash() {
        return "lash";
    }

}
