package com.sniffydn.sandbox.sprite.model;

import java.util.ArrayList;
import java.util.List;

public class Action {
    
    private List<Mood> moods = new ArrayList<>();
    private String description = "Action Description";

    public Action() {
        moods.add(Mood.DEFAULT);
    }

    /**
     * @return the moods
     */
    public List<Mood> getMoods() {
        return moods;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }
}
