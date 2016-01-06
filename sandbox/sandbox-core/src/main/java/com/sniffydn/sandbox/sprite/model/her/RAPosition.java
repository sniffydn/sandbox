
package com.sniffydn.sandbox.sprite.model.her;

public enum RAPosition {
    ZERO("down"),
    ONE("hip"),
    TWO("why");

    private String desc = "";
    private RAPosition(String desc) {
        this.desc = desc;
    }

    /**
     * @return the desc
     */
    public String getDesc() {
        return desc;
    }


}
