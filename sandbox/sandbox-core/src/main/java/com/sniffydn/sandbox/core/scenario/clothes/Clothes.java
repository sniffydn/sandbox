package com.sniffydn.sandbox.core.scenario.clothes;

import com.sniffydn.sandbox.core.scenario.Action;
import com.sniffydn.sandbox.core.scenario.ActionType;
import com.sniffydn.sandbox.core.scenario.CommonBody;
import com.sniffydn.sandbox.core.scenario.ScenarioActionListener;
import com.sniffydn.sandbox.core.scenario.Tool;
import com.sniffydn.sandbox.core.scenario.b.BodyPart;
import com.sniffydn.sandbox.core.scenario.furniture.FurniturePositions;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

public class Clothes extends Tool {

    private List<BodyPart> covers = new ArrayList<>();
    private BodyType bodyType = BodyType.B;

    /**
     * @return the covers
     */
    public List<BodyPart> getCovers() {
        return covers;
    }

    public List<Action> getAvailableActions(final CommonBody holder) {
        List<Action> actions = new ArrayList<>();
        if (holder.hasClothes(this)) {
            if (holder.getCurrentFurniture() != null && holder.getCurrentFurniturePosition() == FurniturePositions.BY) {
                for (final FurniturePositions position : holder.getCurrentFurniture().getAvailableToolPositions()) {
                    Action a = new Action(ActionType.TOOL, "Put " + getShortDescription() + " " + position + " " + holder.getCurrentFurniture().getShortDescription(), new ScenarioActionListener() {

                        @Override
                        protected void scenarioActionPerformed(ActionEvent e) {
                            holder.removeClothes(Clothes.this);
                            holder.getCurrentFurniture().addTool(position, Clothes.this);
                        }
                    });
                    a.setActionShortDescription("Put " + position + " " + holder.getCurrentFurniture().getShortDescription());
                    a.setCurrentFurniture(holder.getCurrentFurniture());
                    actions.add(a);
                }
            }

            if (holder.getCurrentRoom().getBodies().size() > 1) {
                for (final CommonBody b : holder.getCurrentRoom().getBodies()) {
                    if (b != holder && b.getCurrentFurniture() == holder.getCurrentFurniture() && b.getCurrentToolCarry() + weight <= b.getMaxToolCapacity()) {
                        if (!holder.getAvailableActionTypes().contains(ActionType.RESIST_STEAL)) {
                            Action a1 = new Action(ActionType.STEAL, "Take " + getShortDescription() + " off of " + holder.getName(), new ScenarioActionListener() {

                                @Override
                                protected void scenarioActionPerformed(ActionEvent e) {
                                    holder.removeClothes(Clothes.this);
                                    b.addTool(Clothes.this);
                                }
                            });
                            a1.setActionReciever(holder);
                            a1.setActionShortDescription("Take");
                            a1.setCurrentFurniture(holder.getCurrentFurniture());
                            b.addAction(a1);
                        }
                        if (!holder.getAvailableActionTypes().contains(ActionType.RESIST_COMPEL)) {
                            Action a1 = new Action(ActionType.COMPEL, "Make " + b.getName() + " take off " + getShortDescription(), new ScenarioActionListener() {

                                @Override
                                protected void scenarioActionPerformed(ActionEvent e) {
                                    holder.removeClothes(Clothes.this);
                                    holder.addTool(Clothes.this);
                                }
                            });
                            a1.setActionReciever(holder);
                            b.addAction(a1);
                        }
                    }
                }
            }
        } else {
            actions = getCommonActions(holder);

            if (holder.canAdd(this)) {
                Action a1 = new Action(ActionType.TOOL, "Put " + getShortDescription() + " on", new ScenarioActionListener() {

                    @Override
                    protected void scenarioActionPerformed(ActionEvent e) {
                        holder.removeTool(Clothes.this);
                        holder.addClothes(Clothes.this);
                    }
                });
                a1.setCurrentTool(this);
                a1.setActionShortDescription("Put on");
                holder.addAction(a1);
            }

            if (holder.getCurrentRoom().getBodies().size() > 1) {
                for (final CommonBody b : holder.getCurrentRoom().getBodies()) {
                    if (b != holder && b.canAdd(this) && b.getCurrentFurniture() == holder.getCurrentFurniture()) {
                        if (!b.getAvailableActionTypes().contains(ActionType.RESIST_COMPEL)) {
                            Action a1 = new Action(ActionType.COMPEL, "Put " + getShortDescription() + " on " + b.getName(), new ScenarioActionListener() {

                                @Override
                                protected void scenarioActionPerformed(ActionEvent e) {
                                    holder.removeTool(Clothes.this);
                                    b.addClothes(Clothes.this);
                                }
                            });
                            a1.setActionReciever(holder);
                            a1.setActionShortDescription("Put on");
                            holder.addAction(a1);
                        }
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
     * @return the bodyType
     */
    public BodyType getBodyType() {
        return bodyType;
    }

    /**
     * @param bodyType the bodyType to set
     */
    public void setBodyType(BodyType bodyType) {
        this.bodyType = bodyType;
    }
}
