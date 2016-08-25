
package com.sniffydn.sandbox.core.scenario.clothes;

import com.sniffydn.sandbox.core.scenario.CommonObject;
import com.sniffydn.sandbox.core.scenario.b.BodyPart;
import java.util.ArrayList;
import java.util.List;

public class Clothes extends CommonObject {
    private List<BodyPart> covers = new ArrayList<>();
    private int toolCapacity = 0;

    /**
     * @return the covers
     */
    public List<BodyPart> getCovers() {
        return covers;
    }

    /**
     * @return the toolCapacity
     */
    public int getToolCapacity() {
        return toolCapacity;
    }

    /**
     * @param toolCapacity the toolCapacity to set
     */
    public void setToolCapacity(int toolCapacity) {
        this.toolCapacity = toolCapacity;
    }
}
