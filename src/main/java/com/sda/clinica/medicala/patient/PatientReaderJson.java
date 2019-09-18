package com.sda.clinica.medicala.patient;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class PatientReaderJson {

    public List<Patient> readPatientsFromJson(String jsonPath) {
        List<Patient> patients = new LinkedList<>();

        try {
            //reader va deschide un flux de citire din fisierul json
            Reader reader = new FileReader(jsonPath);
            JSONParser jsonParser = new JSONParser();

            //parsarea unui json prin aceasta metoda care primeste ca parametru un "Reader", returneaza un Object
            Object obj = jsonParser.parse(reader);
            //prin casting se obtine un JsonArray de obiecte
            JSONArray jsonArray = (JSONArray) obj;

            Iterator iterator = jsonArray.iterator();

            JSONObject jsonObjectInJsonArray;
            Object objectInJsonArray;

            while (iterator.hasNext()) {
                //extragem obiectul din JSONArray
                objectInJsonArray = iterator.next();
                jsonObjectInJsonArray = (JSONObject) objectInJsonArray;

                //acum construim obiectul pe baza datelor din jsonObjectInJsonArray

                String firstName = (String) jsonObjectInJsonArray.get("firstName");
                String lastName = (String) jsonObjectInJsonArray.get("lastName");
                long CNP = (long) jsonObjectInJsonArray.get("CNP");
                long CNPOfPatientDoctor = (long) jsonObjectInJsonArray.get("CNPOfPatientDoctor");

                Patient p = new Patient(firstName, lastName, CNP, CNPOfPatientDoctor);

                patients.add(p);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ParseException pex) {
            pex.printStackTrace();
        }

        return patients;
    }
}
