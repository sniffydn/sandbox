package com.sniffydn.sandbox.sprite.model.her.clts;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

public abstract class SuperC {

    private transient Color primaryColor = Color.BLACK;
    private transient Color secondaryColor = Color.WHITE;
    private transient Color tertiaryColor = Color.PINK;

    private List<CMasterType> cMasterType = new ArrayList<>();
    private List<CMasterType> excludeMasterTypes = new ArrayList<>();

    private List<CType> cType = new ArrayList<>();

    public abstract void paintVeryBack(int offsetX, int offsetY, Graphics2D g2d);

    public abstract void paintBack(int offsetX, int offsetY, Graphics2D g2d);

    public abstract void paintMiddle(int offsetX, int offsetY, Graphics2D g2d);

    public abstract void paintFront(int offsetX, int offsetY, Graphics2D g2d);

    public abstract void paintVeryFront(int offsetX, int offsetY, Graphics2D g2d);

    /**
     * @return the primaryColor
     */
    public Color getPrimaryColor() {
        return primaryColor;
    }

    /**
     * @param primaryColor the primaryColor to set
     */
    public void setPrimaryColor(Color primaryColor) {
        this.primaryColor = primaryColor;
    }

    /**
     * @return the secondaryColor
     */
    public Color getSecondaryColor() {
        return secondaryColor;
    }

    /**
     * @param secondaryColor the secondaryColor to set
     */
    public void setSecondaryColor(Color secondaryColor) {
        this.secondaryColor = secondaryColor;
    }

    /**
     * @return the tertiaryColor
     */
    public Color getTertiaryColor() {
        return tertiaryColor;
    }

    /**
     * @param tertiaryColor the tertiaryColor to set
     */
    public void setTertiaryColor(Color tertiaryColor) {
        this.tertiaryColor = tertiaryColor;
    }

    /**
     * @return the cMasterType
     */
    public List<CMasterType> getcMasterType() {
        return cMasterType;
    }

    /**
     * @param cMasterType the cMasterType to set
     */
    public void setcMasterType(List<CMasterType> cMasterType) {
        this.cMasterType = cMasterType;
    }

    /**
     * @return the excludeMasterTypes
     */
    public List<CMasterType> getExcludeMasterTypes() {
        return excludeMasterTypes;
    }

    /**
     * @param excludeMasterTypes the excludeMasterTypes to set
     */
    public void setExcludeMasterTypes(List<CMasterType> excludeMasterTypes) {
        this.excludeMasterTypes = excludeMasterTypes;
    }

    /**
     * @return the cType
     */
    public List<CType> getcType() {
        return cType;
    }

    /**
     * @param cType the cType to set
     */
    public void setcType(List<CType> cType) {
        this.cType = cType;
    }
}
