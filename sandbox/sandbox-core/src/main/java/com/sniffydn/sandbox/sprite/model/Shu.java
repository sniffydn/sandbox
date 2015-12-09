
package com.sniffydn.sandbox.sprite.model;

import java.util.ArrayList;
import java.util.List;

public class Shu  implements Actionable{
    private List<Action> actions = new ArrayList<>();
    List<ShuType> type = new ArrayList<>();

    public Shu() {
        type.add(ShuType.SHU);
    }

    @Override
    public List<Action> getActions() {
        return actions;
    }
    
}
