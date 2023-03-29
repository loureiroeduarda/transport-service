package com.github.loureiroeduarda.repository;

import com.github.loureiroeduarda.model.truck.LargeTruck;
import com.github.loureiroeduarda.model.truck.MediumTruck;
import com.github.loureiroeduarda.model.truck.SmallTruck;
import com.github.loureiroeduarda.model.truck.Truck;

import java.util.ArrayList;
import java.util.List;

public class RepositoryTruck {
    private List<Truck> truckList;

    public RepositoryTruck() {
        this.truckList = new ArrayList<>();
    }

    public List<Truck> listAll() {
        return this.truckList;
    }

    public void saveTrucks() {
        Truck truckSmall = new SmallTruck();
        Truck truckMedium = new MediumTruck();
        Truck truckLarge = new LargeTruck();
        this.truckList.add(truckSmall);
        this.truckList.add(truckMedium);
        this.truckList.add(truckLarge);
    }

    public Truck getTruckById(int index) {
        return truckList.get(index);
    }
}
