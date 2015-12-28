package com.sniffydn.sandbox.sprite.model.me.parts;

import com.sniffydn.sandbox.sprite.model.me.Part;
import com.sniffydn.sandbox.sprite.model.me.parts.types.Lashable;

public class Chest extends Part implements Lashable {

    public Chest() {
        super("chest");
    }

    @Override
    public String lash() {
        return "lash";
    }

}
