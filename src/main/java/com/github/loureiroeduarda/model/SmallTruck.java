package com.github.loureiroeduarda.model;

public class SmallTruck implements Truck{
    private final String truckType = "pequeno porte";
    private final Double priceKm = 4.87;
    private final int weight = 1000;

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
