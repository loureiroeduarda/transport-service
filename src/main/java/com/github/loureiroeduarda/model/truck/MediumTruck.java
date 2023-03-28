package com.github.loureiroeduarda.model.truck;

public class MediumTruck implements Truck {
    private final String truckType = "médio porte";
    private final Double priceKm = 11.92;
    private final int weight = 4000;

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
