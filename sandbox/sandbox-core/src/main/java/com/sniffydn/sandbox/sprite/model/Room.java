package com.sniffydn.sandbox.sprite.model;

import com.sniffydn.sandbox.sprite.model.her.clts.Accessory;
import java.util.ArrayList;
import java.util.List;

public class Room {

    private final String description;
    private List<Accessory> accessories = new ArrayList<>(); //string with location (map)?

    public Room(String description) {
        this.description = description;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @return the accessories
     */
    public List<Accessory> getAccessories() {
        return accessories;
    }

}
