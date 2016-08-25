
package com.sniffydn.sandbox.core.scenario;

import com.sniffydn.sandbox.core.scenario.b.BodyPart;
import com.sniffydn.sandbox.core.scenario.b.Groin;
import com.sniffydn.sandbox.core.scenario.b.P;
import com.sniffydn.sandbox.core.scenario.b.T;


public class MBody extends CommonBody {

    public MBody() {
        super();
        BodyPart g = getBody().find(Groin.class);
        T t = new T();
        g.getDown().add(t);
        P p = new P();
        g.getDown().add(p);
        p.getUp().add(g);
        t.getUp().add(g);
    }


}
