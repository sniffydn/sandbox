
package com.sniffydn.sandbox.core.sn;

import com.sniffydn.sandbox.core.sn.impl.Her;
import com.sniffydn.sandbox.core.sn.impl.Me;

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

    public void updateMapAdd(Her her, Me me) {
        
    }

    public void updateMapRemove(Her her, Me me) {
        
    }
}
