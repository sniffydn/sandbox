
package com.sniffydn.sandbox.core.sn.impl.tp;

import com.sniffydn.sandbox.core.sn.clts.Top;
import com.sniffydn.sandbox.core.sn.clts.TopType;
import com.sniffydn.sandbox.sentence.Noun;

public class D1 extends Top {

    public D1(Noun wearer) {
        super(wearer);
        type = TopType.DRS_SHORT;
        noun = new Noun("$md#");
        noun.getAdjective().add("$secondaryColor#");
    }

}
