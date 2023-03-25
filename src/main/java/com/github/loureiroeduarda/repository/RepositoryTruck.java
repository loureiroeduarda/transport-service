package com.github.loureiroeduarda.repository;

import com.github.loureiroeduarda.model.SmallTruck;
import com.github.loureiroeduarda.model.Truck;

import java.util.ArrayList;
import java.util.List;

public class RepositoryTruck {
    List<Truck> truckList;

    public RepositoryTruck() {
        this.truckList = new ArrayList<>();
    }

    public void addTruck(Truck truck) {
        this.truckList.add(truck);
    }
}
