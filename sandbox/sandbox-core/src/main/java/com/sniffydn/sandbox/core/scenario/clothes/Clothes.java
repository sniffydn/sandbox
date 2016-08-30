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

    /**
     * @return the covers
     */
    public List<BodyPart> getCovers() {
        return covers;
    }

    public List<Action> getAvailableActions(final CommonBody holder) {
        List<Action> actions = new ArrayList<>();
        if (holder.getClothes().contains(this)) {
            if (holder.getCurrentFurniture() != null && holder.getCurrentFurniturePosition() == FurniturePositions.BY) {
                for (final FurniturePositions position : holder.getCurrentFurniture().getAvailableToolPositions()) {
                    Action a = new Action(ActionType.FURNITURE, "Put " + getShortDescription() + " " + position + " " + holder.getCurrentFurniture().getShortDescription(), new ScenarioActionListener() {

                        @Override
                        protected void scenarioActionPerformed(ActionEvent e) {
                            holder.getClothes().remove(Clothes.this);
                            holder.getCurrentFurniture().addTool(position, Clothes.this);
                        }
                    });
                    a.setCurrentFurniture(holder.getCurrentFurniture());
                    actions.add(a);
                }
            }

            if (holder.getCurrentRoom().getBodies().size() > 1) {
                for (final CommonBody b : holder.getCurrentRoom().getBodies()) {
                    if (b != holder) {
                        for (final FurniturePositions position : holder.getCurrentFurniture().getAvailableToolPositions()) {
                            Action a1 = new Action(ActionType.STEAL, "Take " + getShortDescription() + " off of " + holder.getName() + " and put " + " " + position + " " + holder.getCurrentFurniture().getShortDescription(), new ScenarioActionListener() {

                                @Override
                                protected void scenarioActionPerformed(ActionEvent e) {
                                    holder.getClothes().remove(Clothes.this);
                                    holder.getCurrentFurniture().addTool(position, Clothes.this);
                                }
                            });
                            a1.setCurrentFurniture(holder.getCurrentFurniture());
                            b.addAction(a1);
                        }
                    }
                }
            }
        } else {
            actions = getCommonActions(holder);

            if (holder.getCurrentRoom().getBodies().size() > 1) {
                for (final CommonBody b : holder.getCurrentRoom().getBodies()) {
                    if (b != holder && b.canAdd(this)) {
                        Action a1 = new Action(ActionType.COMPEL, "Put " + getShortDescription() + " on " + b.getName(), new ScenarioActionListener() {

                            @Override
                            protected void scenarioActionPerformed(ActionEvent e) {
                                holder.getClothes().remove(Clothes.this);
                                b.addClothes(Clothes.this);
                            }
                        });
                        a1.setCurrentFurniture(holder.getCurrentFurniture());
                        b.addAction(a1);
                    }
                }
            }
        }

        return actions;
    }
}
