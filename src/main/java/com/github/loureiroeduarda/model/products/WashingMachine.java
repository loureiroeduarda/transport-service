package com.github.loureiroeduarda.model.products;

public class WashingMachine implements Products{

    private final String productType = "Máquina de lavar roupa";

    private final Double weightProduct = 120.0;

    @Override
    public String productType() {
        return productType;
    }

    @Override
    public Double getWeightProduct() {
        return weightProduct;
    }

    @Override
    public String toString() {
        return productType +
               " - Peso do produto: " + weightProduct;
    }
}
