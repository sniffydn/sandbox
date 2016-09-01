package com.sniffydn.sandbox.core.scenario;

import com.sniffydn.sandbox.core.scenario.furniture.FurniturePositions;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

public abstract class Tool extends CommonObject {

    protected int weight = 1;
    private int toolCapacity = 0;

    private List<ActionType> availableActionTypes = new ArrayList<>();

    public abstract List<Action> getAvailableActions(final CommonBody holder);

    protected List<Action> getCommonActions(final CommonBody holder) {
        List<Action> actions = new ArrayList<>();

        if (holder.getCurrentFurniture() != null && holder.getCurrentFurniturePosition() == FurniturePositions.BY) {
            for (final FurniturePositions position : holder.getCurrentFurniture().getAvailableToolPositions()) {
                Action a = new Action(ActionType.TOOL, "Put " + getShortDescription() + " " + position + " " + holder.getCurrentFurniture().getShortDescription(), new ScenarioActionListener() {

                    @Override
                    protected void scenarioActionPerformed(ActionEvent e) {
                        holder.removeTool(Tool.this);
                        holder.getCurrentFurniture().addTool(position, Tool.this);
                    }
                });
                a.setActionShortDescription("Put " + position + " " + holder.getCurrentFurniture().getShortDescription());
                a.setCurrentFurniture(holder.getCurrentFurniture());
                actions.add(a);
            }
        }

        if (holder.getCurrentRoom().getBodies().size() > 1) {
            for (final CommonBody b : holder.getCurrentRoom().getBodies()) {
                if (b != holder && b.getCurrentToolCarry() + weight <= b.getMaxToolCapacity()) {
                    Action a = new Action(ActionType.TOOL, "Give " + getShortDescription() + " to " + b.getName(), new ScenarioActionListener() {

                        @Override
                        protected void scenarioActionPerformed(ActionEvent e) {
                            holder.removeTool(Tool.this);
                            b.addTool(Tool.this);
                        }
                    });
                    a.setActionShortDescription("Give to " + b.getName());
                    actions.add(a);

                    if (!holder.getAvailableActionTypes().contains(ActionType.RESIST_STEAL)) {
                        Action a1 = new Action(ActionType.STEAL, "Take " + getShortDescription() + " from " + holder.getName(), new ScenarioActionListener() {

                            @Override
                            protected void scenarioActionPerformed(ActionEvent e) {
                                holder.removeTool(Tool.this);
                                b.addTool(Tool.this);
                            }
                        });
                        a1.setActionShortDescription("Take");
                        b.addAction(a1);
                    }
                }
            }
        }

        for (Action a : actions) {
            a.setCurrentTool(this);
        }

        return actions;
    }

    /**
     * @return the weight
     */
    public int getWeight() {
        return weight;
    }

    /**
     * @param weight the weight to set
     */
    public void setWeight(int weight) {
        this.weight = weight;
    }

    /**
     * @return the toolCapacity
     */
    public int getToolCapacity() {
        return toolCapacity;
    }

    /**
     * @param toolCapacity the toolCapacity to set
     */
    public void setToolCapacity(int toolCapacity) {
        this.toolCapacity = toolCapacity;
    }

    /**
     * @return the availableActionTypes
     */
    public List<ActionType> getAvailableActionTypes() {
        return availableActionTypes;
    }

}
