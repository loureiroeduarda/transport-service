package com.github.loureiroeduarda.menu;

import com.github.loureiroeduarda.model.products.Cargo;
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
            System.out.println("===============================================");
            int chosenOption = sc.nextInt();
            sc.nextLine();
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
                case 0:
                    keepGoing = false;
                    break;
                default:
                    System.out.println("Opção inválida! Tente Novamente!!");
            }
        }
    }
    //TODO: Criar submenu de rotas, removendo da Service
    public void deliveryRouteMenu(Scanner sc) {}

    public void registerTransportMenu(Scanner sc) {
        System.out.println("Informe quantas cidades deseja cadastrar para realização do transporte: ");
        int cityCounter = sc.nextInt();
        sc.nextLine();
        validateCityCounter(cityCounter, sc);
        List<String> chosenCities = new ArrayList<>();
        for (int i = 0; i < cityCounter; i++) {
            System.out.println("Digite o número correspondente à cidade desejada: ");
            String cityCode = sc.nextLine();
            chosenCities.add(cityCode);
        }

        System.out.println("Produtos disponíveis para transporte: ");
        service.printProducts();
        System.out.println("Digite a quantidade de celulares que deseja transportar: ");
        int cellPhoneCounter = sc.nextInt();
        System.out.println("Digite a quantidade de geladeiras que deseja transportar: ");
        int refrigeratorCounter = sc.nextInt();
        System.out.println("Digite a quantidade de freezers que deseja transportar: ");
        int freezerCounter = sc.nextInt();
        System.out.println("Digite a quantidade de cadeiras que deseja transportar: ");
        int chairCounter = sc.nextInt();
        System.out.println("Digite a quantidade de luminárias que deseja transportar: ");
        int lightingCounter = sc.nextInt();
        System.out.println("Digite a quantidade de lavadoras de roupa que deseja transportar: ");
        int washingMachineCounter = sc.nextInt();

        Cargo cargo = new Cargo(cellPhoneCounter, refrigeratorCounter, freezerCounter,
                chairCounter, lightingCounter, washingMachineCounter);

        String cities = service.findCitiesNames(chosenCities);
        Double totalDistance = service.totalDistance(service.findingRouteDistance(chosenCities));
        Double totalCargoWeight = service.calculateTotalWeight(cargo);
        String products = service.findProductsNames(cargo);
        Double totalTransportValue = service.totalTransportValue(totalDistance);

        System.out.println("Os trechos selecionados foram: " + cities + ".");
        System.out.println("O total da distância a ser percorrida é de: " + totalDistance + "km");
        System.out.println("O peso total dos produtos transportados é de: " + totalCargoWeight + "km");
        System.out.println("Para transportes os produtos: " + products + ", " + "será necessária a utilização ");
        System.out.println("O valor total do transporte cadastrado é de R$ " + totalTransportValue + ", sendo que R$ ");

        /* TODO: Finalizar o print abaixo
       Os trechos selecionados foram: Porto Alegre, São Paulo e Cuiaba. O total da distância a ser percorrida é de X km.
       Para transportar os produtos, X, Y e Z será necessária a utilização de dois caminhões de porte pequeno, de forma
       a resultar o menor custo de transporte por km rodado.
       O valor total do transporte cadastrado é de R$ xxx, sendo que R$ xxxx corresponde ao custo unitário médio.
       */

    }

    private int validateCityCounter(int number, Scanner sc) {
        while (number < 0 || number >= 24) {
            System.out.println("Você pode selecionar apenas números de 0 à 23!! Tente novamente!!");
            number = sc.nextInt();
        }
        return number;
    }

}