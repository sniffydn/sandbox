
package com.sniffydn.sandbox.sprite.model;

import java.util.ArrayList;
import java.util.List;

public class TopUpper  implements Actionable{
    private List<Action> actions = new ArrayList<>();
    List<TopUpperType> type = new ArrayList<>();

    @Override
    public List<Action> getActions() {
        return actions;
    }
}
