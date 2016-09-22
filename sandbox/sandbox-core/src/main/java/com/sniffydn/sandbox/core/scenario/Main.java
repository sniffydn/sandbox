package com.sniffydn.sandbox.core.scenario;

import com.sniffydn.sandbox.core.scenario.clothes.ClothesColor;
import com.sniffydn.sandbox.core.scenario.clothes.ClothesUtil;
import com.sniffydn.sandbox.core.scenario.furniture.Furniture;
import com.sniffydn.sandbox.core.scenario.furniture.FurniturePositions;
import com.sniffydn.sandbox.core.scenario.t.DoorKey;
import com.sniffydn.sandbox.core.scenario.t.Lock;
import com.sniffydn.sandbox.core.scenario.t.Tool;
import com.sniffydn.sandbox.core.scenario.t.ToolUtil;
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

        DoorKey key = ToolUtil.getDoorKey("room");
        DoorKey key2 = ToolUtil.getDoorKey("closet");
        DoorKey key3 = ToolUtil.getDoorKey("room");

        Tool tool2 = ToolUtil.getC();
        tool2.getAvailableActionTypes().clear();
        tool2.getAvailableActionTypes().add(ActionType.STEAL);

        Furniture dresser = new Furniture();
        dresser.setLongDescription("large dresser");
        dresser.setShortDescription("dresser");
        dresser.getAvailableToolPositions().add(FurniturePositions.IN);
        dresser.getAvailableToolPositions().add(FurniturePositions.ON);

//        dresser.addTool(FurniturePositions.IN, key);
        dresser.addTool(FurniturePositions.IN, key2);
        dresser.addTool(FurniturePositions.IN, key3);
        dresser.addTool(FurniturePositions.ON, ToolUtil.getC());
        dresser.addTool(FurniturePositions.ON, tool2);
        dresser.addTool(FurniturePositions.IN, ClothesUtil.getFHH(ClothesColor.WHITE, 5));
        dresser.addTool(FurniturePositions.IN, ClothesUtil.getFMD(ClothesColor.WHITE));

        closet.getFurniture().add(dresser);

        Furniture bed = new Furniture();
        bed.setLongDescription("large bed");
        bed.setShortDescription("bed");
        bed.getAvailablePositions().add(FurniturePositions.ON);
        
        Lock lock = new Lock(key);
        bed.addTool(FurniturePositions.BY, lock);

        Furniture sdresser = new Furniture();
        sdresser.setLongDescription("small dresser");
        sdresser.setShortDescription("sdresser");
        sdresser.getAvailableToolPositions().add(FurniturePositions.IN);
        sdresser.getAvailableToolPositions().add(FurniturePositions.ON);

        sdresser.addTool(FurniturePositions.IN, ClothesUtil.getMBC());
        sdresser.addTool(FurniturePositions.IN, ClothesUtil.getMLWCuff());
        sdresser.addTool(FurniturePositions.IN, ClothesUtil.getMRWCuff());

        Room room = new Room();
        room.setLongDescription("large room");
        room.setShortDescription("room");
        room.getFurniture().add(bed);
        room.getFurniture().add(sdresser);

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
        mBody.setCurrentFurniture(bed);
        mBody.setCurrentFurniturePosition(FurniturePositions.BY);
        mBody.addClothes(ClothesUtil.getMShorts(ClothesColor.WHITE));
        mBody.updateAvailableActionTypes();
        mBody.updateAvailableActions();

        List<CommonBody> bodies = new ArrayList<>();
        bodies.add(mBody);

        FBody fBody3 = getFBody("FBody3", room, sdresser, FurniturePositions.BY);
        fBody3.addTool(ToolUtil.getC());
        fBody3.addTool(key);
        bodies.add(fBody3);

//        FBody fBody = new FBody();
//        fBody.setName("fBody");
//        fBody.setCurrentRoom(closet);
//        fBody.setCurrentFurniture(dresser);
//        fBody.setCurrentFurniturePosition(FurniturePositions.BY);
//        bodies.add(fBody);
//        fBody.updateAvailableActionTypes();
//        fBody.updateAvailableActions();
//
//        FBody fBody2 = new FBody();
//        fBody2.setName("fBody2");
//        fBody2.setCurrentRoom(closet2);
//        fBody2.addClothes(ClothesUtil.getFHH(ClothesColor.BLACK, 5));
//        fBody2.addClothes(ClothesUtil.getFMD(ClothesColor.BLACK));
//        bodies.add(fBody2);
//        fBody2.updateAvailableActionTypes();
//        fBody2.updateAvailableActions();
        Scenario scenario = new Scenario();
        scenario.start(bodies);
    }

    private static FBody getFBody(String name, Room room, Furniture furn, FurniturePositions furnPos) {
        FBody fBody = new FBody();
        fBody.setName(name);
        fBody.setCurrentRoom(room);
        fBody.setCurrentFurniture(furn);
        fBody.setCurrentFurniturePosition(furnPos);
        fBody.addClothes(ClothesUtil.getFHH(ClothesColor.BLACK, 5));
        fBody.addClothes(ClothesUtil.getFMD(ClothesColor.BLACK));
        fBody.updateAvailableActionTypes();
        fBody.updateAvailableActions();

        return fBody;
    }
}
