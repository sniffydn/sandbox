
package com.sniffydn.sandbox.core.scenario.clothes;

import com.sniffydn.sandbox.core.scenario.ActionType;
import com.sniffydn.sandbox.core.scenario.b.ACheek;
import com.sniffydn.sandbox.core.scenario.b.Foot;
import com.sniffydn.sandbox.core.scenario.b.Groin;
import com.sniffydn.sandbox.core.scenario.b.T;
import com.sniffydn.sandbox.core.scenario.b.Torso;
import com.sniffydn.sandbox.core.scenario.t.Attachment;

public class ClothesUtil {
    public static Clothes getFHH(ClothesColor color, int h) {
        Clothes clothes = new Clothes();
        clothes.setBodyType(BodyType.F);
        clothes.getClothesTypes().add(ClothesType.SHOES);
        clothes.getCovers().add(new Foot(Boolean.TRUE));
        clothes.getCovers().add(new Foot(Boolean.FALSE));
        clothes.setShortDescription("hh");
        clothes.setLongDescription(color + " " + h + " hh");
        clothes.getAvailableActionTypes().add(ActionType.RESIST_STEAL);
        clothes.getAvailableActionTypes().add(ActionType.RESIST_COMPEL);


        return clothes;
    }

    public static Clothes getFMD(ClothesColor clothesColor) {
        Clothes clothes = new Clothes();
        clothes.setBodyType(BodyType.F);
        clothes.getClothesTypes().add(ClothesType.TOP);
        clothes.getClothesTypes().add(ClothesType.BOTTOM);
        clothes.getCovers().add(new Torso());
        clothes.setToolCapacity(1);
        clothes.setShortDescription("md");
        clothes.setLongDescription(clothesColor + " md");

        return clothes;
    }

    public static Clothes getMShorts(ClothesColor clothesColor) {
        Clothes clothes = new Clothes();
        clothes.setBodyType(BodyType.M);
        clothes.getCovers().add(new ACheek(Boolean.TRUE));
        clothes.getCovers().add(new ACheek(Boolean.FALSE));
        clothes.getCovers().add(new Groin());

        clothes.getClothesTypes().add(ClothesType.BOTTOM);
        clothes.setShortDescription(clothesColor + " shorts");
        clothes.setLongDescription(clothesColor + " shorts description");

        return clothes;
    }

    public static Clothes getMBC() {
        Clothes clothes = new Clothes();
        clothes.setBodyType(BodyType.M);
        clothes.getCovers().add(new T());

        clothes.getClothesTypes().add(ClothesType.UNDER_BOTTOM);
        clothes.setShortDescription(" bc");
        clothes.setLongDescription(" bc description with a ring attached");

        clothes.getAttachments().add(Attachment.RING);

        return clothes;
    }
}
