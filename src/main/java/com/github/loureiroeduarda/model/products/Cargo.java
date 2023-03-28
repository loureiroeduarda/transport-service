package com.github.loureiroeduarda.model.products;

public class Cargo {
    int cellPhoneCounter;

    int refrigeratorCounter;

    int freezerCounter;

    int chairCounter;

    int lightingCounter;

    int washingMachineCounter;

    public Cargo(int cellPhoneCounter, int refrigeratorCounter, int freezerCounter, int chairCounter,
                 int lightingCounter, int washingMachineCounter) {
        this.cellPhoneCounter = cellPhoneCounter;
        this.refrigeratorCounter = refrigeratorCounter;
        this.freezerCounter = freezerCounter;
        this.chairCounter = chairCounter;
        this.lightingCounter = lightingCounter;
        this.washingMachineCounter = washingMachineCounter;
    }

    public int getCellPhoneCounter() {
        return cellPhoneCounter;
    }

    public int getRefrigeratorCounter() {
        return refrigeratorCounter;
    }

    public int getFreezerCounter() {
        return freezerCounter;
    }

    public int getChairCounter() {
        return chairCounter;
    }

    public int getLightingCounter() {
        return lightingCounter;
    }

    public int getWashingMachineCounter() {
        return washingMachineCounter;
    }
}
