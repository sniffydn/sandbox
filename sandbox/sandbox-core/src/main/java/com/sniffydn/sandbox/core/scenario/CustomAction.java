package com.sniffydn.sandbox.core.scenario;

import java.awt.event.ActionEvent;

public abstract class CustomAction {

    private Action action;
    private CommonBody holder;

    public CustomAction(ActionType type, String actionDescription) {
        this.action = new Action(type, actionDescription, new ScenarioActionListener() {

            @Override
            protected void scenarioActionPerformed() {
                performAction(holder);
            }
        });
    }

    public boolean canPerformAction(CommonBody holder) {
        this.holder = holder;
        return canPerformActionCheck(holder);
    }

    /**
     * @return the action
     */
    public Action getAction() {
        return action;
    }

    protected abstract boolean canPerformActionCheck(CommonBody holder);

    protected abstract void performAction(CommonBody holder);
}
