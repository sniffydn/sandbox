package com.sniffydn.sandbox.core.scenario;

import com.sniffydn.sandbox.core.scenario.ui.Scenario;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Room closet = new Room();
        closet.setLongDescription("large closet");
        closet.setShortDescription("closet");

        DoorKey key = new DoorKey();
        key.setShortDescription("key");
        key.setLongDescription("key to the door");

        Tool crop = new Tool();
        crop.setShortDescription("crop");
        crop.setLongDescription("crop description");

        Furniture dresser = new Furniture();
        dresser.setLongDescription("large dresser");
        dresser.setShortDescription("dresser");
        dresser.getAvailableToolPositions().add(FurniturePositions.IN);
        dresser.getAvailableToolPositions().add(FurniturePositions.ON);


        dresser.addTool(FurniturePositions.IN, key);
        dresser.addTool(FurniturePositions.ON, crop);

        closet.getFurniture().add(dresser);

        Furniture bed = new Furniture();
        bed.setLongDescription("large bed");
        bed.setShortDescription("bed");
        bed.getAvailablePositions().add(FurniturePositions.ON);

        Room room = new Room();
        room.setLongDescription("large room");
        room.setShortDescription("room");
        room.getFurniture().add(bed);

        Doorway dw = new Doorway();
        dw.setRoom1(room);
        dw.setRoom2(closet);
        dw.setDoorLocked(true);
        dw.setDoorOpen(false);
        dw.getDoorKeys().add(key);

        room.getDoorways().add(dw);
        closet.getDoorways().add(dw);

        MBody mBody = new MBody();
        mBody.setName("mBody");
        mBody.setCurrentRoom(room);

        FBody fBody = new FBody();
        fBody.setName("fBody");
        fBody.setCurrentRoom(closet);

        List<CommonBody> bodies = new ArrayList<>();
        bodies.add(mBody);
        bodies.add(fBody);

        mBody.updateAvailableActions();
        fBody.updateAvailableActions();

        Scenario scenario = new Scenario();
        scenario.start(bodies);
    }
}
