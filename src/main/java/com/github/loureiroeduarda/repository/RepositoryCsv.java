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

}
