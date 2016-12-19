
package com.sniffydn.sandbox.core.sn.clts;

import com.sniffydn.sandbox.sentence.Noun;

public class Top extends CltsItem {

    protected TopType type = TopType.SHRT;

    public Top(Noun wearer) {
        super(wearer);
    }

    /**
     * @return the type
     */
    public TopType getType() {
        return type;
    }
}
