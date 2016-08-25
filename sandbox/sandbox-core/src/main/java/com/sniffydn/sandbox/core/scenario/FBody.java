
package com.sniffydn.sandbox.core.scenario;

import com.sniffydn.sandbox.core.scenario.b.B;
import com.sniffydn.sandbox.core.scenario.b.BodyPart;
import com.sniffydn.sandbox.core.scenario.b.Chest;
import com.sniffydn.sandbox.core.scenario.b.Groin;
import com.sniffydn.sandbox.core.scenario.b.V;


public class FBody extends CommonBody {

    public FBody() {
        super();
        BodyPart bp = getBody().find(Groin.class);
        V v = new V();
        bp.getDown().add(v);
        v.getUp().add(bp);

        bp = getBody().find(Chest.class);
        B b = new B();
        bp.getAround().add(b);
        b.getAround().add(bp);
    }

}
