package com.sniffydn.sandbox.core.sn.impl.sh;

import com.sniffydn.sandbox.core.sn.Util;
import com.sniffydn.sandbox.core.sn.clts.Shoes;
import java.util.ArrayList;
import java.util.List;

public class S1 extends Shoes {

    int height = Util.getRandom(8);
    private static List<String> walksList = new ArrayList<>();

    static {
        walksList.add("click, click, click");
        walksList.add("strut");
    }

    public S1() {
        if (height < 5) {
            height = 5;
        }
        this.description = "$hh#";
        this.longDescripion = "$primaryColor# " + height + "' $hhp# p";
    }
}
