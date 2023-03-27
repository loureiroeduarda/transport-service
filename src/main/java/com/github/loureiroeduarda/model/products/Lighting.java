package com.github.loureiroeduarda.model.products;

public class Lighting implements Products{

    private final String productType = "Luminária";

    private final Double weightProduct = 0.8;

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
