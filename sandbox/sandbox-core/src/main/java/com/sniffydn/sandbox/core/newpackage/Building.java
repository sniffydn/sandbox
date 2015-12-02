package com.sniffydn.sandbox.core.newpackage;

import java.awt.Color;
import java.beans.PropertyChangeSupport;

public class Building {

    private int footprint = 1;
    private int hitPoints = 0;
    private String name;
    private int x = 0;
    private int y = 35;
    private final Color color;
    private final transient PropertyChangeSupport propertyChangeSupport = new java.beans.PropertyChangeSupport(this);

    Building(int footprint, String name, Color color) {
        this.footprint = footprint;
        this.name = name;
        this.color = color;
    }

    Building(int footprint, String name, Color color, int x, int y) {
        this.footprint = footprint;
        this.name = name;
        this.color = color;
        this.x = x;
        this.y = y;
    }

    /**
     * @return the footprint
     */
    public int getFootprint() {
        return footprint;
    }

    /**
     * @param footprint the footprint to set
     */
    public void setFootprint(int footprint) {
        int oldFootprint = this.footprint;
        this.footprint = footprint;
        propertyChangeSupport.firePropertyChange("footprint", oldFootprint, footprint);
    }

    /**
     * @return the hitPoints
     */
    public int getHitPoints() {
        return hitPoints;
    }

    /**
     * @param hitPoints the hitPoints to set
     */
    public void setHitPoints(int hitPoints) {
        int oldHitPoints = this.hitPoints;
        this.hitPoints = hitPoints;
        propertyChangeSupport.firePropertyChange("hitPoints", oldHitPoints, hitPoints);
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
        java.lang.String oldName = this.name;
        this.name = name;
        propertyChangeSupport.firePropertyChange("name", oldName, name);
    }

    /**
     * @return the x
     */
    public int getX() {
        return x;
    }

    /**
     * @param x the x to set
     */
    public void setX(int x) {
        int oldX = this.x;
        this.x = x;
        propertyChangeSupport.firePropertyChange("x", oldX, x);
    }

    /**
     * @return the y
     */
    public int getY() {
        return y;
    }

    /**
     * @param y the y to set
     */
    public void setY(int y) {
        int oldY = this.y;
        this.y = y;
        propertyChangeSupport.firePropertyChange("y", oldY, y);
    }

    /**
     * @return the color
     */
    public Color getColor() {
        return color;
    }

    @Override
    public String toString() {
        return "buildings.add(new Building(" + footprint + ", \"" + name + "\", new Color(" + color.getRGB() + "), " + x + ", " + y + "));";
    }

}
