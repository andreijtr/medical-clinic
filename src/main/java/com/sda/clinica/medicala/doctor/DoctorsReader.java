package com.sda.clinica.medicala.doctor;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class DoctorsReader {

    public List<Doctor> readDoctorsFromFile (String filePath) {
        List<Doctor> doctorList = new LinkedList<>();

        File file = new File(filePath);

        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line = bufferedReader.readLine();

            while (line != null) {
                String[] elements = line.split(" ");
                Doctor doctor = new Doctor(
                        elements[0],
                        elements[1],
                        Long.parseLong(elements[2]),
                        elements[3]);
                doctorList.add(doctor);
                line = bufferedReader.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return doctorList;
    }
}
