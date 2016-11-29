
package com.sniffydn.sandbox.core.sn;

public class Item {
    protected String description;
    protected String longDescripion;

    private boolean first = true;
    /**
     * @return the description
     */
    public String getDescription() {
        if(first) {
            first = false;
            return longDescripion;
        }
        return description;
    }

    public String print() {
        return getDescription();
    }
}
