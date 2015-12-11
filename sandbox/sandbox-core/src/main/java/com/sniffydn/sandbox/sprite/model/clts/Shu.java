
package com.sniffydn.sandbox.sprite.model.clts;

import com.sniffydn.sandbox.sprite.model.Action;
import com.sniffydn.sandbox.sprite.model.Actionable;
import com.sniffydn.sandbox.sprite.model.Item;
import java.util.ArrayList;
import java.util.List;

public class Shu implements Actionable, Item {
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
