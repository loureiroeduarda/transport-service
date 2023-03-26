package com.github.loureiroeduarda.model;

public class Chair implements Products{

    private final String productType = "Cadeira";

    private final Double weightProduct = 5.0;

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
        return "Produto: " + productType +
               "Peso do produto: " + weightProduct;
    }
}
