
package com.sniffydn.sandbox.sprite.model.her;

public enum MPosition {
    LEFT(0),
    BALANCED(216),
    RIGHT(432);

    private int x;

    private MPosition(int x) {
        this.x = x;
    }

    public int getX() {
        return x;
    }
}
