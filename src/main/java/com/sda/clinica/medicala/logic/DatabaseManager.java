package com.sda.clinica.medicala.logic;

import com.sda.clinica.medicala.display.DisplayData;
import com.sda.clinica.medicala.doctor.Doctor;
import com.sda.clinica.medicala.doctor.DoctorsReader;
import com.sda.clinica.medicala.observer.Observer;
import com.sda.clinica.medicala.observer.Subject;
import com.sda.clinica.medicala.patient.Patient;
import com.sda.clinica.medicala.patient.PatientsReader;
import com.sda.clinica.medicala.utils.Consts;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class DatabaseManager implements Subject {

    private List<Observer> observerList;
    private Scanner scanner;

    private PatientsReader patientsReader;
    private DoctorsReader doctorsReader;

    private List<Patient> patientsList;
    private List<Doctor> doctorsList;

    public DatabaseManager() {
        this.observerList = new LinkedList<>();
        this.scanner = new Scanner(System.in);
        this.patientsReader = new PatientsReader();
        this.doctorsReader = new DoctorsReader();
        patientsList = patientsReader.readPatientsFromFile(Consts.PATH_TO_PATIENTS_FILE);
        doctorsList = doctorsReader.readDoctorsFromFile(Consts.PATH_TO_DOCTORS_FILE);
    }

    @Override
    public void registerObserver() {
        DisplayData.displayMessage(Consts.REGISTER_PATIENT_GIVE_FIRST_NAME);
    }

    public List<Patient> getPatientsList() {
        return this.patientsList;
    }

    public List<Doctor> getDoctorsList() {
        return this.doctorsList;
    }


}
