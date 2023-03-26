package com.github.loureiroeduarda.service;

import com.github.loureiroeduarda.model.Truck;
import com.github.loureiroeduarda.repository.RepositoryCsv;
import com.github.loureiroeduarda.repository.RepositoryProducts;
import com.github.loureiroeduarda.repository.RepositoryTruck;

import java.util.List;
import java.util.Scanner;

public class Service {
    private final RepositoryCsv repositoryCsv;
    private final RepositoryTruck repositoryTruck;

    private final RepositoryProducts repositoryProducts;

    public Service() {
        this.repositoryCsv = new RepositoryCsv();
        this.repositoryTruck = new RepositoryTruck();
        this.repositoryProducts = new RepositoryProducts();
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
        for (int i = 0; i < truckList.size(); i++) {
            System.out.println(i + " - " + truckList.get(i));
        }

    }

    public void deliveryRoute(Scanner sc) {
        System.out.println("Digite o número [0 à 23] correspondente à cidade de origem: ");
        int cityOrigin = sc.nextInt();
        validateCityId(cityOrigin, sc);
        System.out.println("Digite o número [0 à 23] correspondente à cidade de destino: ");
        int cityDestination = sc.nextInt();
        validateCityId(cityDestination, sc);
        System.out.println("Digite o número [0 à 2] correspondente ao porte do caminhão [pequeno, médio e grande]: ");
        int truckId = sc.nextInt();
        validateTruckId(truckId, sc);

        Truck truck = repositoryTruck.getTruckById(truckId);
        String distance = repositoryCsv.findDistance(cityOrigin, cityDestination);

        System.out.println("A distância entre " + repositoryCsv.printCityById(cityOrigin) + " e "
                + repositoryCsv.printCityById(cityDestination)
                + " é " + distance + " km. " + "O custo do transporte, utilizando-se um caminhão de "
                + truck.getTruckType() + " é R$ " + shippingCost(truck, distance));
    }

    private int validateCityId(int index, Scanner sc) {
        while (index < 0 || index >= 24) {
            System.out.println("Este número não corresponde a nenhuma cidade cadastrada! Tente novamente!");
            index = sc.nextInt();
        }
        return index;
    }

    private int validateTruckId(int index, Scanner sc) {
        while (index < 0 || index >= 3) {
            System.out.println("Este número não corresponde ao porte dos caminhões cadastrados! Tente novamente!");
            index = sc.nextInt();
        }
        return index;
    }

    private Double shippingCost(Truck truck, String distance) {
        int distanceNumber = Integer.parseInt(distance);
        return distanceNumber * truck.getPriceKm();
    }

}
