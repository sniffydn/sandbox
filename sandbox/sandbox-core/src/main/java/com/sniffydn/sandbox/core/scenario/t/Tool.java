package com.sniffydn.sandbox.core.scenario.t;

import com.sniffydn.sandbox.core.scenario.Action;
import com.sniffydn.sandbox.core.scenario.ActionType;
import com.sniffydn.sandbox.core.scenario.CommonBody;
import com.sniffydn.sandbox.core.scenario.CommonObject;
import com.sniffydn.sandbox.core.scenario.CustomAction;
import com.sniffydn.sandbox.core.scenario.ScenarioActionListener;
import com.sniffydn.sandbox.core.scenario.furniture.FurniturePositions;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

public abstract class Tool extends CommonObject {

    protected int weight = 1;
    private int toolCapacity = 0;

    private List<ActionType> availableActionTypes = new ArrayList<>();
    private List<CustomAction> toolActions = new ArrayList<>();
    private List<Tool> attachedTo = new ArrayList<>();
    private List<Attachment> attachesTo = new ArrayList<>();
    private List<Attachment> attachments = new ArrayList<>();
    private int attachablePointCount = 0;

    public abstract List<Action> getAvailableActionsByHolder(final CommonBody holder);

    protected List<Action> getCommonActions(final CommonBody holder) {
        List<Action> actions = new ArrayList<>();

        for (CustomAction ta : toolActions) {
            if (ta.canPerformAction(holder)) {
                actions.add(ta.getAction());
            }
        }

        if (holder.getCurrentFurniture() != null && holder.getCurrentFurniture().getAvailableToolPositions().contains(FurniturePositions.BY)) {
            for (final FurniturePositions position : holder.getCurrentFurniture().getAvailableToolPositions()) {
                Action a = new Action(ActionType.TOOL, "Put " + getShortDescription() + " " + position + " " + holder.getCurrentFurniture().getShortDescription(), new ScenarioActionListener() {

                    @Override
                    protected void scenarioActionPerformed() {
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
                        protected void scenarioActionPerformed() {
                            holder.removeTool(Tool.this);
                            b.addTool(Tool.this);
                        }
                    });
                    a.setActionReciever(b);
                    a.setActionShortDescription("Give to " + b.getName());
                    actions.add(a);

                    if (!holder.getAvailableActionTypes().contains(ActionType.RESIST_STEAL)) {
                        Action a1 = new Action(ActionType.STEAL, "Take " + getShortDescription() + " from " + holder.getName(), new ScenarioActionListener() {

                            @Override
                            protected void scenarioActionPerformed() {
                                holder.removeTool(Tool.this);
                                b.addTool(Tool.this);
                            }
                        });
                        a1.setActionReciever(b);
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

    /**
     * @return the toolActions
     */
    public List<CustomAction> getToolActions() {
        return toolActions;
    }

    /**
     * @return the attachedTo
     */
    public List<Tool> getAttachedTo() {
        return attachedTo;
    }

    /**
     * @return the attachments
     */
    public List<Attachment> getAttachments() {
        return attachments;
    }

    /**
     * @return the attachesTo
     */
    public List<Attachment> getAttachesTo() {
        return attachesTo;
    }

    public boolean canAttachTo(Tool otherTool) {
        if (attachablePointCount > attachedTo.size()) {
            if (otherTool.attachablePointCount > otherTool.attachedTo.size()) {
                for (Attachment atTo : attachesTo) {
                    for (Attachment at : attachments) {
                        if(atTo.equals(at)) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public void attachTo(Tool otherTool) {
        attachedTo.add(otherTool);
        otherTool.attachedTo.add(this);
    }

    /**
     * @return the attachablePointCount
     */
    public int getAttachablePointCount() {
        return attachablePointCount;
    }

    /**
     * @param attachablePointCount the attachablePointCount to set
     */
    public void setAttachablePointCount(int attachablePointCount) {
        this.attachablePointCount = attachablePointCount;
    }
}
