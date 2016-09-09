
package com.sniffydn.sandbox.core.scenario.t;

import com.sniffydn.sandbox.core.scenario.Action;
import com.sniffydn.sandbox.core.scenario.CommonBody;
import com.sniffydn.sandbox.core.scenario.t.Tool;
import java.util.List;

public class DoorKey extends Tool {

    @Override
    public List<Action> getAvailableActionsByHolder(CommonBody holder) {
        return getCommonActions(holder);
    }

}
