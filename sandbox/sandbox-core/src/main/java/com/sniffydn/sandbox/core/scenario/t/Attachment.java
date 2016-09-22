
package com.sniffydn.sandbox.core.scenario.t;

public enum Attachment {
    RING(true);

    private boolean lockable = false;

    private Attachment(boolean lockable) {
        this.lockable = lockable;
    }

    /**
     * @return the lockable
     */
    public boolean isLockable() {
        return lockable;
    }
}
