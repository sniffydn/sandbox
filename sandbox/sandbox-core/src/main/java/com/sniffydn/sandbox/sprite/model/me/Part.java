package com.sniffydn.sandbox.sprite.model.me;

import com.sniffydn.sandbox.sprite.model.me.parts.types.Clampable;
import com.sniffydn.sandbox.sprite.model.me.parts.types.Grabable;
import com.sniffydn.sandbox.sprite.model.me.parts.types.Lashable;
import com.sniffydn.sandbox.sprite.model.me.parts.types.Restrainable;
import java.util.ArrayList;
import java.util.List;

public abstract class Part {

    private String name = "";
    private List<Part> up = new ArrayList<>();
    private List<Part> down = new ArrayList<>();
    private List<Part> around = new ArrayList<>();
    protected boolean occupied = false;
    private static Part lastRoam = null;
    private List<PartType> types = new ArrayList<>();

    public Part(String name) {
        this.name = name;
        if(this instanceof Grabable) {
            types.add(PartType.GRABABLE);
        }
        if(this instanceof Lashable) {
            types.add(PartType.LASHABLE);
        }
        if(this instanceof Clampable) {
            types.add(PartType.CLAMPABLE);
        }
        if(this instanceof Restrainable) {
            types.add(PartType.RESTRAINABLE);
        }
    }

    /**
     * @return the up
     */
    public List<Part> getUp() {
        return up;
    }

    /**
     * @return the down
     */
    public List<Part> getDown() {
        return down;
    }

    /**
     * @return the name
     */
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
     * @return the around
     */
    public List<Part> getAround() {
        return around;
    }

    /**
     * @return the types
     */
    public List<PartType> getTypes() {
        return types;
    }

    @Override
    public String toString() {
        return getName();
    }

    public Part roam() {
        List<Part> partsList = new ArrayList<>();

        if (around.size() > 0) {
            partsList.add(around.get((int) (Math.random() * around.size())));
        }

        if (up.size() > 0) {
            partsList.add(up.get((int) (Math.random() * up.size())));
        }

        if (down.size() > 0) {
            partsList.add(down.get((int) (Math.random() * down.size())));
        }

        if (partsList.size() > 1) {
            partsList.remove(lastRoam);
        }

        lastRoam = this;
        return partsList.get((int) (Math.random() * partsList.size()));
    }

    public List<Part> roamToward(Part p) {
        List<Part> retVal = new ArrayList<>();
        roamToward(this, p, retVal);
        return retVal;
    }

    private void roamToward(Part currentPart, Part finalPart, List<Part> path) {
        path.add(currentPart);
        if (currentPart.getAround().contains(finalPart) || currentPart.getUp().contains(finalPart) || currentPart.getDown().contains(finalPart)) {
            path.add(finalPart);
            return;
        }
        roamToward(currentPart.roam(), finalPart, path);
        
    }
}
