package com.github.loureiroeduarda.model.truck;

public class LargeTruck implements Truck{

    private final String truckType = "grande porte";
    private final Double priceKm = 27.44;
    private final int weight = 10000;

    @Override
    public String getTruckType() {
        return truckType;
    }

    @Override
    public Double getPriceKm() {
        return priceKm;
    }

    @Override
    public int getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "Caminhão de " + truckType + ": R$ " + priceKm + " (preço por km rodado) e " + weight + " kg (capacidade máxima).";
    }
}
