
package com.sniffydn.sandbox.core.scenario;

import com.sniffydn.sandbox.core.scenario.furniture.Furniture;

public class Action {
    private ActionType actionType;
    private String actionDescription;
    private ScenarioActionListener actionListener;

    private Furniture currentFurniture = null;

    public Action(ActionType actionType, String actionDescription, ScenarioActionListener actionListener) {
        this.actionType = actionType;
        this.actionDescription = actionDescription;
        this.actionListener = actionListener;
    }

    
    /**
     * @return the actionType
     */
    public ActionType getActionType() {
        return actionType;
    }

    /**
     * @param actionType the actionType to set
     */
    public void setActionType(ActionType actionType) {
        this.actionType = actionType;
    }

    /**
     * @return the actionDescription
     */
    public String getActionDescription() {
        return actionDescription;
    }

    /**
     * @param actionDescription the actionDescription to set
     */
    public void setActionDescription(String actionDescription) {
        this.actionDescription = actionDescription;
    }

    /**
     * @return the actionListener
     */
    public ScenarioActionListener getActionListener() {
        return actionListener;
    }

    /**
     * @param actionListener the actionListener to set
     */
    public void setActionListener(ScenarioActionListener actionListener) {
        this.actionListener = actionListener;
    }

    /**
     * @return the currentFurniture
     */
    public Furniture getCurrentFurniture() {
        return currentFurniture;
    }

    /**
     * @param currentFurniture the currentFurniture to set
     */
    public void setCurrentFurniture(Furniture currentFurniture) {
        this.currentFurniture = currentFurniture;
    }
}
