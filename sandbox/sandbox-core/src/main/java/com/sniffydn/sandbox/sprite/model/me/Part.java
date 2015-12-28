package com.sniffydn.sandbox.sprite.model.me;

import java.util.ArrayList;
import java.util.List;

public abstract class Part {

    private String name = "";
    private List<Part> up = new ArrayList<>();
    private List<Part> down = new ArrayList<>();
    private List<Part> around = new ArrayList<>();
    protected boolean occupied = false;

    public Part(String name) {
        this.name = name;
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

}
