package com.sniffydn.sandbox.sprite.model;

import com.sniffydn.sandbox.sprite.model.her.Her;
import com.sniffydn.sandbox.sprite.model.her.Mood;
import com.sniffydn.sandbox.sprite.model.me.Me;
import com.sniffydn.sandbox.sprite.model.me.PartType;
import java.util.ArrayList;
import java.util.List;

public class Action {
    
    private List<Mood> moods = new ArrayList<>();
    private String description = "Action Description";
    private List<PartType> validPartTypes = new ArrayList<>();

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

    /**
     * @return the validPartTypes
     */
    public List<PartType> getValidPartTypes() {
        return validPartTypes;
    }

    public String perform(Me me, Her her) {
        return getDescription();
    }
}
