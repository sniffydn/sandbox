package com.sniffydn.sandbox.core.scenario;

import com.sniffydn.sandbox.core.scenario.t.DoorKey;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

public class Doorway {

    public static final DoorKey MASTER_KEY = new DoorKey();
    private Room room1;
    private Room room2;
    private boolean oneWayDoorway = false;
    private boolean doorOpen = true;
    private boolean doorLocked = false;
    private List<DoorKey> doorKeys = new ArrayList<>();
    private List<Action> actions = new ArrayList<>();
    private String door = "door";

    public Doorway() {
        doorKeys.add(MASTER_KEY);
    }

    /**
     * @return the room1
     */
    public Room getRoom1() {
        return room1;
    }

    /**
     * @param room1 the room1 to set
     */
    public void setRoom1(Room room1) {
        this.room1 = room1;
    }

    /**
     * @return the room2
     */
    public Room getRoom2() {
        return room2;
    }

    /**
     * @param room2 the room2 to set
     */
    public void setRoom2(Room room2) {
        this.room2 = room2;
    }

    public void updateAvailableActions(final CommonBody body) {
        getActions().clear();

        boolean forward = room1.equals(body.getCurrentRoom());
        if (oneWayDoorway) {
            if (forward) {
                checkLockedStateAndAddActions(body, forward);
            } else {
                return;
            }
        } else {
            checkLockedStateAndAddActions(body, forward);
        }

//        if (doorwayLockedState.equals(DoorwayLockedState.LOCKED)) {
//            for (DoorKey key : getDoorKeys()) {
//                if (body.hasTool(key)) {
//
//                }
//            }
//        }
    }

    private void checkLockedStateAndAddActions(final CommonBody body, boolean forward) {

        boolean hasKey = false;
        for (DoorKey key : getDoorKeys()) {
            if (body.hasTool(key)) {
                hasKey = true;
                break;
            }
        }

        if (doorLocked) {
            if (hasKey) {
                String actionText = "Unlock " + getDoor() + " to " + room1.getShortDescription();
                if (forward) {
                    actionText = "Unlock " + getDoor() + " to " + room2.getShortDescription();
                }
                ScenarioActionListener al = new ScenarioActionListener() {

                    @Override
                    protected void scenarioActionPerformed(ActionEvent e) {
                        setDoorLocked(false);
                    }
                };
                getActions().add(new Action(ActionType.DOORWAY, actionText, al));

                checkOpenStateAndAddActions(body, forward);

                if (!doorOpen) {
                    if (forward) {
                        String actionText1 = "Move to " + room2.getShortDescription() + " and keep the " + door + " locked";
                        ScenarioActionListener al1 = new ScenarioActionListener() {

                            @Override
                            protected void scenarioActionPerformed(ActionEvent e) {
                                body.setCurrentRoom(room2);
                                body.setCurrentFurniture(null);
                                body.setCurrentFurniturePosition(null);
                            }
                        };
                        getActions().add(new Action(ActionType.DOORWAY, actionText1, al1));
                    } else {
                        String actionText1 = "Move to " + room1.getShortDescription() + " and keep the " + door + " locked";
                        ScenarioActionListener al1 = new ScenarioActionListener() {

                            @Override
                            protected void scenarioActionPerformed(ActionEvent e) {
                                body.setCurrentRoom(room1);
                                body.setCurrentFurniture(null);
                                body.setCurrentFurniturePosition(null);
                            }
                        };
                        getActions().add(new Action(ActionType.DOORWAY, actionText1, al1));
                    }
                }
            }
        } else {
            if (hasKey) {
                String actionText = "Lock " + getDoor() + " to " + room1.getShortDescription();
                if (forward) {
                    actionText = "Lock " + getDoor() + " to " + room2.getShortDescription();
                }
                ScenarioActionListener al = new ScenarioActionListener() {

                    @Override
                    protected void scenarioActionPerformed(ActionEvent e) {
                        setDoorLocked(true);
                    }
                };
                getActions().add(new Action(ActionType.DOORWAY, actionText, al));
            }
            checkOpenStateAndAddActions(body, forward);
        }

    }

    private void checkOpenStateAndAddActions(final CommonBody body, boolean forward) {
        if (doorOpen) {
            if (forward) {
                String actionText = "Move to " + room2.getShortDescription();
                ScenarioActionListener al = new ScenarioActionListener() {

                    @Override
                    protected void scenarioActionPerformed(ActionEvent e) {
                        body.setCurrentRoom(room2);
                        body.setCurrentFurniture(null);
                        body.setCurrentFurniturePosition(null);
                    }
                };
                getActions().add(new Action(ActionType.DOORWAY, actionText, al));
            } else {
                String actionText = "Move to " + room1.getShortDescription();
                ScenarioActionListener al = new ScenarioActionListener() {

                    @Override
                    protected void scenarioActionPerformed(ActionEvent e) {
                        body.setCurrentRoom(room1);
                        body.setCurrentFurniture(null);
                        body.setCurrentFurniturePosition(null);
                    }
                };
                getActions().add(new Action(ActionType.DOORWAY, actionText, al));
            }

            String actionText = "Close " + getDoor() + " from " + room1.getShortDescription() + " to " + room2.getShortDescription();
            ScenarioActionListener al = new ScenarioActionListener() {

                @Override
                protected void scenarioActionPerformed(ActionEvent e) {
                    setDoorOpen(false);
                }
            };
            getActions().add(new Action(ActionType.DOORWAY, actionText, al));
        } else {
            if (!doorLocked) {
                if (forward) {
                    String actionText = "Open " + getDoor() + " to " + room2.getShortDescription();
                    ScenarioActionListener al = new ScenarioActionListener() {

                        @Override
                        protected void scenarioActionPerformed(ActionEvent e) {
                            setDoorOpen(true);
                        }
                    };
                    getActions().add(new Action(ActionType.DOORWAY, actionText, al));
                } else {
                    String actionText = "Open " + getDoor() + " to " + room1.getShortDescription();
                    ScenarioActionListener al = new ScenarioActionListener() {

                        @Override
                        protected void scenarioActionPerformed(ActionEvent e) {
                            setDoorOpen(true);
                        }
                    };
                    getActions().add(new Action(ActionType.DOORWAY, actionText, al));
                }
            }
        }

    }

    /**
     * @return the doorKeys
     */
    public List<DoorKey> getDoorKeys() {
        return doorKeys;
    }

    /**
     * @return the oneWayDoorway
     */
    public boolean isOneWayDoorway() {
        return oneWayDoorway;
    }

    /**
     * @param oneWayDoorway the oneWayDoorway to set
     */
    public void setOneWayDoorway(boolean oneWayDoorway) {
        this.oneWayDoorway = oneWayDoorway;
    }

    /**
     * @return the doorOpen
     */
    public boolean isDoorOpen() {
        return doorOpen;
    }

    /**
     * @param doorOpen the doorOpen to set
     */
    public void setDoorOpen(boolean doorOpen) {
        this.doorOpen = doorOpen;
    }

    /**
     * @return the doorLocked
     */
    public boolean isDoorLocked() {
        return doorLocked;
    }

    /**
     * @param doorLocked the doorLocked to set
     */
    public void setDoorLocked(boolean doorLocked) {
        this.doorLocked = doorLocked;
    }

    /**
     * @return the door
     */
    public String getDoor() {
        return door;
    }

    /**
     * @param door the door to set
     */
    public void setDoor(String door) {
        this.door = door;
    }

    /**
     * @return the actions
     */
    public List<Action> getActions() {
        return actions;
    }
}
