package com.sniffydn.sandbox.core.scenario.furniture;

import com.sniffydn.sandbox.core.scenario.Action;
import com.sniffydn.sandbox.core.scenario.ActionType;
import com.sniffydn.sandbox.core.scenario.CommonBody;
import com.sniffydn.sandbox.core.scenario.CommonObject;
import com.sniffydn.sandbox.core.scenario.ScenarioActionListener;
import com.sniffydn.sandbox.core.scenario.Tool;
import com.sniffydn.sandbox.core.scenario.clothes.Clothes;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Furniture extends CommonObject {

    private List<FurniturePositions> availablePositions = new ArrayList<>();
    private List<FurniturePositions> availableToolPositions = new ArrayList<>();
    private Map<FurniturePositions, List<Tool>> toolMap = new HashMap<>();


    private List<FurniturePositions> availableClothesPositions = new ArrayList<>();
    private Map<FurniturePositions, List<Clothes>> clothesMap = new HashMap<>();

    public Furniture() {
        availablePositions.add(FurniturePositions.BY);
        availableToolPositions.add(FurniturePositions.BY);
        availableClothesPositions.add(FurniturePositions.BY);
    }

    /**
     * @return the availablePositions
     */
    public List<FurniturePositions> getAvailablePositions() {
        return availablePositions;
    }

    public List<Action> getAvailableActions(final CommonBody body) {
        List<Action> actions = new ArrayList<>();
        if (body.getCurrentFurniturePosition().equals(FurniturePositions.BY)) {
            for (FurniturePositions position : availableToolPositions) {
                if (!toolMap.containsKey(position)) {
                    getToolMap().put(position, new ArrayList<Tool>());
                } else {
                    final List<Tool> tools = getToolMap().get(position);
                    for (Tool tool : tools) {
                        if (body.getCurrentToolCarry() + tool.getWeight() <= body.getMaxToolCapacity()) {
                            final Tool t = tool;
                            Action a = new Action(ActionType.FURNITURE, "Get " + tool.getShortDescription() + " " + position + " " + getShortDescription(),
                                    new ScenarioActionListener() {

                                        @Override
                                        protected void scenarioActionPerformed(ActionEvent e) {
                                            body.getTools().add(t);
                                            body.setCurrentToolCarry(body.getCurrentToolCarry() + t.getWeight());
                                            tools.remove(t);
                                        }
                                    });
                            actions.add(a);
                        }
                    }
                }
            }

            for (FurniturePositions position : availableClothesPositions) {
                if (!clothesMap.containsKey(position)) {
                    getClothesMap().put(position, new ArrayList<Clothes>());
                } else {
                    final List<Clothes> clothes = getClothesMap().get(position);
                    for (Clothes piece : clothes) {
                        if (body.canAdd(piece)) {
                            final Clothes c = piece;
                            Action a = new Action(ActionType.FURNITURE, "Put on " + piece.getShortDescription() + " " + position + " " + getShortDescription(),
                                    new ScenarioActionListener() {

                                        @Override
                                        protected void scenarioActionPerformed(ActionEvent e) {
                                            body.addClothes(c);
                                            clothes.remove(c);
                                        }
                                    });
                            actions.add(a);
                        }
                    }
                }
            }
        } else {
            System.out.println("Deal with " + body.getCurrentFurniturePosition());
        }

        return actions;
    }

    /**
     * @return the availableToolPositions
     */
    public List<FurniturePositions> getAvailableToolPositions() {
        return availableToolPositions;
    }

    /**
     * @return the toolMap
     */
    public Map<FurniturePositions, List<Tool>> getToolMap() {
        return toolMap;
    }

    public void addTool(FurniturePositions position, Tool t) {
        if (availableToolPositions.contains(position)) {
            if (!toolMap.containsKey(position)) {
                getToolMap().put(position, new ArrayList<Tool>());
            }
            List<Tool> tools = getToolMap().get(position);
            tools.add(t);
        } else {
            throw new RuntimeException(getShortDescription() + " does not contain t " + position);
        }
    }

    /**
     * @return the availableClothesPositions
     */
    public List<FurniturePositions> getAvailableClothesPositions() {
        return availableClothesPositions;
    }

    /**
     * @return the clothesMap
     */
    public Map<FurniturePositions, List<Clothes>> getClothesMap() {
        return clothesMap;
    }

    public void addClothes(FurniturePositions position, Clothes t) {
        if (availableClothesPositions.contains(position)) {
            if (!getClothesMap().containsKey(position)) {
                getClothesMap().put(position, new ArrayList<Clothes>());
            }
            List<Clothes> clothes = getClothesMap().get(position);
            clothes.add(t);
        } else {
            throw new RuntimeException(getShortDescription() + " does not contain c " + position);
        }
    }
}
