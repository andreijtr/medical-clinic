package com.sda.clinica.medicala.patient;

import com.sda.clinica.medicala.model.Person;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Patient)) return false;
        Patient patient = (Patient) o;
        return super.CNP == patient.CNP;
    }


    public long getCNPOfPatientDoctor() {
        return CNPOfPatientDoctor;
    }

    public void setCNPOfPatientDoctor(long CNPOfPatientDoctor) {
        this.CNPOfPatientDoctor = CNPOfPatientDoctor;
    }
}
