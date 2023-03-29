package com.github.loureiroeduarda.menu;

import com.github.loureiroeduarda.model.products.Cargo;
import com.github.loureiroeduarda.model.truck.BestTruckCombo;
import com.github.loureiroeduarda.service.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {
    private final Scanner sc;
    private final Service service;

    public Menu() {
        this.sc = new Scanner(System.in);
        this.service = new Service();
    }

    public void menu() {
        service.loadData();
        boolean keepGoing = true;
        while (keepGoing) {
            System.out.println("===============================================");
            System.out.println("Bem vindo ao sistema de Serviço de Transportes");
            System.out.println("Digite a opção desejada para: ");
            System.out.println("1 - Consultar trechos disponíveis para transporte");
            System.out.println("2 - Consultar modalidade de transporte");
            System.out.println("3 - Selecionar origem, destino e modalidade do transporte");
            System.out.println("4 - Cadastrar transporte/frete");
            System.out.println("0 - Encerrar o sistema");
            System.out.println("===============================================");
            String chosenOptionText = sc.nextLine();
            int chosenOption = service.convertStringToInt(chosenOptionText);
            switch (chosenOption) {
                case 1:
                    service.printCities();
                    break;
                case 2:
                    service.printTrucks();
                    break;
                case 3:
                    service.deliveryRoute(sc);
                    break;
                case 4:
                    registerTransportMenu(sc);
                    break;
                case 0:
                    keepGoing = false;
                    break;
                default:
                    System.out.println("Opção inválida! Tente Novamente!!");
            }
        }
    }

    public void registerTransportMenu(Scanner sc) {
        System.out.println("Informe quantas cidades deseja cadastrar para realização do transporte [2 à 23]: ");
        String cityCounterText = sc.nextLine();
        int cityCounter = service.convertStringToInt(cityCounterText);
        cityCounter = validateCityCounter(cityCounter, sc);

        List<String> chosenCities = new ArrayList<>();
        for (int i = 0; i < cityCounter; i++) {
            System.out.println("Digite o número correspondente à cidade desejada [0 à 23]: ");
            String cityCode = sc.nextLine();
            chosenCities.add(String.valueOf(validateCityCode(cityCode, sc)));
        }

        System.out.println("Produtos disponíveis para transporte: ");
        service.printProducts();

        System.out.println("Digite a quantidade de celulares que deseja transportar: ");
        String cellPhoneCounterText = sc.nextLine();
        int cellPhoneCounter = service.convertStringToInt(cellPhoneCounterText);
        validateProducts(cellPhoneCounter, sc);

        System.out.println("Digite a quantidade de geladeiras que deseja transportar: ");
        String refrigeratorCounterText = sc.nextLine();
        int refrigeratorCounter = service.convertStringToInt(refrigeratorCounterText);
        validateProducts(refrigeratorCounter, sc);

        System.out.println("Digite a quantidade de freezers que deseja transportar: ");
        String freezerCounterText = sc.nextLine();
        int freezerCounter = service.convertStringToInt(freezerCounterText);
        validateProducts(freezerCounter, sc);

        System.out.println("Digite a quantidade de cadeiras que deseja transportar: ");
        String chairCounterText = sc.nextLine();
        int chairCounter = service.convertStringToInt(chairCounterText);
        validateProducts(chairCounter, sc);

        System.out.println("Digite a quantidade de luminárias que deseja transportar: ");
        String lightingCounterText = sc.nextLine();
        int lightingCounter = service.convertStringToInt(lightingCounterText);
        validateProducts(lightingCounter, sc);

        System.out.println("Digite a quantidade de lavadoras de roupa que deseja transportar: ");
        String washingMachineCounterText = sc.nextLine();
        int washingMachineCounter = service.convertStringToInt(washingMachineCounterText);
        validateProducts(washingMachineCounter, sc);

        Cargo cargo = new Cargo(cellPhoneCounter, refrigeratorCounter, freezerCounter,
                chairCounter, lightingCounter, washingMachineCounter);

        String cities = service.findCitiesNames(chosenCities);
        Double totalDistance = service.totalDistance(service.findingRouteDistance(chosenCities));
        Double totalCargoWeight = service.calculateTotalWeight(cargo);
        String products = service.findProductsNames(cargo);
        BestTruckCombo bestTruckCombo = service.bestTruckCombo(totalCargoWeight);
        Double totalTransportValue = service.totalTransportValue(bestTruckCombo, totalDistance);
        Double averageShippingCost = service.averageShippingCost(bestTruckCombo, totalTransportValue);

        System.out.println("Os trechos selecionados foram: " + cities);
        System.out.println("O total da distância a ser percorrida é de: " + totalDistance + " km.");
        System.out.println("O peso total dos produtos a serem transportados é de: " + totalCargoWeight + " kg.");
        System.out.println("Para transportar os produtos: " + products + ", " + "será necessária a utilização de "
                + bestTruckCombo.getQuantityTrucks() + " caminhões de " + bestTruckCombo.getTruckType()
                + ", de forma a resultar o menor custo de transporte por km rodado.");
        System.out.println("O valor total do transporte cadastrado é de R$ " + totalTransportValue + ", sendo que R$ "
                + averageShippingCost + " corresponde ao custo unitário médio.");
    }

    private int validateCityCounter(int number, Scanner sc) {
        while (number < 2 || number >= 24) {
            System.out.println("Opção inválida! Tente Novamente!!");
            String cityCounter = sc.nextLine();
            number = service.convertStringToInt(cityCounter);
        }
        return number;
    }

    private int validateProducts(int quantityProducts, Scanner sc) {
        while (quantityProducts == Integer.MAX_VALUE) {
            System.out.println("Opção inválida! Tente Novamente!!");
            String quantityProductsText = sc.nextLine();
            quantityProducts = service.convertStringToInt(quantityProductsText);
        }
        return quantityProducts;
    }

    private int validateCityCode(String cityCode, Scanner sc) {
        int cityId = -1;
        try {
            cityId = Integer.parseInt(cityCode);
        } catch (NumberFormatException numberFormatException) {
            System.out.println("Opção inválida! Tente Novamente!!");
        }
        return service.validateCityId(cityId, sc);
    }
}