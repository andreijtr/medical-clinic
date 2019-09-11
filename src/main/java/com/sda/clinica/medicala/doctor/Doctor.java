package com.sda.clinica.medicala.doctor;

import com.sda.clinica.medicala.consultation.ManagerConsultations;
import com.sda.clinica.medicala.model.Person;

public class Doctor extends Person {

    public ManagerConsultations managerConsultations;
    private String specialization;

    public Doctor(String firstName, String lastName, long CPN, String specialization) {
        super(firstName, lastName, CPN);
        this.specialization = specialization;
        this.managerConsultations = new ManagerConsultations();
    }

    @Override
    public String toString() {
        return "Doctor: " +
                firstName + ' ' +
                lastName + ' ' +
                ", CNP= " + CNP +
                " , specializare: " + specialization + ' '
                ;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }
}
