package com.github.loureiroeduarda.model;

public class CellPhone implements Products {

    private final String productType = "Celular";

    private final Double weightProduct = 0.5;

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
