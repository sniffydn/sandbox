package com.sniffydn.sandbox.core.scenario;

import com.sniffydn.sandbox.core.scenario.furniture.Furniture;
import com.sniffydn.sandbox.core.scenario.furniture.FurniturePositions;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

public class Room extends CommonObject {

    private List<Furniture> furniture = new ArrayList<>();
    private List<Doorway> doorways = new ArrayList<>();
    private List<CommonBody> bodies = new ArrayList<>();

    /**
     * @return the furniture
     */
    public List<Furniture> getFurniture() {
        return furniture;
    }

    /**
     * @return the doorways
     */
    public List<Doorway> getDoorways() {
        return doorways;
    }

    /**
     * @return the bodies
     */
    public List<CommonBody> getBodies() {
        return bodies;
    }

    public List<Action> getAvailableActions(final CommonBody body) {
        List<Action> actions = new ArrayList<>();
        for (Furniture furn : furniture) {
            for (FurniturePositions pos : furn.getAvailablePositions()) {
                final Furniture f = furn;
                final FurniturePositions p = pos;
                Action a = new Action(ActionType.ROOM, "Move " + pos + " " + furn.getShortDescription(), new ScenarioActionListener() {

                    @Override
                    protected void scenarioActionPerformed() {
                        body.setRoomPosition(f, p);
                    }
                });
                a.setActionShortDescription("Move " + pos);
                a.setCurrentFurniture(furn);
                if (body.getCurrentFurniture() == furn && body.getCurrentFurniturePosition() == pos) {
                    //don't add
                } else {
                    actions.add(a);
                }
            }
        }

        return actions;
    }
}
