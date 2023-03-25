package com.github.loureiroeduarda.service;

import com.github.loureiroeduarda.model.Truck;
import com.github.loureiroeduarda.repository.RepositoryCsv;
import com.github.loureiroeduarda.repository.RepositoryTruck;

import java.util.List;
import java.util.Scanner;

public class Service {
    private final RepositoryCsv repositoryCsv;
    private final RepositoryTruck repositoryTruck;

    public Service() {
        this.repositoryCsv = new RepositoryCsv();
        this.repositoryTruck = new RepositoryTruck();
    }

    public void loadData() {
        this.repositoryCsv.loadCitiesDistances();
        this.repositoryTruck.saveTrucks();
    }

    public void printCities() {
        List<String[]> csvFile = repositoryCsv.getCsvReader();
        String[] header = csvFile.get(0);
        String[] cities = header[0].split(";");
        for (int i = 0; i < cities.length; i++) {
            System.out.println(i + " - " + cities[i]);
        }
    }

    public void printTrucks() {
        List<Truck> truckList = repositoryTruck.listAll();
        for (Truck truck : truckList) {
            System.out.println(truck);
        }

    }

    public void registerCities(Scanner sc) {
        System.out.println("Digite o número correspondente à cidade de origem: ");
        String cityOrigin = sc.nextLine();
        System.out.println("Digite o número correspondente à cidade de destino: ");
        String cityDestination = sc.nextLine();

    }

}
