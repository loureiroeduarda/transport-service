package com.github.loureiroeduarda.model.products;

public class Freezer implements Products{

    private final String productType = "Freezer";

    private final Double weightProduct = 100.0;

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
