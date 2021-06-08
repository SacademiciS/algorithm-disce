package behavioral.command.design.cuisine.impl;

import behavioral.command.design.cook.ICook;
import behavioral.command.design.cuisine.ICuisine;

public class JiangSuCuisine implements ICuisine {

    private ICook cook;

    public JiangSuCuisine(ICook cook) {
        this.cook = cook;
    }

    public void cook() {
        cook.doCooking();
    }

}
