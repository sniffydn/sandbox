
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

        getCustomActions().add(new CustomAction(ActionType.INVOLUNTARY, "Tool") {
            private int count = 1;
            private int threshold = 2;
            @Override
            protected boolean canPerformActionCheck(CommonBody holder) {
                if(getMoodMap().get(Mood.HAPPINESS) > threshold) {
                    getAction().setActionDescription(holder.getName() + "Perform INVOLUNTARY action");
                    getAction().setActionShortDescription("INVOLUNTARY");
                    getAction().setActionTaker(holder);
                    return true;
                }
                return false;
            }

            @Override
            protected void performAction(CommonBody holder) {

                getMoodMap().put(Mood.HAPPINESS, getMoodMap().get(Mood.HAPPINESS) - threshold * count);
                count++;
            }
        });
    }


}
