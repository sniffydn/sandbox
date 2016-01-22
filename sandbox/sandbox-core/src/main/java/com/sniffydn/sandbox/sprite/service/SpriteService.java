
package com.sniffydn.sandbox.sprite.service;

import com.sniffydn.sandbox.sprite.model.Room;
import com.sniffydn.sandbox.sprite.model.her.Her;
import com.sniffydn.sandbox.sprite.model.me.Me;

public class SpriteService {

    private static SpriteService instance;

    private SpriteService() {
    }

    public static SpriteService getInstance() {
        if(instance == null) {
            instance = new SpriteService();
        }
        return instance;
    }

    public void initiateScenario(Room room, Her her, Me me) {
        
    }

}
