package com.github.loureiroeduarda.model.transport;

import com.github.loureiroeduarda.model.truck.BestTruckCombo;

public class Transport {
    private final String cities;
    private final Double totalDistance;
    private final Double totalCargoWeight;
    private final String products;
    private final BestTruckCombo bestTruckCombo;
    private final Double totalTransportValue;
    private final Double averageShippingCost;

    public Transport(String cities, Double totalDistance, Double totalCargoWeight, String products,
                     BestTruckCombo bestTruckCombo, Double totalTransportValue, Double averageShippingCost) {
        this.cities = cities;
        this.totalDistance = totalDistance;
        this.totalCargoWeight = totalCargoWeight;
        this.products = products;
        this.bestTruckCombo = bestTruckCombo;
        this.totalTransportValue = totalTransportValue;
        this.averageShippingCost = averageShippingCost;
    }

    public String getCities() {
        return cities;
    }

    public Double getTotalDistance() {
        return totalDistance;
    }

    public Double getTotalCargoWeight() {
        return totalCargoWeight;
    }

    public String getProducts() {
        return products;
    }

    public BestTruckCombo getBestTruckCombo() {
        return bestTruckCombo;
    }

    public Double getTotalTransportValue() {
        return totalTransportValue;
    }

    public Double getAverageShippingCost() {
        return averageShippingCost;
    }
}
