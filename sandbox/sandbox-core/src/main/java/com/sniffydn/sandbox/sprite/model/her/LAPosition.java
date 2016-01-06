
package com.sniffydn.sandbox.sprite.model.her;

public enum LAPosition {
    ZERO("down"),
    ONE("hip"),
    TWO("why");

    private String desc = "";
    private LAPosition(String desc) {
        this.desc = desc;
    }

    /**
     * @return the desc
     */
    public String getDesc() {
        return desc;
    }


}
