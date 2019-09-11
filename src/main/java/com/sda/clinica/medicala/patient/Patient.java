package com.sda.clinica.medicala.patient;

import com.sda.clinica.medicala.model.Person;

public class Patient extends Person {

    private long CNPOfPatientDoctor;

    public Patient(String firstName, String lastName, long CNP, long CNPOfFamilyDoctor) {
        super(firstName, lastName, CNP);
        this.CNPOfPatientDoctor = CNPOfFamilyDoctor;
    }

    public Patient() {
    }

    @Override
    public String toString() {
        return "Patient: " + firstName + " " + lastName + " CNP: " + CNP;
    }

    public long getCNPOfPatientDoctor() {
        return CNPOfPatientDoctor;
    }

    public void setCNPOfPatientDoctor(long CNPOfPatientDoctor) {
        this.CNPOfPatientDoctor = CNPOfPatientDoctor;
    }
}
