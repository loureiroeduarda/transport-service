package com.github.loureiroeduarda.service;

import com.github.loureiroeduarda.csv.ReadCsv;
import com.github.loureiroeduarda.model.LargeTruck;
import com.github.loureiroeduarda.model.MediumTruck;
import com.github.loureiroeduarda.model.SmallTruck;
import com.github.loureiroeduarda.model.Truck;
import com.github.loureiroeduarda.repository.RepositoryTruck;

import java.util.List;

public class Service {
    private final ReadCsv readCsv;

    public Service() {
        this.readCsv = new ReadCsv();
    }

    public void RepositoryTruck(){
        RepositoryTruck repositoryTruck = new RepositoryTruck();
    }

    public void printCities() {
        List<String[]> csvFile = readCsv.read();
        String[] header = csvFile.get(0);
        String[] cities = header[0].split(";");
        for (int i = 0; i < cities.length; i++) {
            System.out.println(i + " - " + cities[i]);
        }
    }

    public void printTrucks(){
        Truck truckSmall = new SmallTruck();
        Truck truckMedium = new MediumTruck();
        Truck truckLarge = new LargeTruck();
        System.out.println(truckSmall);
        System.out.println(truckMedium);
        System.out.println(truckLarge);
    }

}
