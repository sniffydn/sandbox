package com.sniffydn.sandbox.sprite.model.me.parts;

import com.sniffydn.sandbox.sprite.model.me.Part;
import com.sniffydn.sandbox.sprite.model.me.parts.types.Lashable;

public class Stomach extends Part implements Lashable {

    public Stomach() {
        super("stomach");
    }

    @Override
    public String lash() {
        return "lash";
    }

}
