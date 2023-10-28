package seminars.finalHW.controllers;

import seminars.finalHW.model.ArrayModule;

public class Controller {
    private final ArrayModule arrayModule;

    public Controller(ArrayModule arrayModule) {
        this.arrayModule = arrayModule;
    }

    public int[] fillArrayController(int size, int maxValue, int minValue) {
        return arrayModule.fillArray(size, maxValue, minValue);
    }

    public String compareAveragesController(double average1, double average2) {
        return arrayModule.compareAverages(average1, average2);
    }

    public double averageValueController(int[] arr) {
        return arrayModule.averageValue(arr);
    }
}
