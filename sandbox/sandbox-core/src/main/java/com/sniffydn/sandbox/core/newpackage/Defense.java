/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sniffydn.sandbox.core.newpackage;

import java.awt.Color;

/**
 *
 * @author dnyffeler
 */
public class Defense extends Building {
    private int range;
    private int damage;
    private boolean air = false;
    private boolean ground = false;

    public Defense(int footprint, int range, String name, boolean air, boolean ground, Color color) {
        super(footprint, name, color);
        this.range = range;
        this.air = air;
        this.ground = ground;
    }

    Defense(int footprint, int range, String name, boolean air, boolean ground, Color color, int x, int y) {
        super(footprint, name, color, x, y);
        this.range = range;
        this.air = air;
        this.ground = ground;
    }

    /**
     * @return the range
     */
    public int getRange() {
        return range;
    }

    /**
     * @param range the range to set
     */
    public void setRange(int range) {
        this.range = range;
    }

    /**
     * @return the damage
     */
    public int getDamage() {
        return damage;
    }

    /**
     * @param damage the damage to set
     */
    public void setDamage(int damage) {
        this.damage = damage;
    }
    
    public String toString() {
        return "buildings.add(new Defense(" + super.getFootprint() + ", " + range + ", \"" + super.getName() + "\", " + air + "," + ground + ", new Color(" + super.getColor().getRGB() + "), " + super.getX() + ", " + super.getY() + "));";
    }

    /**
     * @return the air
     */
    public boolean isAir() {
        return air;
    }

    /**
     * @return the ground
     */
    public boolean isGround() {
        return ground;
    }
}
