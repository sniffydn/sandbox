
package com.sniffydn.sandbox.core.scenario.t;

import com.sniffydn.sandbox.core.scenario.ActionType;
import com.sniffydn.sandbox.core.scenario.CommonBody;
import com.sniffydn.sandbox.core.scenario.CustomAction;
import com.sniffydn.sandbox.core.scenario.FBody;
import com.sniffydn.sandbox.core.scenario.MBody;
import com.sniffydn.sandbox.core.scenario.Mood;

public class ToolUtil {
    public static DoorKey getDoorKey(String name) {
        DoorKey key = new DoorKey();
        key.setShortDescription(name + " key");
        key.setWeight(0);
        key.setLongDescription("key to the " + name + " door");
        return key;
    }

    public static Tool getC() {
        final Tool tool = new CommonTool();
        tool.setShortDescription("tool");
        tool.setLongDescription("tool description");
        tool.getAvailableActionTypes().add(ActionType.STEAL);
        tool.getToolActions().add(new CustomAction(ActionType.TOOL, "Tool") {
            MBody mBody;
            @Override
            protected boolean canPerformActionCheck(CommonBody holder) {
                if (holder instanceof FBody && holder.getCurrentRoom().getBodies().size() > 1) {
                    for (final CommonBody b : holder.getCurrentRoom().getBodies()) {
                        if (b != holder && b instanceof MBody) {
                            mBody = (MBody) b;
                            getAction().setActionDescription("Perform Action on " + mBody.getName());
                            getAction().setActionReciever(mBody);
                            getAction().setActionTaker(holder);
                            getAction().setActionShortDescription("On " + mBody.getName());
                            getAction().setCurrentTool(tool);
                            return true;
                        }
                    }
                }
                return false;
            }

            @Override
            protected void performAction(CommonBody holder) {
                mBody.getMoodMap().put(Mood.HAPPINESS, mBody.getMoodMap().get(Mood.HAPPINESS) + 1);
            }
        });

        return tool;
    }
}
