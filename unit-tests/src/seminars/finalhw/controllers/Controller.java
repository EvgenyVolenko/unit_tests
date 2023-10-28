package seminars.finalhw.controllers;

import seminars.finalhw.model.ArrayModule;

public class Controller {
    private final ArrayModule arrayModule;

    public Controller(final ArrayModule arrayModule) {
        this.arrayModule = arrayModule;
    }

    public int[] fillArrayController(final int size, final int maxValue, final int minValue) {
        return arrayModule.fillArray(size, maxValue, minValue);
    }

    public String compareAveragesController(final double average1, final double average2) {
        return arrayModule.compareAverages(average1, average2);
    }

    public double averageValueController(final int[] arr) {
        return arrayModule.averageValue(arr);
    }
}
