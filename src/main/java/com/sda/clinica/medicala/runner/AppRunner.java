package com.sda.clinica.medicala.runner;

import com.sda.clinica.medicala.logic.ApplicationLogic;

public class AppRunner {

    public static void main(String[] args) {

        ApplicationLogic applicationLogic = new ApplicationLogic();
        applicationLogic.runApplication();
    }
}
