package com.sniffydn.sandbox.sprite.model;

import java.util.ArrayList;
import java.util.List;

public class Accessory implements Actionable, Item {
    private List<Action> actions = new ArrayList<>();
    AccessoryType type = AccessoryType.NH;
    List<Mood> moodList = new ArrayList<>();

    public Accessory() {
        moodList.add(Mood.DEFAULT);
    }

    @Override
    public List<Action> getActions() {
        return actions;
    }
    
}
