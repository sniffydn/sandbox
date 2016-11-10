package com.sniffydn.sandbox.core.sn;

import java.util.ArrayList;
import java.util.List;

public class Tool {

    private String longDescription = "";
    private String shortDescription = "";
    private List<Action> availableActions = new ArrayList<>();
    private Action pickUpAction;
    private Action putDownAction;

    /**
     * @return the availableActions
     */
    public List<Action> getAvailableActions() {
        return availableActions;
    }

    /**
     * @param availableActions the availableActions to set
     */
    public void setAvailableActions(List<Action> availableActions) {
        this.availableActions = availableActions;
    }

    /**
     * @return the longDescription
     */
    public String getLongDescription() {
        return longDescription;
    }

    /**
     * @param longDescription the longDescription to set
     */
    public void setLongDescription(String longDescription) {
        this.longDescription = longDescription;
    }

    /**
     * @return the shortDescription
     */
    public String getShortDescription() {
        return shortDescription;
    }

    /**
     * @param shortDescription the shortDescription to set
     */
    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }
}
