package com.sda.clinica.medicala.consultation;

import com.sda.clinica.medicala.patient.Patient;

public class Consultation {

    private Patient patient;
    private String reasonForConsultation;

    public Consultation(Patient patient, String reasonForConsultation) {
        this.patient = patient;
        this.reasonForConsultation = reasonForConsultation;
    }

    @Override
    public String toString() {
        return "Consultatie: " +
                patient +
                " motiv consultatie: " + reasonForConsultation + ' ';
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public String getReasonForConsultation() {
        return reasonForConsultation;
    }

    public void setReasonForConsultation(String reasonForConsultation) {
        this.reasonForConsultation = reasonForConsultation;
    }
}
