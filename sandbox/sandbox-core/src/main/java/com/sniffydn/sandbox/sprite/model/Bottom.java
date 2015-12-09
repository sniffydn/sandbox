
package com.sniffydn.sandbox.sprite.model;

import java.util.ArrayList;
import java.util.List;

public class Bottom implements Actionable{
    private List<Action> actions = new ArrayList<>();

    @Override
    public List<Action> getActions() {
        return actions;
    }
    
}
