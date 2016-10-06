package com.sniffydn.sandbox.core.scenario.t;

import com.sniffydn.sandbox.core.scenario.Action;
import com.sniffydn.sandbox.core.scenario.ActionType;
import com.sniffydn.sandbox.core.scenario.CommonBody;
import com.sniffydn.sandbox.core.scenario.CommonObject;
import com.sniffydn.sandbox.core.scenario.CustomAction;
import com.sniffydn.sandbox.core.scenario.ScenarioActionListener;
import com.sniffydn.sandbox.core.scenario.furniture.FurniturePositions;
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
    private List<String> keys = new ArrayList<String>();

    public abstract List<Action> getAvailableActionsByHolder(final CommonBody holder);

    protected List<Action> getCommonActions(final CommonBody holder) {
        boolean hasCode = true;
        if (keys.size() > 0) {
            hasCode = false;
            for (String key : keys) {
                if (holder.hasCode(key)) {
                    hasCode = true;
                    break;
                }
            }
        }

        List<Action> actions = new ArrayList<>();

        for (CustomAction ta : toolActions) {
            if (hasCode && ta.canPerformAction(holder)) {
                actions.add(ta.getAction());
            }
        }

        actions.addAll(getAttachmentActions(holder));

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
                        if (atTo.equals(at)) {
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

    /**
     * @return the keys
     */
    public List<String> getKeys() {
        return keys;
    }

    /**
     * @param keys the keys to set
     */
    public void addKey(String key) {
        keys.add(key);
    }

    private void attachTools(Attachment to, CommonBody holder, boolean hasCode, List<Action> actions) {
        for (final Tool t : holder.getTools()) {
            if (t != this) {
                parseAttachments(t, to, hasCode, actions, holder);
            }
        }
    }

    private void attachClothes(Attachment to, CommonBody holder, boolean hasCode, List<Action> actions) {
        for (final Tool t : holder.getClothes()) {
            if (t != this) {
                parseAttachments(t, to, hasCode, actions, holder);
            }
        }
    }

    private void parseAttachments(final Tool t, Attachment to, boolean hasCode, List<Action> actions, CommonBody holder) {
        for (Attachment tat : t.getAttachments()) {
            if (tat.equals(to)) {
                Action a = new Action(ActionType.GENERAL, "Attach " + getShortDescription() + " to " + t.getShortDescription(), new ScenarioActionListener() {

                    @Override
                    protected void scenarioActionPerformed() {
                        attachTo(t);
                    }
                });
                a.setActionShortDescription(getShortDescription() + " to " + t.getShortDescription());
                if (hasCode) {
                    actions.add(a);
                }

                for (final CommonBody b : holder.getCurrentRoom().getBodies()) {
                    boolean otherHasCode = true;
                    if (getKeys().size() > 0) {
                        otherHasCode = false;
                        for (String key : getKeys()) {
                            if (b.hasCode(key)) {
                                otherHasCode = true;
                                break;
                            }
                        }
                    }
                    if (b != holder
                            && otherHasCode
                            && b.getAvailableActionTypes().contains(ActionType.COMPEL)
                            && !holder.getAvailableActionTypes().contains(ActionType.RESIST_COMPEL)) {
                        b.addAction(a);
                    }
                }
            }
        }
    }

    public List<Action> getAttachmentActions(CommonBody holder) {
        List<Action> actions = new ArrayList<>();
        boolean hasCode = true;
        if (keys.size() > 0) {
            hasCode = false;
            for (String key : keys) {
                if (holder.hasCode(key)) {
                    hasCode = true;
                    break;
                }
            }
        }
        if (attachablePointCount > attachedTo.size()) {
            for (Attachment to : attachesTo) {
                attachTools(to, holder, hasCode, actions);
                attachClothes(to, holder, hasCode, actions);
//                System.out.println("Deal with " + holder.getCurrentFurniture());
            }
        }

        return actions;
    }

}
