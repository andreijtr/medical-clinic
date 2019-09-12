package com.sda.clinica.medicala.logic;

import com.sda.clinica.medicala.display.DisplayData;
import com.sda.clinica.medicala.doctor.Doctor;
import com.sda.clinica.medicala.doctor.DoctorsReader;
import com.sda.clinica.medicala.patient.Patient;
import com.sda.clinica.medicala.patient.PatientsReader;
import com.sda.clinica.medicala.utils.Consts;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class DatabaseManager {

    private Scanner scanner;

    private PatientsReader patientsReader;
    private DoctorsReader doctorsReader;

    private List<Patient> patientsList;
    private List<Doctor> doctorsList;

    public DatabaseManager() {
        this.scanner = new Scanner(System.in);
        this.patientsReader = new PatientsReader();
        this.doctorsReader = new DoctorsReader();
        patientsList = patientsReader.readPatientsFromFile(Consts.PATH_TO_PATIENTS_FILE);
        doctorsList = doctorsReader.readDoctorsFromFile(Consts.PATH_TO_DOCTORS_FILE);
    }

    public void registerPatient() {
        DisplayData.displayMessage(Consts.REGISTER_PATIENT_GIVE_FIRST_NAME);
        String firstName = scanner.next();
        DisplayData.displayMessage(Consts.REGISTER_PATIENT_GIVE_LAST_NAME);
        String lastName = scanner.next();
        DisplayData.displayMessage(Consts.REGISTER_PATIENT_GIVE_CNP);
        long registerPatientCNP = scanner.nextLong();

        DisplayData.displayMessage(Consts.REGISTER_PATIENT_CHOOSE_DOCTOR);
        int i = 1;
        List<Doctor> familyDoctors = new LinkedList<>();

        for (Doctor d : doctorsList) {
            if(d.getSpecialization().equals(Consts.REGISTER_PATIENT_DOCTOR_SPECIALIZATION)) {
                DisplayData.displayMessage(i + ". " + d.getLastName() + " " + d.getFirstName() + " cnp: " + d.getCNP());
                i++;
                familyDoctors.add(d);
            }
        }

        int choosenDoctor = scanner.nextInt();
        long doctorCNP = 0;

        if (choosenDoctor < i && choosenDoctor != 0) {
            doctorCNP = familyDoctors.get(i - 1).getCNP();
        } else {
            DisplayData.displayMessage(Consts.OPTION_NOT_VALID);
        }
        Patient registeredPatient = new Patient(firstName, lastName, registerPatientCNP, doctorCNP);

        /**
         *linia urmatoare va face update la lista cu pacienti, iar fiecare meniu care va folosi lista din acest moment
         *o va avea actualizata prin intermediul DatabaseManager care returneaza mereu lista actualizata
         */
        patientsList.add(registeredPatient);

        //patientWriter.write(registeredPatient); ### ar trebui sa scrii si in fisier noul pacient ###
    }


    public List<Patient> getPatientsList() {
        return this.patientsList;
    }

    public List<Doctor> getDoctorsList() {
        return this.doctorsList;
    }


}
