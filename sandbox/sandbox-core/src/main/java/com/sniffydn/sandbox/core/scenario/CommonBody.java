package com.sniffydn.sandbox.core.scenario;

import com.sniffydn.sandbox.core.scenario.b.Body;
import com.sniffydn.sandbox.core.scenario.clothes.Clothes;
import com.sniffydn.sandbox.core.scenario.furniture.Furniture;
import com.sniffydn.sandbox.core.scenario.furniture.FurniturePositions;
import com.sniffydn.sandbox.core.scenario.t.Tool;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CommonBody {

    private static final List<ActionType> DEFAULT_ACTION_TYPES;

    static {
        DEFAULT_ACTION_TYPES = new ArrayList<>();
        DEFAULT_ACTION_TYPES.add(ActionType.DOORWAY);
        DEFAULT_ACTION_TYPES.add(ActionType.GENERAL);
        DEFAULT_ACTION_TYPES.add(ActionType.INVOLUNTARY);
        DEFAULT_ACTION_TYPES.add(ActionType.ROOM);
        DEFAULT_ACTION_TYPES.add(ActionType.FURNITURE);
        DEFAULT_ACTION_TYPES.add(ActionType.TOOL);
    }

    private String name;
    private Room currentRoom;
    private Set<ActionType> availableActionTypes = new HashSet<>();
    private Set<ActionType> initialActionTypes = new HashSet<>();
    private List<Action> availableActions = new ArrayList<>();
    private List<Tool> tools = new ArrayList<>();
    private int currentToolCarry = 0;
    private int maxToolCapacity = 2;
    private Furniture currentFurniture;
    private FurniturePositions currentFurniturePosition;
    private Body body = new Body();
    private List<Clothes> clothes = new ArrayList<>();

    private Map<Mood, Integer> moodMap = new HashMap<>();
    private List<CustomAction> customActions = new ArrayList<>();

    public CommonBody() {
        for (Mood m : Mood.values()) {
            moodMap.put(m, 0);
        }

        initialActionTypes.addAll(DEFAULT_ACTION_TYPES);
        ScenarioListener sl = new ScenarioListener() {

            @Override
            public void eventFired() {
                availableActions.clear();
                updateAvailableActionTypes();
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
    public Set<ActionType> getAvailableActionTypes() {
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

    public void updateAvailableActionTypes() {
        availableActionTypes.clear();
        availableActionTypes.addAll(initialActionTypes);

        for (Tool tool : tools) {
            if (!(tool instanceof Clothes)) {
                availableActionTypes.addAll(tool.getAvailableActionTypes());
            }
        }

        for (Clothes c : clothes) {
            availableActionTypes.addAll(c.getAvailableActionTypes());
        }
    }

    public void updateAvailableActions() {

        for(CustomAction ca: getCustomActions()) {
            if(ca.canPerformAction(this) && availableActionTypes.contains(ca.getAction().getActionType())) {
                availableActions.add(ca.getAction());
            }
        }

        for (ActionType at : getAvailableActionTypes()) {
            if (at.equals(ActionType.DOORWAY)) {
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
                        for (Action a : tool.getAvailableActionsByHolder(this)) {
                            if (getAvailableActionTypes().contains(a.getActionType())) {
                                getAvailableActions().add(a);
                            }
                        }
                    }

                }
                if (clothes.size() > 0) {
                    for (Clothes c : clothes) {
                        for (Action a : c.getAvailableActionsByHolder(this)) {
                            if (getAvailableActionTypes().contains(a.getActionType())) {
                                getAvailableActions().add(a);
                            }
                        }
                    }
                }
            } else if (at.equals(ActionType.GENERAL) || at.equals(ActionType.STEAL) || at.equals(ActionType.COMPEL) || at.equals(ActionType.RESIST_STEAL) || at.equals(ActionType.RESIST_COMPEL) || at.equals(ActionType.INVOLUNTARY)) {
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
        int mtc = maxToolCapacity;

        for (Clothes c : clothes) {
            mtc += c.getToolCapacity();
        }

        for (Tool t : tools) {
            mtc += t.getToolCapacity();
        }

        return mtc;
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
        a.setActionTaker(this);
        if (availableActionTypes.contains(a.getActionType())) {
            getAvailableActions().add(a);
        }
    }

    /**
     * @return the body
     */
    public Body getBody() {
        return body;
    }

    public boolean canAdd(Tool tool) {
        return tool.getWeight() + getCurrentToolCarry() <= getMaxToolCapacity();
    }

    public void addTool(Tool t) {
        if (!canAdd(t)) {
            throw new RuntimeException("Can't add " + t);
        }
        tools.add(t);
        setCurrentToolCarry(getCurrentToolCarry() + t.getWeight());
    }

    public void removeTool(Tool t) {
        tools.remove(t);
        setCurrentToolCarry(getCurrentToolCarry() - t.getWeight());
    }

    public boolean canAdd(Clothes piece) {
        return piece.getBodyType().isType(this);
    }

    public void addClothes(Clothes t) {
        if (!canAdd(t)) {
            throw new RuntimeException("Can't add " + t);
        }
        clothes.add(t);
    }

    /**
     * @return the clothes
     */
    public List<Clothes> getClothes() {
        return clothes;
    }

    public boolean hasClothes(Clothes c) {
        return clothes.contains(c);
    }

    public void removeClothes(Clothes c) {
        clothes.remove(c);
    }

    /**
     * @return the customActions
     */
    public List<CustomAction> getCustomActions() {
        return customActions;
    }

    /**
     * @return the moodMap
     */
    public Map<Mood, Integer> getMoodMap() {
        return moodMap;
    }
}
