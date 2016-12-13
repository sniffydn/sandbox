package com.sniffydn.sandbox.core.sn.impl.sh;

import com.sniffydn.sandbox.core.sn.Util;
import com.sniffydn.sandbox.core.sn.clts.Shoes;
import com.sniffydn.sandbox.sentence.Noun;

public class S2 extends Shoes {

    int height = Util.getRandom(8);
    public S2() {
        if (height < 5) {
            height = 5;
        }
        noun = new Noun("$hh#");
        noun.getAdjective().add("$primaryColor#");
        noun.getAdjective().add(height + "'");
        noun.getAdjective().add("$pl#");
        noun.getAdjective().add("mj");
    }

}
