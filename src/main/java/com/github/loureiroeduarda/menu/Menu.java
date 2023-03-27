package com.github.loureiroeduarda.menu;

import com.github.loureiroeduarda.repository.RepositoryProducts;
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

    public void registerTransportMenu(Scanner sc) {
        System.out.println("Informe quantas cidades deseja cadastrar para realização do transporte: ");
        int cityCounter = sc.nextInt();
        sc.nextLine();
        validateCityCounter(cityCounter, sc);
        List<String> chosenCities = new ArrayList<>();
        for(int i = 0; i < cityCounter; i++) {
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


    }

    private int validateCityCounter(int number, Scanner sc) {
        while (number < 0 || number >= 24) {
            System.out.println("Você pode selecionar apenas números de 0 à 23!! Tente novamente!!");
            number = sc.nextInt();
        }
        return number;
    }



}