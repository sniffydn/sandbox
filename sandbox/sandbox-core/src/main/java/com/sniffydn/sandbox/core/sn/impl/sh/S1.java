package com.sniffydn.sandbox.core.sn.impl.sh;

import com.sniffydn.sandbox.core.sn.Util;
import com.sniffydn.sandbox.core.sn.clts.Shoes;

public class S1 extends Shoes {

    int height = Util.getRandom(8);

    public S1() {
        if (height < 5) {
            height = 5;
        }
        this.description = "$hh#";
        this.longDescripion = "$primaryColor# " + height + "' $hhp# p";
    }

}
