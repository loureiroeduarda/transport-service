package com.github.loureiroeduarda.menu;

import com.github.loureiroeduarda.service.Service;

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
            System.out.println("1 - Consultar trechos disponíveis");
            System.out.println("2 - Consultar modalidade de transporte");
            System.out.println("3 - Selecionar origem, destino e modalidade do transporte");
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
                case 0:
                    keepGoing = false;
                    break;
                default:
                    System.out.println("Opção inválida! Tente Novamente!!");
            }
        }
    }
}