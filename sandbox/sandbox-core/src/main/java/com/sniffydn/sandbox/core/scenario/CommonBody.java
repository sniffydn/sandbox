package com.sniffydn.sandbox.core.scenario;

import com.sniffydn.sandbox.core.scenario.b.Body;
import java.util.ArrayList;
import java.util.List;

public class CommonBody {

    private static final List<ActionType> DEFAULT_ACTION_TYPES;

    static {
        DEFAULT_ACTION_TYPES = new ArrayList<>();
        DEFAULT_ACTION_TYPES.add(ActionType.CHANGE_ROOMS);
        DEFAULT_ACTION_TYPES.add(ActionType.GENERAL);
        DEFAULT_ACTION_TYPES.add(ActionType.ROOM);
        DEFAULT_ACTION_TYPES.add(ActionType.FURNITURE);
        DEFAULT_ACTION_TYPES.add(ActionType.TOOL);
        DEFAULT_ACTION_TYPES.add(ActionType.STEAL);
    }

    private String name;
    private Room currentRoom;
    private List<ActionType> availableActionTypes = new ArrayList<>();
    private List<Action> availableActions = new ArrayList<>();
    private List<Tool> tools = new ArrayList<>();
    private int currentToolCarry = 0;
    private int maxToolCapacity = 2;
    private Furniture currentFurniture;
    private FurniturePositions currentFurniturePosition;
    private Body body = new Body();

    public CommonBody() {
        availableActionTypes.addAll(DEFAULT_ACTION_TYPES);
        ScenarioListener sl = new ScenarioListener() {

            @Override
            public void eventFired() {
                availableActions.clear();
            }

            @Override
            public void eventFiredCleanup() {
                updateAvailableActions();
            }
        };
        ScenarioActionListener.addListener(sl);
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
     * @return the currentRoom
     */
    public Room getCurrentRoom() {
        return currentRoom;
    }

    /**
     * @param currentRoom the currentRoom to set
     */
    public void setCurrentRoom(Room currentRoom) {
        if (this.currentRoom != null) {
            this.currentRoom.getBodies().remove(this);
        }
        this.currentRoom = currentRoom;
        currentRoom.getBodies().add(this);
    }

    /**
     * @return the availableActionTypes
     */
    public List<ActionType> getAvailableActionTypes() {
        return availableActionTypes;
    }

    public boolean hasTool(Tool tool) {
        for (Tool t : tools) {
            if (t == tool) {
                return true;
            }
        }
        return false;
    }

    public void updateAvailableActions() {
        for (ActionType at : getAvailableActionTypes()) {
            if (at.equals(ActionType.CHANGE_ROOMS)) {
                for (Doorway dw : getCurrentRoom().getDoorways()) {
                    dw.updateAvailableActions(this);
                    for (Action a : dw.getActions()) {
                        if (getAvailableActionTypes().contains(a.getActionType())) {
                            getAvailableActions().add(a);
                        }
                    }
                }
            } else if (at.equals(ActionType.ROOM)) {
                for (Action a : getCurrentRoom().getAvailableActions(this)) {
                    if (getAvailableActionTypes().contains(a.getActionType())) {
                        getAvailableActions().add(a);
                    }
                }
            } else if (at.equals(ActionType.FURNITURE)) {
                if (getCurrentFurniture() != null) {
                    for (Action a : getCurrentFurniture().getAvailableActions(this)) {
                        if (getAvailableActionTypes().contains(a.getActionType())) {
                            getAvailableActions().add(a);
                        }
                    }
                }
            } else if (at.equals(ActionType.TOOL)) {
                if (tools.size() > 0) {
                    for (Tool tool : tools) {
                        for (Action a : tool.getAvailableActions(this)) {
                            if (getAvailableActionTypes().contains(a.getActionType())) {
                                getAvailableActions().add(a);
                            }
                        }
                    }
                }
            } else if (at.equals(ActionType.GENERAL) || at.equals(ActionType.STEAL)) {
            } else {
                System.out.println("Deal with " + at);
            }
        }
    }

    /**
     * @return the availableActions
     */
    public List<Action> getAvailableActions() {
        return availableActions;
    }

    /**
     * @return the tools
     */
    public List<Tool> getTools() {
        return tools;
    }

    void setRoomPosition(Furniture furn, FurniturePositions pos) {
        this.setCurrentFurniture(furn);
        this.setCurrentFurniturePosition(pos);
    }

    /**
     * @return the currentFurniture
     */
    public Furniture getCurrentFurniture() {
        return currentFurniture;
    }

    /**
     * @return the currentFurniturePosition
     */
    public FurniturePositions getCurrentFurniturePosition() {
        return currentFurniturePosition;
    }

    /**
     * @param currentFurniture the currentFurniture to set
     */
    public void setCurrentFurniture(Furniture currentFurniture) {
        this.currentFurniture = currentFurniture;
    }

    /**
     * @param currentFurniturePosition the currentFurniturePosition to set
     */
    public void setCurrentFurniturePosition(FurniturePositions currentFurniturePosition) {
        this.currentFurniturePosition = currentFurniturePosition;
    }

    /**
     * @return the maxToolCapacity
     */
    public int getMaxToolCapacity() {
        return maxToolCapacity;
    }

    /**
     * @param maxToolCapacity the maxToolCapacity to set
     */
    public void setMaxToolCapacity(int maxToolCapacity) {
        this.maxToolCapacity = maxToolCapacity;
    }

    /**
     * @return the currentToolCarry
     */
    public int getCurrentToolCarry() {
        return currentToolCarry;
    }

    /**
     * @param currentToolCarry the currentToolCarry to set
     */
    public void setCurrentToolCarry(int currentToolCarry) {
        this.currentToolCarry = currentToolCarry;
    }

    public void addAction(Action a) {
        if(availableActionTypes.contains(a.getActionType())) {
            getAvailableActions().add(a);
        }
    }

    /**
     * @return the body
     */
    public Body getBody() {
        return body;
    }
}
