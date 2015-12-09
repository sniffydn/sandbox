package com.sniffydn.sandbox.sprite.model;

import java.util.ArrayList;
import java.util.List;

public class TopLower implements Actionable {

    private List<Action> actions = new ArrayList<>();
    List<TopLowerType> type = new ArrayList<>();

    @Override
    public List<Action> getActions() {
        return actions;
    }

}
