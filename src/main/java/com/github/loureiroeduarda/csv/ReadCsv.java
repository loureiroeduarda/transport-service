package com.github.loureiroeduarda.csv;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.List;

public class ReadCsv {
    public List<String[]> read() {

        try {
            Reader reader = Files.newBufferedReader(Paths.get("src/main/resources/DNIT-Distancias.csv"));
            CSVReader csvReader = new CSVReaderBuilder(reader).build();

            return csvReader.readAll();

        } catch (NoSuchFileException noSuchFileException) {
            System.out.println("Arquivo não encontrado.");
        } catch (IOException ioException) {
            System.out.println("Leitura interrompida");
        } catch (CsvException csvException) {
            System.out.println("Arquivo corrompido");
        }
        return null;
    }

}
