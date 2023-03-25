package com.github.loureiroeduarda.service;

import com.github.loureiroeduarda.csv.ReadCsv;

import java.util.Arrays;
import java.util.List;

public class Service {
    private final ReadCsv readCsv;

    public Service() {
        this.readCsv = new ReadCsv();
    }

    public void printCities() {
        List<String[]> csvFile = readCsv.read();
        String[] header = csvFile.get(0);
        String[] cities = header[0].split(";");
        for (int i = 0; i < cities.length; i++) {
            System.out.println(i + " - " + cities[i]);
        }

    }

}
