
package com.sniffydn.sandbox.core.scenario.ui;

import com.sniffydn.sandbox.core.scenario.clothes.Clothes;
import java.awt.Color;

public class ClothesRenderer extends ToolRenderer {

    private Clothes clothes;

    public ClothesRenderer(Clothes clothes) {
        super(clothes);
        this.clothes = clothes;

        setBackground(new Color(200,200, 200));
    }

    /**
     * @return the clothes
     */
    public Clothes getClothes() {
        return clothes;
    }

}
