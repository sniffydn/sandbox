package com.sniffydn.sandbox.core.scenario;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public abstract class ScenarioActionListener implements ActionListener {

    private static List<ScenarioListener> listeners = new ArrayList<>();

    public static void addListener(ScenarioListener listener) {
        listeners.add(listener);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        actionPerformed();
    }

    public void actionPerformed() {
        scenarioActionPerformed();
        for (ScenarioListener l : listeners) {
            l.eventFired();
        }
        for (ScenarioListener l : listeners) {
            l.postEventFired();
        }
        for (ScenarioListener l : listeners) {
            l.eventFiredCleanup();
        }
    }

    protected abstract void scenarioActionPerformed();
}
