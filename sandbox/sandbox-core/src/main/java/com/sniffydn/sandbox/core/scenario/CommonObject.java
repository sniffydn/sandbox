
package com.sniffydn.sandbox.core.scenario;

public class CommonObject {
    private boolean descriptionCalled = false;
    private String shortDescription;
    private String longDescription;

    /**
     * @return the longDescription
     */
    public String getLongDescription() {
        return longDescription;
    }

    /**
     * @param longDescription the longDescription to set
     */
    public void setLongDescription(String longDescription) {
        this.longDescription = longDescription;
    }

    /**
     * @return the shortDescription
     */
    public String getShortDescription() {
        return shortDescription;
    }

    /**
     * @param shortDescription the shortDescription to set
     */
    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getDescription() {
        if(descriptionCalled) {
            return getShortDescription();
        } else {
            descriptionCalled = true;
            return getLongDescription();
        }
    }
}
