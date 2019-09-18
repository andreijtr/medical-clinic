package com.sda.clinica.medicala.runner;

import com.sda.clinica.medicala.logic.ApplicationLogic;
import com.sda.clinica.medicala.patient.PatientReaderJson;
import com.sda.clinica.medicala.utils.Consts;

public class AppRunner {

    public static void main(String[] args) {

        ApplicationLogic applicationLogic = new ApplicationLogic();
        applicationLogic.runApplication();
    }
}
