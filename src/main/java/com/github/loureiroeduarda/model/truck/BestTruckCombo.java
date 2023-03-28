package com.github.loureiroeduarda.model.truck;

public class BestTruckCombo {
    private String truckType;
    private double quantityTrucks;
    private double bestCost;

    public BestTruckCombo() {
        this.truckType = "";
        this.quantityTrucks = 0;
        this.bestCost = Double.MAX_VALUE;
    }

    public String getTruckType() {
        return truckType;
    }

    public void setTruckType(String truckType) {
        this.truckType = truckType;
    }

    public double getQuantityTrucks() {
        return quantityTrucks;
    }

    public void setQuantityTrucks(double quantityTrucks) {
        this.quantityTrucks = quantityTrucks;
    }

    public double getBestCost() {
        return bestCost;
    }

    public void setBestCost(double bestCost) {
        this.bestCost = bestCost;
    }
}
