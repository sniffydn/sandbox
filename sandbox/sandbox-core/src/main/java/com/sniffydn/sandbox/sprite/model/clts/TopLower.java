package com.sniffydn.sandbox.sprite.model.clts;

import com.sniffydn.sandbox.sprite.model.Action;
import com.sniffydn.sandbox.sprite.model.Actionable;
import com.sniffydn.sandbox.sprite.model.Item;
import java.util.ArrayList;
import java.util.List;

public class TopLower implements Actionable, Item {

    private List<Action> actions = new ArrayList<>();
    List<TopLowerType> type = new ArrayList<>();

    @Override
    public List<Action> getActions() {
        return actions;
    }

}
