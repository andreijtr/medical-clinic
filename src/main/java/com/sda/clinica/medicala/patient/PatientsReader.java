package com.sda.clinica.medicala.patient;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class PatientsReader {

    public List<Patient> readPatientsFromFile(String filePath) {
        List<Patient> patientsList = new LinkedList<>();

        File file = new File(filePath);

        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line = bufferedReader.readLine();

            while (line != null) {
                String[] elements = line.split(" ");

                Patient patient = new Patient(
                        elements[0],
                        elements[1],
                        Long.parseLong(elements[2]),
                        Long.parseLong(elements[3])
                );

                patientsList.add(patient);

                line = bufferedReader.readLine();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return patientsList;
    }
}
