package com.github.loureiroeduarda.repository;

import com.github.loureiroeduarda.csv.ReadCsv;

import java.util.ArrayList;
import java.util.List;

public class RepositoryCsv {
    private final ReadCsv readCsv;
    private List<String[]> csvReader;

    public RepositoryCsv() {
        this.readCsv = new ReadCsv();
        this.csvReader = new ArrayList<String[]>();
    }

    public void loadCitiesDistances() {
        this.csvReader = readCsv.read();
    }

    public List<String[]> getCsvReader() {
        return csvReader;
    }

    public String findDistance(int cityOrigin, int cityDestination) {
        List<String[]> csvFile = getCsvReader();
        String distanceBetweenCities = "";
        for (String[] line : csvFile) {
            String[] distances = line[0].split(";");
            if (distances[cityOrigin].equals("0")) {
                distanceBetweenCities = distances[cityDestination];
            }
        }
        return distanceBetweenCities;
    }

    public String printCityById(int index) {
        List<String[]> csvFile = getCsvReader();
        String[] header = csvFile.get(0);
        String[] cities = header[0].split(";");
        return cities[index];
    }

}
