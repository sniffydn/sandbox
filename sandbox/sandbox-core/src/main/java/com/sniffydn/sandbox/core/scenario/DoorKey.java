
package com.sniffydn.sandbox.core.scenario;

import java.util.List;

public class DoorKey extends Tool {

    @Override
    public List<Action> getAvailableActions(CommonBody holder) {
        return getCommonActions(holder);
    }

}
