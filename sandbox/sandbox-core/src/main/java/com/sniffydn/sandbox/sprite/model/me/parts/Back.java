package com.sniffydn.sandbox.sprite.model.me.parts;

import com.sniffydn.sandbox.sprite.model.me.Part;
import com.sniffydn.sandbox.sprite.model.me.parts.types.Lashable;

public class Back extends Part implements Lashable {

    public Back() {
        super("back");
    }

    @Override
    public String lash() {
        return "lash";
    }

}
