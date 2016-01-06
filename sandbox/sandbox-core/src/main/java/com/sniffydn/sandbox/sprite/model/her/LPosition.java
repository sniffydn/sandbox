
package com.sniffydn.sandbox.sprite.model.her;

import java.util.ArrayList;
import java.util.List;

public enum LPosition {
    ZERO,
    ONE,
    TWO,
    THREE,
    FOUR,
    FIVE,
    SIX,
    SEVEN,
    EIGHT,
    NINE,
    TEN,
    ELEVEN,
    TWELVE,
    THIRTEEN,
    FOURTEEN,
    FIFTEEN;

    /**
     * @return the possibleNextSteps
     */
    public List<LPosition> getPossibleNextSteps() {
        List<LPosition> position = new ArrayList<>();

        if(this.equals(ZERO)) {
            position.add(ONE);
        } else if(this.equals(ONE)) {
            position.add(TWO);
        } else if(this.equals(TWO)) {
            position.add(THREE);
        } else if(this.equals(THREE)) {
            position.add(FOUR);
        } else if(this.equals(FOUR)) {
            position.add(FIVE);
        } else if(this.equals(FIVE)) {
            position.add(SIX);
        } else if(this.equals(SIX)) {
            position.add(SEVEN);
        } else if(this.equals(SEVEN)) {
            position.add(EIGHT);
        } else if(this.equals(EIGHT)) {
            position.add(NINE);
        } else if(this.equals(NINE)) {
            position.add(TEN);
        } else if(this.equals(TEN)) {
            position.add(ELEVEN);
        } else if(this.equals(ELEVEN)) {
            position.add(TWELVE);
        } else if(this.equals(TWELVE)) {
            position.add(THIRTEEN);
        } else if(this.equals(THIRTEEN)) {
            position.add(FOURTEEN);
        } else if(this.equals(FOURTEEN)) {
            position.add(FIFTEEN);
        } else if(this.equals(FIFTEEN)) {
            position.add(ZERO);
        }

        return position;
    }


}
