
package com.sniffydn.sandbox.core.scenario.t;

import com.sniffydn.sandbox.core.scenario.Action;
import com.sniffydn.sandbox.core.scenario.CommonBody;
import java.util.List;

public class CommonTool extends Tool {

    @Override
    public List<Action> getAvailableActionsByHolder(CommonBody holder) {
        return getCommonActions(holder);
    }

    @Override
    public void updateAvailableActionTypes(CommonBody holder) {
        //do nothing for now
    }

}
