
package com.sniffydn.sandbox.core.scenario.t;

import com.sniffydn.sandbox.core.scenario.Action;
import com.sniffydn.sandbox.core.scenario.CommonBody;
import java.util.ArrayList;
import java.util.List;

public class Key extends Tool {

    private List<String> keyCodes = new ArrayList<>();

    public Key(String code) {
        addKeyCode(code);
    }

    @Override
    public List<Action> getAvailableActionsByHolder(CommonBody holder) {
        return getCommonActions(holder);
    }

    /**
     * @return the keyCodes
     */
    public List<String> getKeyCodes() {
        return keyCodes;
    }

    public void addKeyCode(String code) {
        keyCodes.add(code);
    }

    public boolean containsCode(String key) {
        return keyCodes.contains(key);
    }

    @Override
    public void updateAvailableActionTypes(CommonBody holder) {
        //do nothing
    }

}
