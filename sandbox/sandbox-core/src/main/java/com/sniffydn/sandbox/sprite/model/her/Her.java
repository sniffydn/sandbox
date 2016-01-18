
package com.sniffydn.sandbox.sprite.model.her;

import com.sniffydn.sandbox.sprite.model.her.clts.Accessory;
import com.sniffydn.sandbox.sprite.model.her.clts.AccessoryType;
import java.util.ArrayList;
import java.util.List;

public class Her {

    private List<Accessory> accessories = new ArrayList<>(); //string with location (map)?
    boolean right = false;
    boolean left = false;

    public boolean addAccessory(Accessory accessory) {
        if(accessory.getType().equals(AccessoryType.BH)) {
            if(right || left) {
                return false;
            } else {
                right = true;
                left = true;
                return true;
            }
        } else if(accessory.getType().equals(AccessoryType.RH)) {
            if(right) {
                return false;
            } else {
                right = true;
                return true;
            }
        } else if(accessory.getType().equals(AccessoryType.LH)) {
            if(left) {
                return false;
            } else {
                left = true;
                return true;
            }
        } else if(accessory.getType().equals(AccessoryType.NH)) {
            return true;
        }
        return false;
    }

    /**
     * @return the accessories
     */
    public List<Accessory> getAccessories() {
        return accessories;
    }

}
