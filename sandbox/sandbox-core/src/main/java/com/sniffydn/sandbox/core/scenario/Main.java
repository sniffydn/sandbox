package com.sniffydn.sandbox.core.scenario;

import com.sniffydn.sandbox.core.scenario.clothes.Clothes;
import com.sniffydn.sandbox.core.scenario.furniture.Furniture;
import com.sniffydn.sandbox.core.scenario.furniture.FurniturePositions;
import com.sniffydn.sandbox.core.scenario.ui.Scenario;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Room closet2 = new Room();
        closet2.setLongDescription("small closet");
        closet2.setShortDescription("closet 2");

        Room closet = new Room();
        closet.setLongDescription("large closet");
        closet.setShortDescription("closet");

        DoorKey key = new DoorKey();
        key.setShortDescription("room key");
        key.setLongDescription("key to the room door");

        DoorKey key2 = new DoorKey();
        key2.setShortDescription("closet key2");
        key2.setLongDescription("key to the small closet door");

        DoorKey key3 = new DoorKey();
        key3.setShortDescription("room key3");
        key3.setLongDescription("key to the room door");

        Tool tool = new CommonTool();
        tool.setShortDescription("tool");
        tool.setLongDescription("tool description");

        Tool tool2 = new CommonTool();
        tool2.setShortDescription("tool2");
        tool2.setLongDescription("tool2 description");

        Clothes clothes = new Clothes();
        clothes.setToolCapacity(1);
        clothes.setShortDescription("clothes");
        clothes.setLongDescription("clothes description");

        Clothes clothes2 = new Clothes();
        clothes2.setToolCapacity(1);
        clothes2.setShortDescription("clothes2");
        clothes2.setLongDescription("clothes2 description");

        Furniture dresser = new Furniture();
        dresser.setLongDescription("large dresser");
        dresser.setShortDescription("dresser");
        dresser.getAvailableToolPositions().add(FurniturePositions.IN);
        dresser.getAvailableToolPositions().add(FurniturePositions.ON);

        dresser.addTool(FurniturePositions.IN, key);
        dresser.addTool(FurniturePositions.IN, key2);
        dresser.addTool(FurniturePositions.IN, key3);
        dresser.addTool(FurniturePositions.ON, tool);
        dresser.addTool(FurniturePositions.ON, tool2);
        dresser.addTool(FurniturePositions.BY, clothes);
        dresser.addTool(FurniturePositions.IN, clothes2);

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
        dw.getDoorKeys().add(key3);
        
        room.getDoorways().add(dw);
        closet.getDoorways().add(dw);

        Doorway dw2 = new Doorway();
        dw2.setRoom1(closet2);
        dw2.setRoom2(closet);
        dw2.setDoorLocked(true);
        dw2.setDoorOpen(false);
        dw2.getDoorKeys().add(key2);

        closet2.getDoorways().add(dw2);
        closet.getDoorways().add(dw2);

        MBody mBody = new MBody();
        mBody.setName("mBody");
        mBody.setCurrentRoom(room);

        FBody fBody = new FBody();
        fBody.setName("fBody");
        fBody.setCurrentRoom(closet);
        fBody.getAvailableActionTypes().add(ActionType.STEAL);

        FBody fBody2 = new FBody();
        fBody2.setName("fBody2");
        fBody2.setCurrentRoom(closet2);
        fBody2.getAvailableActionTypes().add(ActionType.COMPEL);

        List<CommonBody> bodies = new ArrayList<>();
        bodies.add(mBody);
        bodies.add(fBody);
        bodies.add(fBody2);

        mBody.updateAvailableActions();
        fBody.updateAvailableActions();
        fBody2.updateAvailableActions();

        Scenario scenario = new Scenario();
        scenario.start(bodies);
    }
}
