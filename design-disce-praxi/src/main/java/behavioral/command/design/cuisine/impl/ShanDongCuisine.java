package behavioral.command.design.cuisine.impl;

import behavioral.command.design.cook.ICook;
import behavioral.command.design.cuisine.ICuisine;

public class ShanDongCuisine implements ICuisine {

    private ICook cook;

    public ShanDongCuisine(ICook cook) {
        this.cook = cook;
    }

    public void cook() {
        cook.doCooking();
    }

}
