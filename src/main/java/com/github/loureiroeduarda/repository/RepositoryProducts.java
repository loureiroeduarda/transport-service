package com.github.loureiroeduarda.repository;

import com.github.loureiroeduarda.model.*;

import java.util.ArrayList;
import java.util.List;

public class RepositoryProducts {
    List<Products> productsList;

    public RepositoryProducts() {
        this.productsList = new ArrayList<>();
    }

    public List<Products> listAll() {
        return this.productsList;
    }

    public void saveProducts() {
        Products cellPhone = new CellPhone();
        Products refrigerator = new Refrigerator();
        Products freezer = new Freezer();
        Products chair = new Chair();
        Products lighting = new Lighting();
        Products washingMachine = new WashingMachine();
        this.productsList.add(cellPhone);
        this.productsList.add(refrigerator);
        this.productsList.add(freezer);
        this.productsList.add(chair);
        this.productsList.add(lighting);
        this.productsList.add(washingMachine);
    }

    public Products getProductsById(int index) {
        return productsList.get(index);
    }
}
