
package com.sniffydn.sandbox.core.scenario;

public abstract class ScenarioListener {
    public abstract void eventFired();
    public abstract void eventFiredCleanup();

    protected void postEventFired() {
    }
}
