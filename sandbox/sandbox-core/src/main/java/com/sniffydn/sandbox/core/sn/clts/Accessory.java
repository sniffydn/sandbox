package com.sniffydn.sandbox.core.sn.clts;

import com.sniffydn.sandbox.core.sn.Item;
import com.sniffydn.sandbox.core.sn.impl.Dustin;
import com.sniffydn.sandbox.core.sn.impl.Kristen;
import com.sniffydn.sandbox.sentence.Noun;
import com.sniffydn.sandbox.sentence.Paragraph;

public abstract class Accessory extends Item {
    protected Noun holder;


    public Accessory(Noun holder) {
        this.holder = holder;
    }

    public abstract Paragraph getAction(Kristen kr, Dustin d);
}
