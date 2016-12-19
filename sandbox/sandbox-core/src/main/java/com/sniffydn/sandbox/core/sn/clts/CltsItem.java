
package com.sniffydn.sandbox.core.sn.clts;

import com.sniffydn.sandbox.core.sn.Item;
import com.sniffydn.sandbox.sentence.Noun;

public class CltsItem extends Item {
    protected Noun wearer;

    public CltsItem(Noun wearer) {
        this.wearer = wearer;
    }
}
