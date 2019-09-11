package com.sda.clinica.medicala.display;

import com.sda.clinica.medicala.consultation.Consultation;
import com.sda.clinica.medicala.utils.Consts;

public class DisplayData {

    public static void displayMessage (String message) {
        System.out.println(message);
    }

    public static void newLine() {
        System.out.println();
    }

    public static void displayConsultation(Consultation consultation) {
        System.out.println(consultation);
    }

    public static void displayMainMenu() {
        System.out.println(Consts.MAIN_MENU_FOR_PATIENT);
        System.out.println(Consts.MAIN_MENU_FOR_DOCTOR);
        System.out.println(Consts.MAIN_MENU_EXIT_APPLICATION);
    }

    public static void displayPatientMenu() {
        System.out.println(Consts.PATIENT_MENU_SCHEDULE_CONSULTATION);
        System.out.println(Consts.PATIENT_MENU_BACK_TO_MAIN_MENU);
    }

    public static void displayDoctorMenu() {
        System.out.println(Consts.DOCTOR_MENU_CHECK_CONSULTATIONS);
        System.out.println(Consts.DOCTOR_MENU_OFFER_CONSULTATION);
        System.out.println(Consts.DOCTOR_MENU_BACK_TO_MAIN_MENU);
    }
}
