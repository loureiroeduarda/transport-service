package com.github.loureiroeduarda.model.products;

public class Refrigerator implements Products {

    private final String productType = "Geladeira";

    private final Double weightProduct = 60.0;

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
