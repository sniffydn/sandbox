package com.sniffydn.sandbox.sprite.model.her;

import com.sniffydn.sandbox.sprite.model.Action;
import com.sniffydn.sandbox.sprite.model.Actionable;
import com.sniffydn.sandbox.sprite.model.Item;
import java.util.ArrayList;
import java.util.List;

public class Accessory implements Actionable, Item {

    private List<Action> actions = new ArrayList<>();
    private AccessoryType type = AccessoryType.NH;
    private List<Mood> moodList = new ArrayList<>();
    private String name = "Name";
    private String longDescription = "Long Description";

    public Accessory() {
        moodList.add(Mood.DEFAULT);
    }

    @Override
    public List<Action> getActions() {
        return actions;
    }

    /**
     * @return the type
     */
    public AccessoryType getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(AccessoryType type) {
        this.type = type;
    }

    /**
     * @return the moodList
     */
    public List<Mood> getMoodList() {
        return moodList;
    }

    /**
     * @return the name
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the longDescription
     */
    @Override
    public String getLongDescription() {
        return longDescription;
    }

    /**
     * @param longDescription the longDescription to set
     */
    public void setLongDescription(String longDescription) {
        this.longDescription = longDescription;
    }

}
