package com.github.loureiroeduarda.service;

import com.github.loureiroeduarda.model.products.*;
import com.github.loureiroeduarda.model.transport.Transport;
import com.github.loureiroeduarda.model.truck.BestTruckCombo;
import com.github.loureiroeduarda.model.truck.Truck;
import com.github.loureiroeduarda.repository.RepositoryCsv;
import com.github.loureiroeduarda.repository.RepositoryProducts;
import com.github.loureiroeduarda.repository.RepositoryTransport;
import com.github.loureiroeduarda.repository.RepositoryTruck;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Service {
    private final RepositoryCsv repositoryCsv;
    private final RepositoryTruck repositoryTruck;
    private final RepositoryProducts repositoryProducts;

    private final RepositoryTransport repositoryTransport;

    public Service() {
        this.repositoryCsv = new RepositoryCsv();
        this.repositoryTruck = new RepositoryTruck();
        this.repositoryProducts = new RepositoryProducts();
        this.repositoryTransport = new RepositoryTransport();
    }

    public void loadData() {
        this.repositoryCsv.loadCitiesDistances();
        this.repositoryTruck.saveTrucks();
        this.repositoryProducts.saveProducts();
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

    public void printProducts() {
        List<Products> productsList = repositoryProducts.listAll();
        for (Products products : productsList) {
            System.out.println(products);
        }
    }

    public void deliveryRoute(Scanner sc) {
        System.out.println("Digite o número [0 à 23] correspondente à cidade de origem: ");
        String cityOriginText = sc.nextLine();
        int cityOrigin = convertStringToInt(cityOriginText);
        cityOrigin = validateCityId(cityOrigin, sc);

        System.out.println("Digite o número [0 à 23] correspondente à cidade de destino: ");
        String cityDestinationText = sc.nextLine();
        int cityDestination = convertStringToInt(cityDestinationText);
        cityDestination = validateCityId(cityDestination, sc);

        System.out.println("Digite o número [0 à 2] correspondente ao porte do caminhão [0 = pequeno, 1 = médio e " +
                "2 = grande]: ");
        String truckIdText = sc.nextLine();
        int truckId = convertStringToInt(truckIdText);
        truckId = validateTruckId(truckId, sc);

        Truck truck = repositoryTruck.getTruckById(truckId);
        String distance = repositoryCsv.findDistance(cityOrigin, cityDestination);

        System.out.println("A distância entre " + repositoryCsv.getCityById(cityOrigin) + " e "
                + repositoryCsv.getCityById(cityDestination)
                + " é " + distance + " km. " + "O custo do transporte, utilizando-se um caminhão de "
                + truck.getTruckType() + " é R$ " + shippingCost(truck, distance));
    }

    public int convertStringToInt(String text) {
        int optionInt = Integer.MAX_VALUE;
        try {
            optionInt = Integer.parseInt(text);
        } catch (NumberFormatException numberFormatException) {
            System.out.println("Você não digitou um número!!");
        }
        optionInt = validatePositiveNumber(optionInt);
        return optionInt;
    }

    private int validatePositiveNumber(int number) {
        if (number < 0) {
            return Integer.MAX_VALUE;
        }
        return number;
    }

    public int validateCityId(int index, Scanner sc) {
        while (index < 0 || index >= 24) {
            System.out.println("Cidade não existe!! Tente novamente!!");
            String cityId = sc.nextLine();
            index = convertStringToInt(cityId);
        }
        return index;
    }

    private int validateTruckId(int index, Scanner sc) {
        while (index < 0 || index >= 3) {
            System.out.println("Modalidade de caminhão não existe!! Tente novamente!!");
            String truckId = sc.nextLine();
            index = convertStringToInt(truckId);
        }
        return index;
    }

    private Double shippingCost(Truck truck, String distance) {
        int distanceNumber = Integer.parseInt(distance);
        return distanceNumber * truck.getPriceKm();
    }

    public List<String> findingRouteDistance(List<String> chosenCities) {
        List<String> listDistances = new ArrayList<>();
        List<String[]> csvFile = repositoryCsv.getCsvReader();

        for (String[] line : csvFile) {
            String[] distances = line[0].split(";");
            if (distances[Integer.parseInt(chosenCities.get(0))].equals("0")) {
                for (String chosenCity : chosenCities) {
                    listDistances.add(distances[Integer.parseInt(chosenCity)]);
                }
            }
        }
        return listDistances;
    }

    public Double totalDistance(List<String> listDistance) {
        List<Double> distance = listDistance.stream().map(Double::parseDouble).toList();

        double totalDistance = 0.0;
        for (Double i : distance) {
            totalDistance = +i;
        }
        return totalDistance;
    }

    public Double calculateTotalWeight(Cargo cargo) {
        List<Products> productsList = repositoryProducts.listAll();

        double totalCargoWeight = 0.0;
        for (Products product : productsList) {
            if (product instanceof CellPhone) {
                totalCargoWeight += product.getWeightProduct() * cargo.getCellPhoneCounter();
            }
            if (product instanceof Refrigerator) {
                totalCargoWeight += product.getWeightProduct() * cargo.getRefrigeratorCounter();
            }
            if (product instanceof Freezer) {
                totalCargoWeight += product.getWeightProduct() * cargo.getFreezerCounter();
            }
            if (product instanceof Chair) {
                totalCargoWeight += product.getWeightProduct() * cargo.getChairCounter();
            }
            if (product instanceof Lighting) {
                totalCargoWeight += product.getWeightProduct() * cargo.getLightingCounter();
            }
            if (product instanceof WashingMachine) {
                totalCargoWeight += product.getWeightProduct() * cargo.getWashingMachineCounter();
            }
        }
        return totalCargoWeight;
    }

    public BestTruckCombo bestTruckCombo(Double totalCargoWeight) {
        BestTruckCombo bestTruckCombo = new BestTruckCombo();
        List<Truck> truckList = repositoryTruck.listAll();

        for (Truck truck : truckList) {
            double assistantCalculation = (totalCargoWeight / truck.getWeight()) * truck.getPriceKm();
            if (assistantCalculation < bestTruckCombo.getBestCost()) {
                bestTruckCombo.setBestCost(assistantCalculation);
                bestTruckCombo.setTruckType(truck.getTruckType());
                bestTruckCombo.setQuantityTrucks(totalCargoWeight / truck.getWeight());
            }
        }
        return bestTruckCombo;
    }

    public Double totalTransportValue(BestTruckCombo bestTruckCombo, Double totalDistance) {
        return totalDistance * bestTruckCombo.getBestCost();
    }

    public Double averageShippingCost(BestTruckCombo bestTruckCombo, Double totalTransportValue) {
        return totalTransportValue / bestTruckCombo.getQuantityTrucks();
    }

    public String findCitiesNames(List<String> chosenCities) {
        StringBuilder cities = new StringBuilder();
        for (String city : chosenCities) {
            cities.append(repositoryCsv.getCityById(Integer.parseInt(city))).append(" ");
        }
        return cities.toString();
    }

    public String findProductsNames(Cargo cargo) {
        List<Products> productsList = repositoryProducts.listAll();
        List<String> products = new ArrayList<>();
        for (Products product : productsList) {
            if (product instanceof CellPhone && cargo.getCellPhoneCounter() > 0) {
                products.add(product.productType());
            }
            if (product instanceof Refrigerator && cargo.getRefrigeratorCounter() > 0) {
                products.add(product.productType());
            }
            if (product instanceof Freezer && cargo.getFreezerCounter() > 0) {
                products.add(product.productType());
            }
            if (product instanceof Chair && cargo.getChairCounter() > 0) {
                products.add(product.productType());
            }
            if (product instanceof Lighting && cargo.getLightingCounter() > 0) {
                products.add(product.productType());
            }
            if (product instanceof WashingMachine && cargo.getWashingMachineCounter() > 0) {
                products.add(product.productType());
            }
        }
        return products.toString();
    }

    public void saveTransport(Transport transport) {
        this.repositoryTransport.save(transport);
    }
}
