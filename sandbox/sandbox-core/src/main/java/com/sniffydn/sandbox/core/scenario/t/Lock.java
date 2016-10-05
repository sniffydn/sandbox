package com.sniffydn.sandbox.core.scenario.t;

import com.sniffydn.sandbox.core.scenario.Action;
import com.sniffydn.sandbox.core.scenario.ActionType;
import com.sniffydn.sandbox.core.scenario.CommonBody;
import com.sniffydn.sandbox.core.scenario.ScenarioActionListener;
import com.sniffydn.sandbox.core.scenario.clothes.Clothes;
import java.util.ArrayList;
import java.util.List;

public class Lock extends Tool {

    private final String key;

    public Lock(String key) {
        this.key = key;
        setShortDescription("Lock");
        setLongDescription("Lock");

//        ScenarioListener sl = new ScenarioListener() {
//
//            @Override
//            protected void postEventFired() {
//                boolean lWristAttached = false;
//                boolean rWristAttached = false;
//
//                for(Tool attachment:Lock.this.getAttachedTo()) {
//                    if(attachment instanceof Clothes) {
//                        for(BodyPart bp:((Clothes)attachment).getCovers()) {
//                            if(bp instanceof Wrist) {
//                                if(((Wrist)bp).getRightSide()) {
//                                    rWristAttached = true;
//                                } else {
//                                    lWristAttached = true;
//                                }
//                            }
//                        }
//                    }
//                }
//                if(lWristAttached && rWristAttached) {
//
//                }
//            }
//
//
//            @Override
//            public void eventFired() {
//            }
//
//            @Override
//            public void eventFiredCleanup() {
//            }
//        };
//        ScenarioActionListener.addListener(sl);
    }

    @Override
    public List<Action> getAvailableActionsByHolder(CommonBody holder) {
        List<Action> actions = getCommonActions(holder);

        if (holder.hasCode(key)) {
            System.out.println("HOLDER HAS KEY");
            List<Tool> lockables = new ArrayList<>();

            for (CommonBody body : holder.getCurrentRoom().getBodies()) {
                if (body != holder) {
                    for (Clothes clothes : body.getClothes()) {
                        if (clothes.getAttachedTo().size() < clothes.getAttachablePointCount()) {
                            if (!clothes.getAttachedTo().contains(this)) {
                                for (Attachment attachement : clothes.getAttachments()) {
                                    if (attachement.isLockable()) {
                                        lockables.add(clothes);
                                    }
                                }
                            }
                        }
                    }
                }
            }

            for (Tool t : lockables) {
                final Tool finalT = t;
                Action a = new Action(ActionType.TOOL, "Lock " + t.getShortDescription(), new ScenarioActionListener() {

                    @Override
                    protected void scenarioActionPerformed() {
                        finalT.attachTo(Lock.this);
                    }
                });
                actions.add(a);
            }
        }

        return actions;
    }
}
